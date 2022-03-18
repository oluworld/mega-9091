package org.oluworld.netapps.thinMMS;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import javax.swing.JFrame;
import javax.swing.JTextField;
import thinlet.FrameLauncher;
import thinlet.Thinlet;

public class ThinMMS extends Thinlet {
   private ThinMMS.CustomUrlHandler m_X = null;
   private SecondaryWindow sq = null;
   private final String path = "thinmms.xml";

   public ThinMMS() {
      try {
         this.add(this.parse("thinmms.xml"));
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public void jt_actionPerformed(JTextField ajt, ActionEvent e) {
      String requested = ajt.getText();

      try {
         this.sq.navigate(requested, this.new_X());
      } catch (IOException var5) {
         System.out.println("user entered bad url (above)");
      }

   }

   public ThinMMS.CustomUrlHandler new_X() {
      if (this.m_X == null) {
         this.m_X = new ThinMMS.CustomUrlHandler();
      }

      return this.m_X;
   }

   private String iHateElmo(Exception t) {
      String s = "";
      PrintWriter ss = new PrintWriter(new StringWriter());
      t.printStackTrace(ss);
      String M = ss.toString();
      String R = "<a href=\"elmo:411\">Hello</a><pre>" + s + "</pre><br><pre>" + M + "</pre>";
      return R;
   }

   public void calculate(String number1, String number2, Object result) {
      try {
         int i1 = Integer.parseInt(number1);
         int i2 = Integer.parseInt(number2);
         this.setString(result, "text", String.valueOf(i1 + i2));
      } catch (NumberFormatException var6) {
         this.getToolkit().beep();
      }

   }

   public void connectToNewRoot(String rootName, String sportnum) {
      try {
         int var3 = Integer.parseInt(sportnum);
      } catch (NumberFormatException var7) {
         this.getToolkit().beep();
         String nfet = this.iHateElmo(var7);
         this.sq = new SecondaryWindow(this);
         Container v = this.sq.createContent(nfet);
         JFrame f = new JFrame("title");
         f.getContentPane().add(v);
         f.setSize(450, 200);
         f.show();
      }

   }

   public static void main(String[] args) {
      new FrameLauncher("MMSView", new ThinMMS(), 420, 140);
   }

   public class CustomUrlHandler extends URLStreamHandler {
      protected URLConnection openConnection(URL u) throws IOException {
         return ThinMMS.this.new CustomUrlConnection(u);
      }
   }

   public class CustomUrlConnection extends URLConnection {
      public CustomUrlConnection(URL u) {
         super(u);
      }

      public InputStream getInputStream() throws IOException {
         String s = "hellooooooooooooooooo<br><pre>" + super.url + "</pre>";
         return new StringBufferInputStream(s);
      }

      public OutputStream getOutputStream() throws IOException {
         return super.getOutputStream();
      }

      public void connect() throws IOException {
         System.out.println("CustomUrlConnection::connect");
      }
   }
}

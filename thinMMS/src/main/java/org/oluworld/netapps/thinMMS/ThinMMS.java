package org.oluworld.netapps.thinMMS;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import javax.swing.Box;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

import thinlet.FrameLauncher;
import thinlet.Thinlet;

public class ThinMMS extends Thinlet {
   private ThinMMS.CustomUrlHandler m_X = null;
   private SecondaryWindow sq = null;
   private final String path = "thinmms.xml";

   public ThinMMS() {
      try {
         this.add(this.parse(path));
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
         this.m_X = new CustomUrlHandler();
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

   public static class CustomUrlHandler extends URLStreamHandler {
      protected URLConnection openConnection(URL u) throws IOException {
         return new CustomUrlConnection(u);
      }
   }

   public static class CustomUrlConnection extends URLConnection {
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

   class ThinMMS$1 implements HyperlinkListener {

      public void hyperlinkUpdate(HyperlinkEvent e) {
         sq.hul_hyperlinkUpdate(e);
      }

      class Hyperactive implements HyperlinkListener {
         public void hyperlinkUpdate(HyperlinkEvent e) {
            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
               JEditorPane pane = (JEditorPane)e.getSource();
               if (e instanceof HTMLFrameHyperlinkEvent) {
                  HTMLFrameHyperlinkEvent evt = (HTMLFrameHyperlinkEvent)e;
                  HTMLDocument doc = (HTMLDocument)pane.getDocument();
                  doc.processHTMLFrameHyperlinkEvent(evt);
               } else {
                  try {
                     pane.setPage(e.getURL());
                  } catch (Throwable var5) {
                     var5.printStackTrace();
                  }
               }
            }

         }
      }
   }

   static class ThinMMS$2 implements ActionListener {
      // $FF: synthetic field
      private final ThinMMS val$parent;
      // $FF: synthetic field
      private final JTextField val$jt;

      private final SecondaryWindow this$1;

      ThinMMS$2(SecondaryWindow this$1, ThinMMS val$parent, JTextField val$jt) {
         this.this$1 = this$1;
         this.val$parent = val$parent;
         this.val$jt = val$jt;
      }

      public void actionPerformed(ActionEvent e) {
         this.val$parent.jt_actionPerformed(this.val$jt, e);
      }
   }

   static class ThinMMS$Hyperactive implements HyperlinkListener {
      public void hyperlinkUpdate(HyperlinkEvent e) {
         if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            JEditorPane pane = (JEditorPane)e.getSource();
            if (e instanceof HTMLFrameHyperlinkEvent) {
               HTMLFrameHyperlinkEvent evt = (HTMLFrameHyperlinkEvent)e;
               HTMLDocument doc = (HTMLDocument)pane.getDocument();
               doc.processHTMLFrameHyperlinkEvent(evt);
            } else {
               try {
                  URL url = e.getURL();
                  String ss = e.getDescription();
                  if (url == null) {
                     ThinMMS.access$000(ss);
                  } else {
                     ThinMMS.access$100(url);
                  }
               } catch (IOException var5) {
                  var5.printStackTrace();
               }
            }
         }

      }
   }

   private static void access$100(URL url) throws IOException {
      int y=2;
   }

   private static void access$000(String ss) throws IOException {
      int y=2;
   }

   class SecondaryWindow1 {
      private JEditorPane editpane;
      // $FF: synthetic field
      private final ThinMMS this$0;

      SecondaryWindow1(ThinMMS this$0) {
         this.this$0 = this$0;
      }

      public void navigate(String requested) throws IOException {
         this.navigate(requested, this$0.m_X);
      }

      public void navigate(String requested, ThinMMS.CustomUrlHandler handler) throws IOException {
         System.out.println("requested " + requested);
         URL url = new URL((URL)null, requested, handler);
         this.navigate(url);
      }

      public void navigate(URL requested_url) throws IOException {
         String requested = requested_url.toString();
         System.out.println("requested " + requested);
         this.editpane.setPage(requested_url);
      }

      public Container createContent(ThinMMS parent, String nfet) {
         this.editpane = new JEditorPane("text/html", nfet);
         this.editpane.setEditable(false);
         this.editpane.addHyperlinkListener(new ThinMMS$1(/*this, parent*/));
         JTextField jt = new JTextField();
         jt.addActionListener(new ThinMMS$2(sq, parent, jt));
         Container v = Box.createVerticalBox();
         v.add(jt);
         v.add(this.editpane);
         return v;
      }
   }

   class X extends URLStreamHandler {
      protected URLConnection openConnection(URL u) throws IOException {
         return new Y(u);
      }
   }

   static class Y extends URLConnection {

      public Y(URL u) {
         super(u);
      }

      public InputStream getInputStream() throws IOException {
         return new StringBufferInputStream("hellooooooooooooooooo");
      }

      public OutputStream getOutputStream() throws IOException {
         return super.getOutputStream();
      }

      public void connect() throws IOException {
         System.out.println("Y::connect");
      }
   }



}

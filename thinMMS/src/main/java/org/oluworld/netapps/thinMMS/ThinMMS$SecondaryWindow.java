package org.oluworld.netapps.thinMMS;

import java.awt.Container;
import java.io.IOException;
import java.net.URL;
import javax.swing.Box;
import javax.swing.JEditorPane;
import javax.swing.JTextField;

class ThinMMS$SecondaryWindow {
   private JEditorPane editpane;
   // $FF: synthetic field
   private final ThinMMS this$0;

   ThinMMS$SecondaryWindow(ThinMMS this$0) {
      this.this$0 = this$0;
   }

   public void navigate(String requested) throws IOException {
      this.navigate(requested, ThinMMS.access$000(this.this$0));
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
      this.editpane.addHyperlinkListener(new ThinMMS$1(this, parent));
      JTextField jt = new JTextField();
      jt.addActionListener(new ThinMMS$2(this, parent, jt));
      Container v = Box.createVerticalBox();
      v.add(jt);
      v.add(this.editpane);
      return v;
   }
}

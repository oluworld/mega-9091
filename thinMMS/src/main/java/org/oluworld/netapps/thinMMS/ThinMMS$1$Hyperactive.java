package org.oluworld.netapps.thinMMS;

import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent.EventType;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

class ThinMMS$1$Hyperactive implements HyperlinkListener {
   // $FF: synthetic field
   private final ThinMMS this$0;

   ThinMMS$1$Hyperactive(ThinMMS this$0) {
      this.this$0 = this$0;
   }

   public void hyperlinkUpdate(HyperlinkEvent e) {
      if (e.getEventType() == EventType.ACTIVATED) {
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

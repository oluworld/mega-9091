package org.oluworld.netapps.thinMMS;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

class ThinMMS$1 implements HyperlinkListener {
   // $FF: synthetic field
   private final ThinMMS val$parent;
   // $FF: synthetic field
   private final ThinMMS$SecondaryWindow this$1;

   ThinMMS$1(ThinMMS$SecondaryWindow this$1, ThinMMS val$parent) {
      this.this$1 = this$1;
      this.val$parent = val$parent;
   }

   public void hyperlinkUpdate(HyperlinkEvent e) {
      this.val$parent.hul_hyperlinkUpdate(e);
   }
}

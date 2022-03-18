package org.oluworld.netapps.thinMMS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

class ThinMMS$2 implements ActionListener {
   // $FF: synthetic field
   private final ThinMMS val$parent;
   // $FF: synthetic field
   private final JTextField val$jt;
   // $FF: synthetic field
   private final ThinMMS$SecondaryWindow this$1;

   ThinMMS$2(ThinMMS$SecondaryWindow this$1, ThinMMS val$parent, JTextField val$jt) {
      this.this$1 = this$1;
      this.val$parent = val$parent;
      this.val$jt = val$jt;
   }

   public void actionPerformed(ActionEvent e) {
      this.val$parent.jt_actionPerformed(this.val$jt, e);
   }
}

package org.oluworld.netapps.thinMMS;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

class ThinMMS$X extends URLStreamHandler {
   // $FF: synthetic field
   private final ThinMMS this$0;

   ThinMMS$X(ThinMMS this$0) {
      this.this$0 = this$0;
   }

   protected URLConnection openConnection(URL u) throws IOException {
      return new ThinMMS$Y(this.this$0, u);
   }
}

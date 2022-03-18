package org.oluworld.netapps.thinMMS;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringBufferInputStream;
import java.net.URL;
import java.net.URLConnection;

class ThinMMS$Y extends URLConnection {
   // $FF: synthetic field
   private final ThinMMS this$0;

   public ThinMMS$Y(ThinMMS this$0, URL u) {
      super(u);
      this.this$0 = this$0;
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

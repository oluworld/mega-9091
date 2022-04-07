package org.oluworld.netapps.thinMMS;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.Box;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent.EventType;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

public class SecondaryWindow {

    private JEditorPane editpane;
    ThinMMS parent;

    public SecondaryWindow(ThinMMS aParent) {
        this.parent = aParent;
    }

    public void hul_hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == EventType.ACTIVATED) {
            JEditorPane pane = (JEditorPane) e.getSource();
            if (e instanceof HTMLFrameHyperlinkEvent) {
                HTMLFrameHyperlinkEvent evt = (HTMLFrameHyperlinkEvent) e;
                HTMLDocument doc = (HTMLDocument) pane.getDocument();
                doc.processHTMLFrameHyperlinkEvent(evt);
            } else {
                try {
                    URL url = e.getURL();
                    String ss = e.getDescription();
                    if (url == null) {
                        this.navigate(ss, this.parent.new_X());
                    } else {
                        this.navigate(url);
                    }
                } catch (IOException var5) {
                    var5.printStackTrace();
                }
            }
        }

    }

    public void navigate(String requested) throws IOException {
        this.navigate(requested, this.parent.new_X());
    }

    public void navigate(String requested, ThinMMS.CustomUrlHandler handler) throws IOException {
        System.out.println("requested " + requested);
        URL url = new URL((URL) null, requested, handler);
        this.navigate(url);
    }

    public void navigate(URL requested_url) throws IOException {
        String requested = requested_url.toString();
        System.out.println("requested " + requested);
        this.editpane.setPage(requested_url);
    }

    public Container createContent(String nfet) {
        this.editpane = new JEditorPane("text/html", nfet);
        this.editpane.setEditable(false);
        this.editpane.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                SecondaryWindow.this.hul_hyperlinkUpdate(e);
            }
        });
        final JTextField jt = new JTextField();
        jt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SecondaryWindow.this.parent.jt_actionPerformed(jt, e);
            }
        });
        Container v = Box.createVerticalBox();
        v.add(jt);
        v.add(this.editpane);
        return v;
    }
}

package tripleo.taliyah;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import tripleo.impohrt.FreeBASE.*;
import tripleo.taliyah.swingui.TaliyahForm;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * Date: Aug 1, 2005 Time: 1:39:51 AM
 * <p/>
 * $Id: Taliyah.java,v 1.1 2005/08/06 18:30:45 olu Exp $
 */
public class Taliyah {

    private final PlugIn defaultPlugIn = new PlugIn();

    static class HelloCommand {

        void initialize() {
        }

        // Show the hello dialog
        void say_hello(Slot my_slot) {
            // get the system command manager
            MenuManager cmd_mgr = (MenuManager) my_slot.get("/system/ui/commands").manager;

            // invoke the MessageBox command to display our message
            cmd_mgr.command("App/Services/MessageBox").invoke("Hello", "Hello World!");
        }

        // Show the goodbye dialog
        void say_goodbye(Slot my_slot) {

            Slot v_slot = my_slot.get("/system/properties/version");  // get the slot that holds the FreeRIDE version number
            MenuManager cmd_mgr = (MenuManager) my_slot.get("/system/ui/commands").manager; // get the system command manager

            // invoke the MessageBox command to display our message
            cmd_mgr.command("App/Services/MessageBox").invoke("Goodbye",
                    "Goodbye World!\n\nYou are running FreeRide version //{v_slot['major'].data}.//{v_slot['minor'].data}.//{v_slot['release'].data}");
        }

    }

    HelloCommand the_cmd_object = new HelloCommand();

    class a1 implements Invokable {

        public void command(Slot cmd_slot) {
            // This code is executed whenever our command is invoked
            the_cmd_object.say_hello(cmd_slot);
            the_cmd_object.say_goodbye(cmd_slot);
        }
    }

    void m() {
        PlugIn plugin = defaultPlugIn;
        plugin.get("/system/ui/commands").manager.add("Examples/Hello", "&Hello World", new a1());

        Manager tools_menu = plugin.get("/system/ui/components/MenuPane/Tools_menu").manager;
        ((MenuManager) tools_menu).add_command("Examples/Hello");
        plugin.transition(Constants.RUNNING);
    }

    public static void main(String[] args) {
        new Taliyah()._main(args);
    }

    public void _main(String[] args) {
//		Runnable runnable = new Runnable() {public void run() {mm();}};
//		new Thread(runnable).start();

        initshit();
        Runnable runnable2 = new Runnable() {
            public void run() {
                createFrame();
            }
        };
        m();
        new Thread(runnable2).start();
    }

    void createFrame() {
        TaliyahForm f = new TaliyahForm();
        JFrame frame = new JFrame("Form Preview");
        frame.setContentPane(f.myComponent);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic(70);
        JMenuItem menuItemExit = new JMenuItem(new TaliyahForm.MyExitAction());
        menuFile.add(menuItemExit);
        menuBar.add(menuFile);
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic(86);
        viewMenu.add(new JMenuItem(new TaliyahForm.MyPackAction(frame)));
        viewMenu.addSeparator();
        menuBar.add(viewMenu);
        UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo laf : lafs) {
            viewMenu.add(new TaliyahForm.MySetLafAction(frame, laf));
        }

        frame.pack();
        frame.addWindowListener(new TaliyahForm.MyWindowListener());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width - frame.getWidth()) / 2, (screenSize.height - frame.getHeight()) / 2);
        frame.show();
    }

    private void initshit() {

        try {
            XMLReader r = XML.makeXMLReader();
            r.setContentHandler(new xSink());
            r.parse(new InputSource("example.xml"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Manager nullManager = new Manager();
        Manager uiCommandManager = new Manager();
        defaultPlugIn.put("/system/ui/commands", new Slot(uiCommandManager));
        MenuManager toolsMenuManager = new MenuManager();
        defaultPlugIn.put("/system/ui/components/MenuPane/Tools_menu", new Slot(toolsMenuManager));
        defaultPlugIn.put("App/Services/MessageBox", new Slot(toolsMenuManager));
        defaultPlugIn.put("/system/properties/version", new Slot(toolsMenuManager));
        nullManager.put("/system/properties/version", new Slot(toolsMenuManager));
        the_cmd_object.say_goodbye(new Slot(nullManager));
    }
}

class xSink extends DefaultHandler implements ContentHandler {

    public @Override
    void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        s.trim();
        if (s.length() > 0) {
            print("characters", s);
        }
        cur.chars(s);
    }

    private void print(String context, String text) {
        System.out.println(context + ": \"" + text + "\"");

    }

    public @Override
    void endElement(String uri, String localName, String qName) throws SAXException {
//		super.endElement(uri, localName, qName);
        print("endElement", qName);
//		cur=cur.prev();
    }

    public @Override
    void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        print("startElement", qName);
        final Map<String, String> htab = new Hashtable<String, String>();
        for (int j = 0; j < attributes.getLength(); j++) {
            String qname = attributes.getQName(j),
                    value = attributes.getValue(j);
            htab.put(qname, value);
        }
        if (qName.equals("node")) {
            String path;
            String /*Class*/ jclz;
            path = htab.get("path");
            jclz = htab.get("jclass");
            cur = new Node(path, jclz, htab);
            cur.load();
        }
        if (qName.equals("list")) {
            String path;
            String /*Class*/ jclz;
            path = htab.get("path");
            jclz = htab.get("jitemclass");
            cur = new ListNode(path, jclz, htab);
            cur.load();
        } else {
            for (int j = 0; j < attributes.getLength(); j++) {
                String qname = attributes.getQName(j),
                        value = attributes.getValue(j);
                print("  attr", qname + " " + value);
            }
        }
    }

    interface X {

        void load();

        void chars(String s);
    }

    static class Node implements X {

        public Node(String aPath, String aJclz, Map<String, String> aHtab) {
            path = aPath;
            jclz = aJclz;
            htab = aHtab;
        }

        String path;
        String jclz;
        Map<String, String> htab;

        public void load() {
            Class jclzz;
            try {
                jclzz = Class.forName(htab.get("jclass"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void chars(String s) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    static class ListNode implements X {

        public void load() {
        }

        public void chars(String s) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public ListNode(String aPath, String aJclz, Map<String, String> aHtab) {
            path = aPath;
            jclz = aJclz;
            htab = aHtab;
        }

        String path;
        String jclz;
        Map<String, String> htab;

    }

    X cur;

}

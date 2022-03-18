/*
 * Date: Oct 9, 2003
 * Time: 7:34:57 PM
 */
package tripleo.histore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import tripleo.util.Assert;
import tripleo.histore.j1.HiStore_J1;

class ViewerFrame {

	public static void main(String[] args) {
		String s = args.length > 0 ? args[0] : "backing";
		HiStore_J1 his;
		try {
			his = HiStore_J1.New(s);
			new ViewerFrame(his);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	HiStore_J1 myStore;
	JTextArea ta;
	Object tao;
	JTextField tf, ef;
	Object tfo;

	public ViewerFrame(HiStore_J1 aStore) {
		myStore = aStore;
		initComponents();
		setURL("00000000");
	}

	private void initComponents() {
		final JFrame f = new JFrame();
		final Box b = Box.createVerticalBox();
		tf = new JTextField();
		ef = new JTextField();
		ta = new JTextArea();
		//
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_actionPerformed(e, tf, tfo);
			}
		});
		//
		JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		final Box pp = Box.createVerticalBox();
		final Box p1 = Box.createHorizontalBox();
		pp.add(tf);
		p1.add(ef);
		p1.add(new JButton("prev"));
		p1.add(new JButton("next"));
		p1.add(new JButton("all"));
		pp.add(p1);

		sp.setLeftComponent(pp);
		sp.setRightComponent(new JScrollPane(ta));
		b.add(sp);
		//
		f.getContentPane().add(b);
		f.setSize(500, 600);
		f.setVisible(true);
	}

	public void setURL(String aURL) {
		tao = urlToContents(aURL);
		ta.setText((String)tao);
		tf.setText(aURL);
	}

	public void showError(String anErrorString) {
		ef.setText(anErrorString);
	}

	public void tf_actionPerformed(ActionEvent e, JComponent o, Object m) {
		String s = ((JTextField)o).getText();
		if (s.charAt(0)=='#') {
			try {
				myStore = HiStore_J1.New(s.substring(1));
				setURL("00000000");
			} catch (InitializationFailure e1) {
				PrintWriter sss = new PrintWriter(new StringWriter());
				e1.printStackTrace(sss);
				ta.setText(sss.toString());
			}
		} else setURL(s);
	}


	public String urlToContents(String aURL) {
		String R;
		final File file = new File(myStore.backing(), aURL);
		if (!file.exists()) {
//			Assert.not_reached();
			// handle 404
			R = "404 404 404 404 404 404 404 404 404 404 404 404 ";
			showError("404");
		} else {
			byte[] bbuf ;
			final int L = Math.min(new Long(file.length()).intValue(), 0x0fffffff);
			bbuf = new byte[L];
			InputStream fr = null;
			try {
				fr = new FileInputStream(file);
				fr.read(bbuf);
			} catch (FileNotFoundException e) {
				Assert.not_reached();
			} catch (IOException e) {
				Assert.not_reached();
			}
			R = new String(bbuf);
		}
		return R;
	}
}


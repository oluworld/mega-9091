package tripleo.cottontail.jviewer;

import javax.swing.*;

/**
 * Date: Feb 5, 2005
 * Time: 11:39:20 PM
 * <p/>
 * $Id: SourceView.java,v 1.1.1.1 2005/02/20 02:07:31 olu Exp $
 */
public class SourceView {
	private JList list1, list2;
	private JTextPane textPane1;
	private JTabbedPane tabbedPane1;
	private String textArea1Str;
	private String textPane1Str;

	public String getTextArea1Str() {
		return textArea1Str;
	}

	public void setTextArea1Str(final String aTextArea1Str) {
		textArea1Str = aTextArea1Str;
	}

	public String getTextPane1Str() {
		return textPane1Str;
	}

	public void setTextPane1Str(final String aTextPane1Str) {
		textPane1Str = aTextPane1Str;
	}

	public void setData(SourceView data) {
	}

	public void getData(SourceView data) {
	}

	public boolean isModified(SourceView data) {
		return false;
	}
}

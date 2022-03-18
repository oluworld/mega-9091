package tripleo.cottontail.viewer;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;

// Referenced classes of package org.eclipse.swt.examples.controlexample:
//			Tab, ControlExample

abstract class ScrollableTab extends Tab {

	ScrollableTab(ControlExample instance) {
		super(instance);
	}

	void createStyleGroup() {
		super.createStyleGroup();
		singleButton = new Button(styleGroup, 16);
		singleButton.setText("SWT.SINGLE");
		multiButton = new Button(styleGroup, 16);
		multiButton.setText("SWT.MULTI");
		horizontalButton = new Button(styleGroup, 32);
		horizontalButton.setText("SWT.H_SCROLL");
		horizontalButton.setSelection(true);
		verticalButton = new Button(styleGroup, 32);
		verticalButton.setText("SWT.V_SCROLL");
		verticalButton.setSelection(true);
		borderButton = new Button(styleGroup, 32);
		borderButton.setText("SWT.BORDER");
	}

	void setExampleWidgetState() {
		super.setExampleWidgetState();
		Control controls[] = getExampleWidgets();
		if (controls.length != 0) {
			singleButton.setSelection((controls[0].getStyle() & 4) != 0);
			multiButton.setSelection((controls[0].getStyle() & 2) != 0);
			horizontalButton.setSelection((controls[0].getStyle() & 0x100) != 0);
			verticalButton.setSelection((controls[0].getStyle() & 0x200) != 0);
			borderButton.setSelection((controls[0].getStyle() & 0x800) != 0);
		}
	}

	Button singleButton;
	Button multiButton;
	Button horizontalButton;
	Button verticalButton;
	Button borderButton;
}

package tripleo.cottontail.viewer;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

// Referenced classes of package org.eclipse.swt.examples.controlexample:
//			Tab, ControlExample
abstract class AlignableTab extends Tab {

    AlignableTab(ControlExample anInstance) {
        super(anInstance);
    }

    void createControlGroup() {
        super.createControlGroup();
        alignmentGroup = new Group(controlGroup, 0);
        alignmentGroup.setLayout(new GridLayout());
        alignmentGroup.setLayoutData(new GridData(272));
        alignmentGroup.setText(ControlExample.getResourceString("Alignment"));
        leftButton = new Button(alignmentGroup, 16);
        leftButton.setText(ControlExample.getResourceString("Left"));
        centerButton = new Button(alignmentGroup, 16);
        centerButton.setText(ControlExample.getResourceString("Center"));
        rightButton = new Button(alignmentGroup, 16);
        rightButton.setText(ControlExample.getResourceString("Right"));
        org.eclipse.swt.events.SelectionListener selectionListener = new SelectionAdapter() {

            public void widgetSelected(SelectionEvent event) {
                if (!((Button) event.widget).getSelection()) {
                    return;
                } else {
                    setExampleWidgetAlignment();
                    return;
                }
            }

        };
        leftButton.addSelectionListener(selectionListener);
        centerButton.addSelectionListener(selectionListener);
        rightButton.addSelectionListener(selectionListener);
    }

    abstract void setExampleWidgetAlignment();

    void setExampleWidgetState() {
        super.setExampleWidgetState();
        Control controls[] = getExampleWidgets();
        if (controls.length != 0) {
            leftButton.setSelection((controls[0].getStyle() & 0x4000) != 0);
            centerButton.setSelection((controls[0].getStyle() & 0x1000000) != 0);
            rightButton.setSelection((controls[0].getStyle() & 0x20000) != 0);
        }
    }

    Button leftButton;
    Button rightButton;
    Button centerButton;
    Group alignmentGroup;
}

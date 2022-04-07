package tripleo.cottontail.viewer;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

// Referenced classes of package org.eclipse.swt.examples.controlexample:
//			AlignableTab, ControlExample
class ButtonTab extends AlignableTab {

    ButtonTab(ControlExample instance) {
        super(instance);
    }

    void createControlGroup() {
        super.createControlGroup();
        upButton = new Button(alignmentGroup, 16);
        upButton.setText(ControlExample.getResourceString("Up"));
        downButton = new Button(alignmentGroup, 16);
        downButton.setText(ControlExample.getResourceString("Down"));
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
        upButton.addSelectionListener(selectionListener);
        downButton.addSelectionListener(selectionListener);
    }

    void createExampleGroup() {
        super.createExampleGroup();
        textButtonGroup = new Group(exampleGroup, 0);
        GridLayout gridLayout = new GridLayout();
        textButtonGroup.setLayout(gridLayout);
        gridLayout.numColumns = 3;
        textButtonGroup.setLayoutData(new GridData(784));
        textButtonGroup.setText(ControlExample.getResourceString("Text_Buttons"));
        imageButtonGroup = new Group(exampleGroup, 0);
        gridLayout = new GridLayout();
        imageButtonGroup.setLayout(gridLayout);
        gridLayout.numColumns = 3;
        imageButtonGroup.setLayoutData(new GridData(784));
        imageButtonGroup.setText(ControlExample.getResourceString("Image_Buttons"));
    }

    void createExampleWidgets() {
        int style = getDefaultStyle();
        if (pushButton.getSelection()) {
            style |= 8;
        }
        if (checkButton.getSelection()) {
            style |= 0x20;
        }
        if (radioButton.getSelection()) {
            style |= 0x10;
        }
        if (toggleButton.getSelection()) {
            style |= 2;
        }
        if (flatButton.getSelection()) {
            style |= 0x800000;
        }
        if (borderButton.getSelection()) {
            style |= 0x800;
        }
        if (leftButton.getSelection()) {
            style |= 0x4000;
        }
        if (rightButton.getSelection()) {
            style |= 0x20000;
        }
        if (arrowButton.getSelection()) {
            style |= 4;
            if (upButton.getSelection()) {
                style |= 0x80;
            }
            if (downButton.getSelection()) {
                style |= 0x400;
            }
        } else if (centerButton.getSelection()) {
            style |= 0x1000000;
        }
        button1 = new Button(textButtonGroup, style);
        button1.setText(ControlExample.getResourceString("One"));
        button2 = new Button(textButtonGroup, style);
        button2.setText(ControlExample.getResourceString("Two"));
        button3 = new Button(textButtonGroup, style);
        button3.setText(ControlExample.getResourceString("Three"));
        button4 = new Button(imageButtonGroup, style);
        button4.setImage(instance.images[0]);
        button5 = new Button(imageButtonGroup, style);
        button5.setImage(instance.images[1]);
        button6 = new Button(imageButtonGroup, style);
        button6.setImage(instance.images[2]);
    }

    void createStyleGroup() {
        super.createStyleGroup();
        pushButton = new Button(styleGroup, 16);
        pushButton.setText("SWT.PUSH");
        checkButton = new Button(styleGroup, 16);
        checkButton.setText("SWT.CHECK");
        radioButton = new Button(styleGroup, 16);
        radioButton.setText("SWT.RADIO");
        toggleButton = new Button(styleGroup, 16);
        toggleButton.setText("SWT.TOGGLE");
        arrowButton = new Button(styleGroup, 16);
        arrowButton.setText("SWT.ARROW");
        flatButton = new Button(styleGroup, 32);
        flatButton.setText("SWT.FLAT");
        borderButton = new Button(styleGroup, 32);
        borderButton.setText("SWT.BORDER");
    }

    Control[] getExampleWidgets() {
        return (new Control[]{
            button1, button2, button3, button4, button5, button6
        });
    }

    String getTabText() {
        return "Button";
    }

    void setExampleWidgetAlignment() {
        int alignment = 0;
        if (leftButton.getSelection()) {
            alignment = 16384;
        }
        if (centerButton.getSelection()) {
            alignment = 0x1000000;
        }
        if (rightButton.getSelection()) {
            alignment = 0x20000;
        }
        if (upButton.getSelection()) {
            alignment = 128;
        }
        if (downButton.getSelection()) {
            alignment = 1024;
        }
        button1.setAlignment(alignment);
        button2.setAlignment(alignment);
        button3.setAlignment(alignment);
        button4.setAlignment(alignment);
        button5.setAlignment(alignment);
        button6.setAlignment(alignment);
    }

    void setExampleWidgetState() {
        super.setExampleWidgetState();
        if (arrowButton.getSelection()) {
            upButton.setEnabled(true);
            centerButton.setEnabled(false);
            downButton.setEnabled(true);
        } else {
            upButton.setEnabled(false);
            centerButton.setEnabled(true);
            downButton.setEnabled(false);
        }
        upButton.setSelection((button1.getStyle() & 0x80) != 0);
        downButton.setSelection((button1.getStyle() & 0x400) != 0);
        pushButton.setSelection((button1.getStyle() & 8) != 0);
        checkButton.setSelection((button1.getStyle() & 0x20) != 0);
        radioButton.setSelection((button1.getStyle() & 0x10) != 0);
        toggleButton.setSelection((button1.getStyle() & 2) != 0);
        arrowButton.setSelection((button1.getStyle() & 4) != 0);
        flatButton.setSelection((button1.getStyle() & 0x800000) != 0);
        borderButton.setSelection((button1.getStyle() & 0x800) != 0);
    }

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Group textButtonGroup;
    Group imageButtonGroup;
    Button upButton;
    Button downButton;
    Button pushButton;
    Button checkButton;
    Button radioButton;
    Button toggleButton;
    Button arrowButton;
    Button flatButton;
}

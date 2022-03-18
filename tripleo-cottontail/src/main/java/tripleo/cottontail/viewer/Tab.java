
package tripleo.cottontail.viewer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

abstract class Tab {

	Tab(ControlExample instance) {
		logging = false;
		this.instance = instance;
	}

	void createControlGroup() {
		controlGroup = new Group(tabFolderPage, 0);
		controlGroup.setLayout(new GridLayout(2, true));
		controlGroup.setLayoutData(new GridData(272));
		controlGroup.setText(ControlExample.getResourceString("Parameters"));
		createStyleGroup();
		createOtherGroup();
		createSizeGroup();
		createColorGroup();
		org.eclipse.swt.events.SelectionListener selectionListener = new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				if ((event.widget.getStyle() & 0x10) != 0 && !((Button) event.widget).getSelection()) {
					return;
				} else {
					recreateExampleWidgets();
					return;
				}
			}

		};
		Control children[] = styleGroup.getChildren();
		for (int i = 0; i < children.length; i++)
			if (children[i] instanceof Button) {
				Button button = (Button) children[i];
				button.addSelectionListener(selectionListener);
			}

	}

	void createControlWidgets() {
	}

	void createColorGroup() {
		colorGroup = new Group(controlGroup, 0);
		colorGroup.setLayout(new GridLayout(2, false));
		colorGroup.setLayoutData(new GridData(272));
		colorGroup.setText(ControlExample.getResourceString("Colors"));
		(new Label(colorGroup, 0)).setText(ControlExample.getResourceString("Foreground_Color"));
		foregroundButton = new Button(colorGroup, 8);
		(new Label(colorGroup, 0)).setText(ControlExample.getResourceString("Background_Color"));
		backgroundButton = new Button(colorGroup, 8);
		fontButton = new Button(colorGroup, 8);
		fontButton.setText(ControlExample.getResourceString("Font"));
		fontButton.setLayoutData(new GridData(256));
		Button defaultsButton = new Button(colorGroup, 8);
		defaultsButton.setText(ControlExample.getResourceString("Defaults"));
		Shell shell = controlGroup.getShell();
		final ColorDialog foregroundDialog = new ColorDialog(shell);
		final ColorDialog backgroundDialog = new ColorDialog(shell);
		final FontDialog fontDialog = new FontDialog(shell);
		int imageSize = 12;
		Display display = shell.getDisplay();
		foregroundImage = new Image(display, imageSize, imageSize);
		backgroundImage = new Image(display, imageSize, imageSize);
		foregroundButton.setImage(foregroundImage);
		foregroundButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				Color oldColor = foregroundColor;
				if (oldColor == null) {
					Control controls[] = getExampleWidgets();
					if (controls.length > 0)
						oldColor = controls[0].getForeground();
				}
				if (oldColor != null)
					foregroundDialog.setRGB(oldColor.getRGB());
				org.eclipse.swt.graphics.RGB rgb = foregroundDialog.open();
				if (rgb == null)
					return;
				oldColor = foregroundColor;
				foregroundColor = new Color(event.display, rgb);
				setExampleWidgetForeground();
				if (oldColor != null)
					oldColor.dispose();
			}

		});
		backgroundButton.setImage(backgroundImage);
		backgroundButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				Color oldColor = backgroundColor;
				if (oldColor == null) {
					Control controls[] = getExampleWidgets();
					if (controls.length > 0)
						oldColor = controls[0].getBackground();
				}
				if (oldColor != null)
					backgroundDialog.setRGB(oldColor.getRGB());
				org.eclipse.swt.graphics.RGB rgb = backgroundDialog.open();
				if (rgb == null)
					return;
				oldColor = backgroundColor;
				backgroundColor = new Color(event.display, rgb);
				setExampleWidgetBackground();
				if (oldColor != null)
					oldColor.dispose();
			}

		});
		fontButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				Font oldFont = font;
				if (oldFont == null) {
					Control controls[] = getExampleWidgets();
					if (controls.length > 0)
						oldFont = controls[0].getFont();
				}
				if (oldFont != null)
					fontDialog.setFontList(oldFont.getFontData());
				org.eclipse.swt.graphics.FontData fontData = fontDialog.open();
				if (fontData == null)
					return;
				oldFont = font;
				font = new Font(event.display, fontData);
				setExampleWidgetFont();
				setExampleWidgetSize();
				if (oldFont != null)
					oldFont.dispose();
			}

		});
		defaultsButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				resetColorsAndFonts();
			}

		});
		shell.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent event) {
				if (foregroundImage != null)
					foregroundImage.dispose();
				if (backgroundImage != null)
					backgroundImage.dispose();
				if (foregroundColor != null)
					foregroundColor.dispose();
				if (backgroundColor != null)
					backgroundColor.dispose();
				if (font != null)
					font.dispose();
				foregroundColor = null;
				backgroundColor = null;
				font = null;
			}

		});
	}

	void createOtherGroup() {
		otherGroup = new Group(controlGroup, 0);
		otherGroup.setLayout(new GridLayout());
		otherGroup.setLayoutData(new GridData(272));
		otherGroup.setText(ControlExample.getResourceString("Other"));
		enabledButton = new Button(otherGroup, 32);
		enabledButton.setText(ControlExample.getResourceString("Enabled"));
		visibleButton = new Button(otherGroup, 32);
		visibleButton.setText(ControlExample.getResourceString("Visible"));
		enabledButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				setExampleWidgetEnabled();
			}

		});
		visibleButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				setExampleWidgetVisibility();
			}

		});
		enabledButton.setSelection(true);
		visibleButton.setSelection(true);
	}

	void createEventConsolePopup() {
		Menu popup = new Menu(eventConsole.getShell(), 8);
		eventConsole.setMenu(popup);
		MenuItem cut = new MenuItem(popup, 8);
		cut.setText(ControlExample.getResourceString("MenuItem_Cut"));
		cut.addListener(13, new Listener() {

			public void handleEvent(Event event) {
				eventConsole.cut();
			}

		});
		MenuItem copy = new MenuItem(popup, 8);
		copy.setText(ControlExample.getResourceString("MenuItem_Copy"));
		copy.addListener(13, new Listener() {

			public void handleEvent(Event event) {
				eventConsole.copy();
			}

		});
		MenuItem paste = new MenuItem(popup, 8);
		paste.setText(ControlExample.getResourceString("MenuItem_Paste"));
		paste.addListener(13, new Listener() {

			public void handleEvent(Event event) {
				eventConsole.paste();
			}

		});
		new MenuItem(popup, 2);
		MenuItem selectAll = new MenuItem(popup, 8);
		selectAll.setText(ControlExample.getResourceString("MenuItem_SelectAll"));
		selectAll.addListener(13, new Listener() {

			public void handleEvent(Event event) {
				eventConsole.selectAll();
			}

		});
	}

	void createExampleGroup() {
		exampleGroup = new Group(tabFolderPage, 0);
		GridLayout gridLayout = new GridLayout();
		exampleGroup.setLayout(gridLayout);
		exampleGroup.setLayoutData(new GridData(1808));
	}

	void createExampleWidgets() {
	}

	void createListenerSelectionDialog() {
		final Shell dialog = new Shell(tabFolderPage.getShell(), 0x10860);
		dialog.setText(ControlExample.getResourceString("Select_Listeners"));
		dialog.setLayout(new GridLayout(2, false));
		final Table table = new Table(dialog, 2592);
		GridData data = new GridData(1808);
		data.verticalSpan = 2;
		table.setLayoutData(data);
		for (int i = 0; i < EVENT_NAMES.length; i++) {
			TableItem item = new TableItem(table, 0);
			item.setText(EVENT_NAMES[i]);
			item.setChecked(eventsFilter[i]);
		}

		final String customNames[] = getCustomEventNames();
		for (int i = 0; i < customNames.length; i++) {
			TableItem item = new TableItem(table, 0);
			item.setText(customNames[i]);
			item.setChecked(eventsFilter[EVENT_NAMES.length + i]);
		}

		Button selectAll = new Button(dialog, 8);
		selectAll.setText(ControlExample.getResourceString("Select_All"));
		selectAll.setLayoutData(new GridData(256));
		selectAll.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				TableItem items[] = table.getItems();
				for (int i = 0; i < Tab.EVENT_NAMES.length; i++)
					items[i].setChecked(true);

				for (int i = 0; i < customNames.length; i++)
					items[Tab.EVENT_NAMES.length + i].setChecked(true);

			}

		});
		Button deselectAll = new Button(dialog, 8);
		deselectAll.setText(ControlExample.getResourceString("Deselect_All"));
		deselectAll.setLayoutData(new GridData(258));
		deselectAll.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				TableItem items[] = table.getItems();
				for (int i = 0; i < Tab.EVENT_NAMES.length; i++)
					items[i].setChecked(false);

				for (int i = 0; i < customNames.length; i++)
					items[Tab.EVENT_NAMES.length + i].setChecked(false);

			}

		});
		new Label(dialog, 0);
		Button ok = new Button(dialog, 8);
		ok.setText(ControlExample.getResourceString("OK"));
		dialog.setDefaultButton(ok);
		ok.setLayoutData(new GridData(256));
		ok.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				TableItem items[] = table.getItems();
				for (int i = 0; i < Tab.EVENT_NAMES.length; i++)
					eventsFilter[i] = items[i].getChecked();

				for (int i = 0; i < customNames.length; i++)
					eventsFilter[Tab.EVENT_NAMES.length + i] = items[Tab.EVENT_NAMES.length + i].getChecked();

				dialog.dispose();
			}

		});
		dialog.pack();
		dialog.open();
		while (!dialog.isDisposed())
			if (!dialog.getDisplay().readAndDispatch())
				dialog.getDisplay().sleep();
	}

	void createListenersGroup() {
		listenersGroup = new Group(tabFolderPage, 0);
		listenersGroup.setLayout(new GridLayout(3, false));
		GridData gridData = new GridData(1296);
		gridData.horizontalSpan = 2;
		listenersGroup.setLayoutData(gridData);
		listenersGroup.setText(ControlExample.getResourceString("Listeners"));
		Button listenersButton = new Button(listenersGroup, 8);
		listenersButton.setText(ControlExample.getResourceString("Select_Listeners"));
		listenersButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				createListenerSelectionDialog();
				recreateExampleWidgets();
			}

		});
		final Button listenCheckbox = new Button(listenersGroup, 32);
		listenCheckbox.setText(ControlExample.getResourceString("Listen"));
		listenCheckbox.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				logging = listenCheckbox.getSelection();
				recreateExampleWidgets();
			}

		});
		Button clearButton = new Button(listenersGroup, 8);
		clearButton.setText(ControlExample.getResourceString("Clear"));
		clearButton.setLayoutData(new GridData(128));
		clearButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				eventConsole.setText("");
			}

		});
		int customEventCount = getCustomEventNames().length;
		eventsFilter = new boolean[EVENT_NAMES.length + customEventCount];
		for (int i = 0; i < EVENT_NAMES.length + customEventCount; i++)
			eventsFilter[i] = true;

		eventConsole = new Text(listenersGroup, 2818);
		GridData data = new GridData(1808);
		data.horizontalSpan = 3;
		data.heightHint = 80;
		eventConsole.setLayoutData(data);
		createEventConsolePopup();
		eventConsole.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				if ((e.keyCode == 65 || e.keyCode == 97) && (e.stateMask & SWT.MOD1) != 0) {
					eventConsole.selectAll();
					e.doit = false;
				}
			}

		});
	}

	void createOrientationGroup() {
		orientationGroup = new Group(controlGroup, 0);
		orientationGroup.setLayout(new GridLayout());
		orientationGroup.setLayoutData(new GridData(272));
		orientationGroup.setText(ControlExample.getResourceString("Orientation"));
		defaultOrietationButton = new Button(orientationGroup, 16);
		defaultOrietationButton.setText(ControlExample.getResourceString("Default"));
		defaultOrietationButton.setSelection(true);
		ltrButton = new Button(orientationGroup, 16);
		ltrButton.setText("SWT.LEFT_TO_RIGHT");
		rtlButton = new Button(orientationGroup, 16);
		rtlButton.setText("SWT.RIGHT_TO_LEFT");
	}

	void createSizeGroup() {
		sizeGroup = new Group(controlGroup, 0);
		sizeGroup.setLayout(new GridLayout());
		sizeGroup.setLayoutData(new GridData(272));
		sizeGroup.setText(ControlExample.getResourceString("Size"));
		preferredButton = new Button(sizeGroup, 16);
		preferredButton.setText(ControlExample.getResourceString("Preferred"));
		tooSmallButton = new Button(sizeGroup, 16);
		tooSmallButton.setText("10 X 10");
		smallButton = new Button(sizeGroup, 16);
		smallButton.setText("50 X 50");
		largeButton = new Button(sizeGroup, 16);
		largeButton.setText("100 X 100");
		fillButton = new Button(sizeGroup, 16);
		fillButton.setText(ControlExample.getResourceString("Fill"));
		SelectionAdapter selectionListener = new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				if (!((Button) event.widget).getSelection()) {
					return;
				} else {
					setExampleWidgetSize();
					return;
				}
			}

		};
		preferredButton.addSelectionListener(selectionListener);
		tooSmallButton.addSelectionListener(selectionListener);
		smallButton.addSelectionListener(selectionListener);
		largeButton.addSelectionListener(selectionListener);
		fillButton.addSelectionListener(selectionListener);
		preferredButton.setSelection(true);
	}

	void createStyleGroup() {
		styleGroup = new Group(controlGroup, 0);
		styleGroup.setLayout(new GridLayout());
		styleGroup.setLayoutData(new GridData(272));
		styleGroup.setText(ControlExample.getResourceString("Styles"));
	}

	Composite createTabFolderPage(TabFolder tabFolder) {
		tabFolderPage = new Composite(tabFolder, 0);
		tabFolderPage.setLayout(new GridLayout(2, false));
		createExampleGroup();
		createControlGroup();
		createListenersGroup();
		createExampleWidgets();
		hookExampleWidgetListeners();
		createControlWidgets();
		setExampleWidgetState();
		return tabFolderPage;
	}

	void disposeExampleWidgets() {
		Control controls[] = getExampleWidgets();
		for (int i = 0; i < controls.length; i++)
			controls[i].dispose();

	}

	void drawImage(Image image, Color color) {
		GC gc = new GC(image);
		gc.setBackground(color);
		Rectangle bounds = image.getBounds();
		gc.fillRectangle(0, 0, bounds.width, bounds.height);
		gc.drawRectangle(0, 0, bounds.width - 1, bounds.height - 1);
		gc.dispose();
	}

	String[] getCustomEventNames() {
		return new String[0];
	}

	int getDefaultStyle() {
		if (ltrButton != null && ltrButton.getSelection())
			return 0x2000000;
		return rtlButton == null || !rtlButton.getSelection() ? 0 : 0x4000000;
	}

	Control[] getExampleWidgets() {
		return new Control[0];
	}

	Item[] getExampleWidgetItems() {
		return new Item[0];
	}

	String getTabText() {
		return "";
	}

	void hookExampleWidgetListeners() {
		if (logging) {
			Control exampleControls[] = getExampleWidgets();
			for (int i = 0; i < exampleControls.length; i++)
				hookListeners(exampleControls[i]);

			Item exampleItems[] = getExampleWidgetItems();
			for (int i = 0; i < exampleItems.length; i++)
				hookListeners(exampleItems[i]);

			String customNames[] = getCustomEventNames();
			for (int i = 0; i < customNames.length; i++)
				if (eventsFilter[EVENT_NAMES.length + i])
					hookCustomListener(customNames[i]);

		}
	}

	void hookCustomListener(String s) {
	}

	void hookListeners(Widget widget) {
		if (logging) {
			Listener listener = new Listener() {

				public void handleEvent(Event event) {
					log(event);
				}

			};
			for (int i = 0; i < EVENT_NAMES.length; i++)
				if (eventsFilter[i])
					widget.addListener(i + 1, listener);

		}
	}

	void log(Event event) {
		String toString = EVENT_NAMES[event.type - 1] + ": ";
		switch (event.type) {
			case 1: // '\001'
			case 2: // '\002'
				toString = toString + (new KeyEvent(event)).toString();
				break;

			case 3: // '\003'
			case 4: // '\004'
			case 5: // '\005'
			case 6: // '\006'
			case 7: // '\007'
			case 8: // '\b'
			case 32: // ' '
				toString = toString + (new MouseEvent(event)).toString();
				break;

			case 9: // '\t'
				toString = toString + (new PaintEvent(event)).toString();
				break;

			case 10: // '\n'
			case 11: // '\013'
				toString = toString + (new ControlEvent(event)).toString();
				break;

			case 12: // '\f'
				try {
					toString = toString + (new DisposeEvent(event)).toString();
					break;
				} catch (Exception _ex) {
					String string = event.widget.getClass().getName();
					int index = string.lastIndexOf('.');
					if (index != -1)
						string = string.substring(index + 1, string.length());
					toString = toString + "DisposeEvent{" + string + "}";
				}
				break;

			case 13: // '\r'
			case 14: // '\016'
				toString = toString + (new SelectionEvent(event)).toString();
				break;

			case 15: // '\017'
			case 16: // '\020'
				toString = toString + (new FocusEvent(event)).toString();
				break;

			case 17: // '\021'
			case 18: // '\022'
				toString = toString + (new TreeEvent(event)).toString();
				break;

			case 19: // '\023'
			case 20: // '\024'
			case 21: // '\025'
			case 26: // '\032'
			case 27: // '\033'
				toString = toString + (new ShellEvent(event)).toString();
				break;

			case 22: // '\026'
			case 23: // '\027'
				toString = toString + ((event.widget instanceof Menu) ? (new MenuEvent(event)).toString() : event.toString());
				break;

			case 24: // '\030'
				toString = toString + (new ModifyEvent(event)).toString();
				break;

			case 25: // '\031'
				toString = toString + (new VerifyEvent(event)).toString();
				break;

			case 28: // '\034'
				toString = toString + (new HelpEvent(event)).toString();
				break;

			case 30: // '\036'
				toString = toString + (new ArmEvent(event)).toString();
				break;

			case 31: // '\037'
				toString = toString + (new TraverseEvent(event)).toString();
				break;

			case 29: // '\035'
			case 33: // '!'
			case 34: // '"'
			case 35: // '#'
			default:
				toString = toString + event.toString();
				break;
		}
		eventConsole.append(toString);
		eventConsole.append("\n");
	}

	void log(String eventName, TypedEvent event) {
		eventConsole.append(eventName + ": ");
		eventConsole.append(event.toString());
		eventConsole.append("\n");
	}

	void recreateExampleWidgets() {
		disposeExampleWidgets();
		createExampleWidgets();
		hookExampleWidgetListeners();
		setExampleWidgetState();
	}

	void resetColorsAndFonts() {
		Color oldColor = foregroundColor;
		foregroundColor = null;
		setExampleWidgetForeground();
		if (oldColor != null)
			oldColor.dispose();
		oldColor = backgroundColor;
		backgroundColor = null;
		setExampleWidgetBackground();
		if (oldColor != null)
			oldColor.dispose();
		Font oldFont = font;
		font = null;
		setExampleWidgetFont();
		setExampleWidgetSize();
		if (oldFont != null)
			oldFont.dispose();
	}

	void setExampleWidgetBackground() {
		if (backgroundButton == null)
			return;
		Control controls[] = getExampleWidgets();
		for (int i = 0; i < controls.length; i++)
			controls[i].setBackground(backgroundColor);

		Color color = backgroundColor;
		if (controls.length == 0)
			return;
		if (color == null)
			color = controls[0].getBackground();
		drawImage(backgroundImage, color);
		backgroundButton.setImage(backgroundImage);
	}

	void setExampleWidgetEnabled() {
		Control controls[] = getExampleWidgets();
		for (int i = 0; i < controls.length; i++)
			controls[i].setEnabled(enabledButton.getSelection());

	}

	void setExampleWidgetFont() {
		if (instance.startup)
			return;
		if (fontButton == null)
			return;
		Control controls[] = getExampleWidgets();
		for (int i = 0; i < controls.length; i++) {
			Control control = controls[i];
			control.setFont(font);
		}

	}

	void setExampleWidgetForeground() {
		if (foregroundButton == null)
			return;
		Control controls[] = getExampleWidgets();
		for (int i = 0; i < controls.length; i++)
			controls[i].setForeground(foregroundColor);

		Color color = foregroundColor;
		if (controls.length == 0)
			return;
		if (color == null)
			color = controls[0].getForeground();
		drawImage(foregroundImage, color);
		foregroundButton.setImage(foregroundImage);
	}

	void setExampleWidgetSize() {
		int size = -1;
		if (preferredButton == null)
			return;
		if (preferredButton.getSelection())
			size = -1;
		if (tooSmallButton.getSelection())
			size = 10;
		if (smallButton.getSelection())
			size = 50;
		if (largeButton.getSelection())
			size = 100;
		Control controls[] = getExampleWidgets();
		for (int i = 0; i < controls.length; i++) {
			GridData gridData;
			if (fillButton.getSelection()) {
				gridData = new GridData(1808);
			} else {
				gridData = new GridData();
				gridData.widthHint = size;
				gridData.heightHint = size;
			}
			controls[i].setLayoutData(gridData);
		}

		int seenCount = 0;
		Composite seen[] = new Composite[4];
		for (int i = 0; i < controls.length; i++) {
			for (Control control = controls[i]; control != exampleGroup; control = control.getParent()) {
				Composite parent = control.getParent();
				int index;
				for (index = 0; index < seenCount; index++)
					if (seen[index] == parent)
						break;

				if (index == seenCount)
					parent.layout();
				if (seenCount == seen.length) {
					Composite newSeen[] = new Composite[seen.length + 4];
					System.arraycopy(seen, 0, newSeen, 0, seen.length);
					seen = newSeen;
				}
				seen[seenCount++] = parent;
			}

		}

	}

	void setExampleWidgetState() {
		setExampleWidgetEnabled();
		setExampleWidgetVisibility();
		setExampleWidgetBackground();
		setExampleWidgetForeground();
		setExampleWidgetFont();
		setExampleWidgetSize();
	}

	void setExampleWidgetVisibility() {
		Control controls[] = getExampleWidgets();
		for (int i = 0; i < controls.length; i++)
			controls[i].setVisible(visibleButton.getSelection());

	}

	Button borderButton;
	Button enabledButton;
	Button visibleButton;
	Button preferredButton;
	Button tooSmallButton;
	Button smallButton;
	Button largeButton;
	Button fillButton;
	Composite tabFolderPage;
	Group exampleGroup;
	Group controlGroup;
	Group listenersGroup;
	Group otherGroup;
	Group sizeGroup;
	Group styleGroup;
	Group colorGroup;
	final ControlExample instance;
	static final int TOO_SMALL_SIZE = 10;
	static final int SMALL_SIZE = 50;
	static final int LARGE_SIZE = 100;
	static final boolean RTL_SUPPORT_ENABLE = false;
	Group orientationGroup;
	Button rtlButton;
	Button ltrButton;
	Button defaultOrietationButton;
	Button foregroundButton;
	Button backgroundButton;
	Button fontButton;
	Image foregroundImage;
	Image backgroundImage;
	Color foregroundColor;
	Color backgroundColor;
	Font font;
	Text eventConsole;
	boolean logging;
	boolean eventsFilter[];
	static final String EVENT_NAMES[] = {
		"KeyDown", "KeyUp", "MouseDown", "MouseUp", "MouseMove", "MouseEnter", "MouseExit", "MouseDoubleClick", "Paint", "Move",
		"Resize", "Dispose", "Selection", "DefaultSelection", "FocusIn", "FocusOut", "Expand", "Collapse", "Iconify", "Deiconify",
		"Close", "Show", "Hide", "Modify", "Verify", "Activate", "Deactivate", "Help", "DragDetect", "Arm",
		"Traverse", "MouseHover", "HardKeyDown", "HardKeyUp", "MenuDetect"
	};

}

package tripleo.cottontail.viewer;

import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import java.io.IOException;
import java.io.InputStream;

class StyledTextTab extends ScrollableTab {

	StyledTextTab(ControlExample instance) {
		super(instance);
	}

	Image createBitmapImage(Display display, String name) {
		InputStream sourceStream = ControlExample.class.getResourceAsStream(name + ".bmp");
		InputStream maskStream = ControlExample.class.getResourceAsStream(name + "_mask.bmp");
		ImageData source = new ImageData(sourceStream);
		ImageData mask = new ImageData(maskStream);
		Image result = new Image(display, source, mask);
		try {
			sourceStream.close();
			maskStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	void createControlWidgets() {
		super.createControlWidgets();
		createStyledTextStyleGroup();
	}

	void createExampleGroup() {
		super.createExampleGroup();
		styledTextGroup = new Group(exampleGroup, 0);
		styledTextGroup.setLayout(new GridLayout());
		styledTextGroup.setLayoutData(new GridData(784));
		styledTextGroup.setText("StyledText");
	}

	void createExampleWidgets() {
		int style = getDefaultStyle();
		if (singleButton.getSelection())
			style |= 4;
		if (multiButton.getSelection())
			style |= 2;
		if (horizontalButton.getSelection())
			style |= 0x100;
		if (verticalButton.getSelection())
			style |= 0x200;
		if (wrapButton.getSelection())
			style |= 0x40;
		if (readOnlyButton.getSelection())
			style |= 8;
		if (borderButton.getSelection())
			style |= 0x800;
		if (fullSelectionButton.getSelection())
			style |= 0x10000;
		styledText = new StyledText(styledTextGroup, style);
		styledText.setText(ControlExample.getResourceString("Example_string"));
		styledText.append("\n");
		styledText.append(ControlExample.getResourceString("One_Two_Three"));
		if (styleRanges != null) {
			styledText.setStyleRanges(styleRanges);
			styleRanges = null;
		}
	}

	void createStyleGroup() {
		super.createStyleGroup();
		wrapButton = new Button(styleGroup, 32);
		wrapButton.setText("SWT.WRAP");
		readOnlyButton = new Button(styleGroup, 32);
		readOnlyButton.setText("SWT.READ_ONLY");
		fullSelectionButton = new Button(styleGroup, 32);
		fullSelectionButton.setText("SWT.FULL_SELECTION");
	}

	void createStyledTextStyleGroup() {
		final Display display = controlGroup.getDisplay();
		styledTextStyleGroup = new Group(controlGroup, 0);
		styledTextStyleGroup.setText(ControlExample.getResourceString("StyledText_Styles"));
		styledTextStyleGroup.setLayout(new GridLayout(5, false));
		GridData data = new GridData(256);
		data.horizontalSpan = 2;
		styledTextStyleGroup.setLayoutData(data);
		boldImage = createBitmapImage(display, "bold");
		italicImage = createBitmapImage(display, "italic");
		redImage = createBitmapImage(display, "red");
		yellowImage = createBitmapImage(display, "yellow");
		Label label = new Label(styledTextStyleGroup, 0);
		label.setText(ControlExample.getResourceString("StyledText_Style_Instructions"));
		data = new GridData(768);
		data.horizontalSpan = 5;
		label.setLayoutData(data);
		(new Label(styledTextStyleGroup, 0)).setText(ControlExample.getResourceString("Bold"));
		boldButton = new Button(styledTextStyleGroup, 8);
		boldButton.setImage(boldImage);
		boldButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				Point sel = styledText.getSelectionRange();
				if (sel == null || sel.y == 0)
					return;
				for (int i = sel.x; i < sel.x + sel.y; i++) {
					StyleRange range = styledText.getStyleRangeAtOffset(i);
					StyleRange style;
					if (range == null)
						style = new StyleRange(i, 1, null, null, 1);
					else
						style = new StyleRange(i, 1, range.foreground, range.background, range.fontStyle | 1);
					styledText.setStyleRange(style);
				}

				styledText.setSelectionRange(sel.x + sel.y, 0);
			}

		});
		(new Label(styledTextStyleGroup, 0)).setLayoutData(new GridData(768));
		(new Label(styledTextStyleGroup, 0)).setText(ControlExample.getResourceString("Foreground_Style"));
		redButton = new Button(styledTextStyleGroup, 8);
		redButton.setImage(redImage);
		(new Label(styledTextStyleGroup, 0)).setText(ControlExample.getResourceString("Italic"));
		italicButton = new Button(styledTextStyleGroup, 8);
		italicButton.setImage(italicImage);
		italicButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				Point sel = styledText.getSelectionRange();
				if (sel == null || sel.y == 0)
					return;
				for (int i = sel.x; i < sel.x + sel.y; i++) {
					StyleRange range = styledText.getStyleRangeAtOffset(i);
					StyleRange style;
					if (range == null)
						style = new StyleRange(i, 1, null, null, 2);
					else
						style = new StyleRange(i, 1, range.foreground, range.background, range.fontStyle | 2);
					styledText.setStyleRange(style);
				}

				styledText.setSelectionRange(sel.x + sel.y, 0);
			}

		});
		(new Label(styledTextStyleGroup, 0)).setLayoutData(new GridData(768));
		(new Label(styledTextStyleGroup, 0)).setText(ControlExample.getResourceString("Background_Style"));
		yellowButton = new Button(styledTextStyleGroup, 8);
		yellowButton.setImage(yellowImage);
		org.eclipse.swt.events.SelectionListener colorListener = new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				Point sel = styledText.getSelectionRange();
				if (sel == null || sel.y == 0)
					return;
				org.eclipse.swt.graphics.Color fg;
				org.eclipse.swt.graphics.Color bg;
				if (e.widget == redButton) {
					fg = display.getSystemColor(3);
					bg = null;
				} else if (e.widget == yellowButton) {
					fg = null;
					bg = display.getSystemColor(7);
				} else {
					fg = bg = null;
				}
				for (int i = sel.x; i < sel.x + sel.y; i++) {
					StyleRange range = styledText.getStyleRangeAtOffset(i);
					StyleRange style;
					if (range == null) {
						style = new StyleRange(i, 1, fg, bg, 0);
					} else {
						if (range.foreground != null)
							fg = range.foreground;
						if (range.background != null)
							bg = range.background;
						style = new StyleRange(i, 1, fg, bg, range.fontStyle);
					}
					styledText.setStyleRange(style);
				}

				styledText.setSelectionRange(sel.x + sel.y, 0);
			}

		};
		redButton.addSelectionListener(colorListener);
		yellowButton.addSelectionListener(colorListener);
		yellowButton.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				boldImage.dispose();
				italicImage.dispose();
				redImage.dispose();
				yellowImage.dispose();
			}

		});
	}

	Composite createTabFolderPage(TabFolder tabFolder) {
		super.createTabFolderPage(tabFolder);
		tabFolderPage.addControlListener(new ControlAdapter() {

			public void controlResized(ControlEvent e) {
				setExampleWidgetSize();
			}

		});
		return tabFolderPage;
	}

	void disposeExampleWidgets() {
		if (styledText != null)
			styleRanges = styledText.getStyleRanges();
		super.disposeExampleWidgets();
	}

	Control[] getExampleWidgets() {
		return (new Control[]{
			styledText
		});
	}

	String getTabText() {
		return "StyledText";
	}

	void setExampleWidgetState() {
		super.setExampleWidgetState();
		wrapButton.setSelection((styledText.getStyle() & 0x40) != 0);
		readOnlyButton.setSelection((styledText.getStyle() & 8) != 0);
		fullSelectionButton.setSelection((styledText.getStyle() & 0x10000) != 0);
		horizontalButton.setEnabled((styledText.getStyle() & 2) != 0);
		verticalButton.setEnabled((styledText.getStyle() & 2) != 0);
		wrapButton.setEnabled((styledText.getStyle() & 2) != 0);
	}

	StyledText styledText;
	Group styledTextGroup;
	Group styledTextStyleGroup;
	Button wrapButton;
	Button readOnlyButton;
	Button fullSelectionButton;
	Button boldButton;
	Button italicButton;
	Button redButton;
	Button yellowButton;
	Image boldImage;
	Image italicImage;
	Image redImage;
	Image yellowImage;
	StyleRange styleRanges[];
}

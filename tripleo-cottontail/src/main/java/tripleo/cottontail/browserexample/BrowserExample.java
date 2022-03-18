// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BrowserExample.java

package tripleo.cottontail.browserexample;

import java.io.FileInputStream;
import org.eclipse.swt.*;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class BrowserExample implements OpenWindowListener {
	private String F1 = "org.eclipse.swt.examples.browserexample.BrowserApplication";

	private Display open_display;

	public void open(WindowEvent event) {
		Shell shell = new Shell(open_display);
		if (icon != null)
			shell.setImage(icon);
		shell.setLayout(new FillLayout());
		BrowserExample app = new BrowserExample(shell, false);
		app.setShellDecoration(icon, true);
		event.browser = app.getBrowser();
	}

	public BrowserExample(Composite aParent, boolean top) {
		icon = null;
		title = false;
		error = null;
		this.parent = aParent;
		try {
			browser = new Browser(aParent, 2048);
		} catch (SWTError e) {
			error = e;
			aParent.setLayout(new FillLayout());
			Label label = new Label(aParent, 0x1000040);
			label.setText(getResourceString("BrowserNotCreated"));
			aParent.layout(true);
			return;
		}
		initResources();
		final Display display = aParent.getDisplay();
		open_display = display;
		browser.setData(F1, this);
		browser.addOpenWindowListener(this);
		if (top) {
			browser.setUrl(getResourceString("Startup"));
			show(false, null, null, true, true, true, true);
		} else {
			browser
					.addVisibilityWindowListener(new MyVisibilityWindowListener());
			browser.addCloseWindowListener(new MyCloseWindowListener());
		}
	}

	public void dispose() {
		freeResources();
	}

	static String getResourceString(String key) {
		try {
			return resourceBundle.getString(key);
		} catch (MissingResourceException _ex) {
			return key;
		} catch (NullPointerException _ex) {
			return "!" + key + "!";
		}
	}

	public SWTError getError() {
		return error;
	}

	public Browser getBrowser() {
		return browser;
	}

	public void setShellDecoration(Image aIcon, boolean aTitle) {
		this.icon = aIcon;
		this.title = aTitle;
	}

	void show(boolean owned, Point location, Point size, boolean addressBar,
			boolean menuBar, boolean statusBar, boolean toolBar) {
		final Shell shell = browser.getShell();
		if (owned) {
			if (location != null)
				shell.setLocation(location);
			if (size != null)
				shell.setSize(shell.computeSize(size.x, size.y));
		}
		FormData data = null;
		if (toolBar) {
			toolbar = new ToolBar(parent, 0);
			data = new FormData();
			data.top = new FormAttachment(0, 5);
			toolbar.setLayoutData(data);
			itemBack = new ToolItem(toolbar, 8);
			itemBack.setText(getResourceString("Back"));
			itemForward = new ToolItem(toolbar, 8);
			itemForward.setText(getResourceString("Forward"));
			final ToolItem itemStop = new ToolItem(toolbar, 8);
			itemStop.setText(getResourceString("Stop"));
			final ToolItem itemRefresh = new ToolItem(toolbar, 8);
			itemRefresh.setText(getResourceString("Refresh"));
			final ToolItem itemGo = new ToolItem(toolbar, 8);
			itemGo.setText(getResourceString("Go"));
			itemBack.setEnabled(browser.isBackEnabled());
			itemForward.setEnabled(browser.isForwardEnabled());
			Listener listener = new Listener() {

				public void handleEvent(Event event) {
					ToolItem item = (ToolItem) event.widget;
					if (item == itemBack)
						browser.back();
					else if (item == itemForward)
						browser.forward();
					else if (item == itemStop)
						browser.stop();
					else if (item == itemRefresh)
						browser.refresh();
					else if (item == itemGo)
						browser.setUrl(locationBar.getText());
				}

			};
			itemBack.addListener(13, listener);
			itemForward.addListener(13, listener);
			itemStop.addListener(13, listener);
			itemRefresh.addListener(13, listener);
			itemGo.addListener(13, listener);
			canvas = new Canvas(parent, 0x40000);
			data = new FormData();
			data.width = 24;
			data.height = 24;
			data.top = new FormAttachment(0, 5);
			data.right = new FormAttachment(100, -5);
			canvas.setLayoutData(data);
			final Rectangle rect = images[0].getBounds();
			canvas.addListener(9, new Listener() {

				public void handleEvent(Event e) {
					Point pt = ((Canvas) e.widget).getSize();
					e.gc.drawImage(images[index], 0, 0, rect.width,
							rect.height, 0, 0, pt.x, pt.y);
				}

			});
			canvas.addListener(3, new Listener() {

				public void handleEvent(Event e) {
					browser.setUrl(BrowserExample.getResourceString("Startup"));
				}

			});
			final Display display = parent.getDisplay();
			display.asyncExec(new Runnable() {

				public void run() {
					if (canvas.isDisposed())
						return;
					if (busy) {
						index++;
						if (index == images.length)
							index = 0;
						canvas.redraw();
					}
					display.timerExec(150, this);
				}

			});
		}
		if (addressBar) {
			locationBar = new Text(parent, 2048);
			data = new FormData();
			if (toolbar != null) {
				data.top = new FormAttachment(toolbar, 0, 128);
				data.left = new FormAttachment(toolbar, 5, 0x20000);
				data.right = new FormAttachment(canvas, -5, -1);
			} else {
				data.top = new FormAttachment(0, 0);
				data.left = new FormAttachment(0, 0);
				data.right = new FormAttachment(100, 0);
			}
			locationBar.setLayoutData(data);
			locationBar.addListener(14, new Listener() {

				public void handleEvent(Event e) {
					browser.setUrl(locationBar.getText());
				}

			});
		}
		if (statusBar) {
			status = new Label(parent, 0);
			progressBar = new ProgressBar(parent, 0);
			data = new FormData();
			data.left = new FormAttachment(0, 5);
			data.right = new FormAttachment(progressBar, 0, -1);
			data.bottom = new FormAttachment(100, -5);
			status.setLayoutData(data);
			data = new FormData();
			data.right = new FormAttachment(100, -5);
			data.bottom = new FormAttachment(100, -5);
			progressBar.setLayoutData(data);
			browser.addStatusTextListener(new StatusTextListener() {

				public void changed(StatusTextEvent event) {
					status.setText(event.text);
				}

			});
		}
		parent.setLayout(new FormLayout());
		org.eclipse.swt.widgets.Control aboveBrowser = ((org.eclipse.swt.widgets.Control) (toolBar ? ((org.eclipse.swt.widgets.Control) (canvas))
				: ((org.eclipse.swt.widgets.Control) (addressBar ? ((org.eclipse.swt.widgets.Control) (locationBar))
						: null))));
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = aboveBrowser == null ? new FormAttachment(0, 0)
				: new FormAttachment(aboveBrowser, 5, -1);
		data.right = new FormAttachment(100, 0);
		data.bottom = status == null ? new FormAttachment(100, 0)
				: new FormAttachment(status, -5, -1);
		browser.setLayoutData(data);
		if (statusBar || toolBar)
			browser.addProgressListener(new ProgressListener() {

				public void changed(ProgressEvent event) {
					if (event.total == 0)
						return;
					int ratio = (event.current * 100) / event.total;
					if (progressBar != null)
						progressBar.setSelection(ratio);
					busy = event.current != event.total;
					if (!busy) {
						index = 0;
						if (canvas != null)
							canvas.redraw();
					}
				}

				public void completed(ProgressEvent event) {
					if (progressBar != null)
						progressBar.setSelection(0);
					busy = false;
					index = 0;
					if (canvas != null) {
						itemBack.setEnabled(browser.isBackEnabled());
						itemForward.setEnabled(browser.isForwardEnabled());
						canvas.redraw();
					}
				}

			});
		if (addressBar || statusBar || toolBar)
			browser.addLocationListener(new LocationListener() {

				public void changed(LocationEvent event) {
					busy = true;
					if (event.top && locationBar != null)
						locationBar.setText(event.location);
				}

				public void changing(LocationEvent locationevent) {
				}

			});
		if (title)
			browser.addTitleListener(new TitleListener() {

				public void changed(TitleEvent event) {
					shell.setText(event.title + " - "
							+ BrowserExample.getResourceString("window.title"));
				}

			});
		parent.layout(true);
		if (owned)
			shell.open();
	}

	public void focus() {
		if (locationBar != null)
			locationBar.setFocus();
		else if (browser != null)
			browser.setFocus();
		else
			parent.setFocus();
	}

	void freeResources() {
		if (images != null) {
			for (int i = 0; i < images.length; i++) {
				Image image = images[i];
				if (image != null)
					image.dispose();
			}

			images = null;
		}
	}

	void initResources() {
		Class clazz = getClass();
		if (resourceBundle != null)
			try {
				if (images == null) {
					images = new Image[imageLocations.length];
					for (int i = 0; i < imageLocations.length; i++) {
						InputStream sourceStream = new FileInputStream(
								"share/browserexample/" + imageLocations[i]);
						ImageData source = new ImageData(sourceStream);
						ImageData mask = source.getTransparencyMask();
						images[i] = new Image(null, source, mask);
						try {
							sourceStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}
				return;
			} catch (Throwable _ex) {
			}
		String error1 = resourceBundle == null ? "Unable to load resources"
				: getResourceString("error.CouldNotLoadResources");
		freeResources();
		throw new RuntimeException(error1);
	}

	public static void main(String args[]) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText(getResourceString("window.title"));
		Image icon = null;
		try {
			InputStream stream = new FileInputStream("share/browserexample/"
					+ iconLocation);
			icon = new Image(display, stream);
			shell.setImage(icon);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BrowserExample app = new BrowserExample(shell, true);
		app.setShellDecoration(icon, true);
		shell.open();
		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
		icon.dispose();
		app.dispose();
		display.dispose();
	}

	static ResourceBundle resourceBundle = null;// ResourceBundle.getBundle("examples_browser");

	int index;

	boolean busy;

	Image images[];

	Image icon;

	boolean title;

	Composite parent;

	Text locationBar;

	Browser browser;

	ToolBar toolbar;

	Canvas canvas;

	ToolItem itemBack;

	ToolItem itemForward;

	Label status;

	ProgressBar progressBar;

	SWTError error;

	static final String imageLocations[] = { "eclipse01.bmp", "eclipse02.bmp",
			"eclipse03.bmp", "eclipse04.bmp", "eclipse05.bmp", "eclipse06.bmp",
			"eclipse07.bmp", "eclipse08.bmp", "eclipse09.bmp", "eclipse10.bmp",
			"eclipse11.bmp", "eclipse12.bmp" };

	static final String iconLocation = "document.gif";

	private class MyVisibilityWindowListener implements
			VisibilityWindowListener {
		public void hide(WindowEvent windowevent) {
		}

		public void show(WindowEvent e) {
			Browser browser = (Browser) e.widget;
			BrowserExample app = (BrowserExample) browser.getData(F1);
			app.show(true, e.location, e.size, e.addressBar, e.menuBar,
					e.statusBar, e.toolBar);
		}
	}

	private static class MyCloseWindowListener implements CloseWindowListener {
		public void close(WindowEvent event) {
			Browser browser = (Browser) event.widget;
			Shell shell = browser.getShell();
			shell.close();
		}
	}
}

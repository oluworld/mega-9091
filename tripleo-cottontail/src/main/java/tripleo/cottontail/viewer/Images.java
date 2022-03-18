package tripleo.cottontail.viewer;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

import java.io.IOException;
import java.io.InputStream;

class Images {

	public void freeAll() {
		for (int i = 0; i < AllBitmaps.length; i++)
			AllBitmaps[i].dispose();

		AllBitmaps = null;
	}

	private static Image createBitmapImage(Display display, String fileName) {
		InputStream sourceStream = Images.class.getResourceAsStream(fileName + ".bmp");
		InputStream maskStream = Images.class.getResourceAsStream(fileName + "_mask.bmp");
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

	public void loadAll(Display display) {
		Bold = createBitmapImage(display, "bold");
		Red = createBitmapImage(display, "red");
		Green = createBitmapImage(display, "green");
		Blue = createBitmapImage(display, "blue");
		Erase = createBitmapImage(display, "erase");
		AllBitmaps = (new Image[]{
			Bold, Red, Green, Blue, Erase
		});
	}

	public Image Bold;
	public Image Red;
	public Image Green;
	public Image Blue;
	public Image Erase;
	private Image[] AllBitmaps;
}

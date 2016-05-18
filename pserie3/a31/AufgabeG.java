package dbv.pserie3.a31;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.PlugIn;
import ij.plugin.filter.*;

public class AufgabeG implements PlugIn {

	public void run(String arg) {

		int width = 400;
		int height = 400;
		int polygonWidth = 40;

		// Calculate AND image
		ImagePlus rgbIp = NewImage.createRGBImage("Aufgabe B", width, height,
				1, NewImage.FILL_BLACK);
		ImageProcessor rgbProcessor = rgbIp.getProcessor();
		rgbProcessor.setColor(new Color(255, 255, 255));
		for (int i = 0; i < width; i += (2 * polygonWidth)) {
			for (int j = 0; j < height; j++) {
				rgbProcessor.fillPolygon(new Polygon(new int[] { i,
						i + polygonWidth / 2, i + polygonWidth }, new int[] {
						0, height, 0 }, 3));
			}
		}

		rgbIp.show();
		rgbIp.updateAndDraw();
	}

}

package dbv.pserie3.a31;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.PlugIn;
import ij.plugin.filter.*;

public class AufgabeA implements PlugIn {

	public void run(String arg) {

		int width = 400;
		int height = 400;
		
		// Calculate AND image
		ImagePlus rgbIp = NewImage.createRGBImage("Aufgabe A", width,
				height, 1, NewImage.FILL_BLACK);
		ImageProcessor rgbProcessor = rgbIp.getProcessor();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				rgbProcessor.set(i, j,
						(255 << 16)
						+ ((255 & 0xff) << 8)
						+ (0 & 0xff));
			}
		}
		
		rgbIp.show();
		rgbIp.updateAndDraw();
	}

}

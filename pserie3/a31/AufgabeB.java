package dbv.pserie3.a31;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.PlugIn;
import ij.plugin.filter.*;

public class AufgabeB implements PlugIn {

	public void run(String arg) {

		int width = 400;
		int height = 400;
		int barWidth = 20;
		
		int r = 0;
		int g = 0;
		
		// Calculate AND image
		ImagePlus rgbIp = NewImage.createRGBImage("Aufgabe B", width,
				height, 1, NewImage.FILL_BLACK);
		ImageProcessor rgbProcessor = rgbIp.getProcessor();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (j % 20 == 0) {
					r = r == 0 ? 255 : 0 ;
					g = g == 0 ? 255 : 0 ;
				}
				rgbProcessor.set(i, j,
						(r << 16)
						+ ((g) << 8)
						+ (0 & 0xff));
			}
		}
		
		rgbIp.show();
		rgbIp.updateAndDraw();
	}

}

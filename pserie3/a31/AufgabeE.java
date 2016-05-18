package dbv.pserie3.a31;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.PlugIn;
import ij.plugin.filter.*;

public class AufgabeE implements PlugIn {

	public void run(String arg) {

		int width = 400;
		int height = 400;
		int intensity = 0;
		int barwidth = 40;
		
		// Calculate AND image
		ImagePlus rgbIp = NewImage.createRGBImage("Aufgabe B", width,
				height, 1, NewImage.FILL_BLACK);
		ImageProcessor rgbProcessor = rgbIp.getProcessor();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (j % barwidth == 0) {
					// reset intensity
					intensity = 0;
				}
				rgbProcessor.set(j, i,
						(intensity << 16)
						+ ((intensity) << 8)
						+ (intensity & 0xff));
				intensity += 255/barwidth;
			}
		}
		
		rgbIp.show();
		rgbIp.updateAndDraw();
	}

}

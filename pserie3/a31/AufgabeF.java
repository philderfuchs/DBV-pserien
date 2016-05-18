package dbv.pserie3.a31;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.PlugIn;
import ij.plugin.filter.*;

public class AufgabeF implements PlugIn {

	public void run(String arg) {

		int width = 400;
		int height = 400;
		int barWidth = 80;
		int currentStartOfBar = 0;

		int intens = 0;

		// Calculate AND image
		ImagePlus rgbIp = NewImage.createRGBImage("Aufgabe F", width, height,
				1, NewImage.FILL_BLACK);
		ImageProcessor rgbProcessor = rgbIp.getProcessor();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (j % barWidth == 0) {
					currentStartOfBar = j;
				}
				double temp = ((double) (j - currentStartOfBar) / (double) barWidth)*2.0*Math.PI;
				intens = 127 + (int) (Math.sin(temp) * (double) 127);
				rgbProcessor.set(j, i, (intens << 16) + ((intens) << 8) + (intens & 0xff));
			}
		}

		rgbIp.show();
		rgbIp.updateAndDraw();
	}

}

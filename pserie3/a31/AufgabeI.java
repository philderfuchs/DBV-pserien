package dbv.pserie3.a31;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.PlugIn;

public class AufgabeI implements PlugIn {

	public void run(String arg) {

		int width = 400;
		int height = 400;
		int ovalDistance = 40;

		// Calculate AND image
		ImagePlus rgbIp = NewImage.createRGBImage("Aufgabe B", width, height,
				1, NewImage.FILL_BLACK);
		ImageProcessor rgbProcessor = rgbIp.getProcessor();
		rgbProcessor.setColor(new Color(255, 255, 255));
		for (int i = 0; i < width/2; i += ovalDistance) {
				rgbProcessor.drawOval(i, i, width-2*i, height-2*i);
			
		}

		rgbIp.show();
		rgbIp.updateAndDraw();
	}

}
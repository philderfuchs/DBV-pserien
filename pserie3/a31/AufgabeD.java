package dbv.pserie3.a31;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.PlugIn;
import ij.plugin.filter.*;

public class AufgabeD implements PlugIn {

	public void run(String arg) {

		int width = 400;
		int height = 400;
		int barWidth = 20;
		
		int c = 0;
		
		// Calculate AND image
		ImagePlus rgbIp = NewImage.createRGBImage("Aufgabe B", width,
				height, 1, NewImage.FILL_BLACK);
		ImageProcessor rgbProcessor = rgbIp.getProcessor();

		for (int i = 0; i < width; i++) {
				if (i % 20 == 0) {
					c = c == 0 ? 255 : 0 ;
					rgbProcessor.setColor(new Color(c, c, c));
				}
				rgbProcessor.drawLine(i, 0, 0, i);		
				rgbProcessor.drawLine(i, 400, 400, i);		
		}
	
		
		rgbIp.show();
		rgbIp.updateAndDraw();
	}

}

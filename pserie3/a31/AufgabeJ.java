package dbv.pserie3.a31;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.PlugIn;

public class AufgabeJ implements PlugIn {

	public void run(String arg) {

		int width = 400;
		int height = 400;
		int stepWidth = 1;

		ImagePlus rgbIp = NewImage.createRGBImage("Aufgabe B", width, height,
				1, NewImage.FILL_BLACK);
		ImageProcessor rgbProcessor = rgbIp.getProcessor();
		rgbProcessor.setColor(new Color(255, 255, 255));
		for (int i = width; i > 0; i-=stepWidth) {
			rgbProcessor.drawOval(-i, -i, 2 * i, 2 * i);
			stepWidth*=2;
		}

		rgbIp.show();
		rgbIp.updateAndDraw();
	}

}
package dbv.pserie3.a31;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.PlugIn;
import ij.plugin.filter.*;

public class AufgabeH implements PlugIn {

	public void run(String arg) {

		int width = 400;
		int height = 400;
		int rectWidth = 40;
		int rectHeight = 20;

		boolean drawWhite = false;
		int c = 0;
		// Calculate AND image
		ImagePlus rgbIp = NewImage.createRGBImage("Aufgabe B", width, height,
				1, NewImage.FILL_BLACK);
		ImageProcessor rgbProcessor = rgbIp.getProcessor();
		for (int i = 0; i < width; i++) {
			if (i % rectWidth == 0)
				drawWhite = !drawWhite;
			for (int j = 0; j < height; j++) {
				if (j % rectHeight == 0)
					drawWhite = !drawWhite;
				c = drawWhite ? 255 : 0;
				rgbProcessor.setColor(new Color(c, c, c));
				rgbProcessor.set(i, j, (c << 16) + ((c & 0xff) << 8)
						+ (c & 0xff));
			}
		}

		rgbIp.show();
		rgbIp.updateAndDraw();
	}

}

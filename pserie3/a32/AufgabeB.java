package dbv.pserie3.a32;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.*;

public class AufgabeB implements PlugIn {

	static int rectWidth;
	static int rectHeight;
	
    public void run(String arg) {
        if (showDialog()) {
        	this.chessBoard(rectWidth, rectHeight);
        }
    }
    
    boolean showDialog() {
        GenericDialog gd = new GenericDialog("Image Rotation");
        gd.addNumericField("Width:", rectWidth, 0);
        gd.addNumericField("Height:", rectHeight, 0);
        gd.showDialog();
        if (gd.wasCanceled()) 
            return false;
        rectWidth = (int) gd.getNextNumber();
        rectHeight = (int) gd.getNextNumber();
        return true;
    }

	public void chessBoard(int rectWidth, int rectHeight) {

		int width = 400;
		int height = 400;

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

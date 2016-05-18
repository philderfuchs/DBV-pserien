package dbv.pserie3.a32;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.*;
import ij.plugin.frame.*;

public class AufgabeA_Rect implements PlugIn {

	static int barWidth;
	
    public void run(String arg) {
        if (showDialog()) {
        	this.drawBars(barWidth);
        }
    }
    
    boolean showDialog() {
        GenericDialog gd = new GenericDialog("Image Rotation");
        gd.addNumericField("Width of Bars:", barWidth, 0);
        gd.showDialog();
        if (gd.wasCanceled()) 
            return false;
        barWidth = (int) gd.getNextNumber();
        return true;
    }

	public void drawBars(int barWidth) {

		int width = 400;
		int height = 400;
		
		int r = 0;
		int g = 0;
		
		// Calculate AND image
		ImagePlus rgbIp = NewImage.createRGBImage("Aufgabe B", width,
				height, 1, NewImage.FILL_BLACK);
		ImageProcessor rgbProcessor = rgbIp.getProcessor();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (j % barWidth == 0) {
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

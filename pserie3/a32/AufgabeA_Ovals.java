package dbv.pserie3.a32;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.*;

public class AufgabeA_Ovals implements PlugIn {

	static int ovalDistance;
	
    public void run(String arg) {
        if (showDialog()) {
        	this.drawBars(ovalDistance);
        }
    }
    
    boolean showDialog() {
        GenericDialog gd = new GenericDialog("Image Rotation");
        gd.addNumericField("Width of Bars:", ovalDistance, 0);
        gd.showDialog();
        if (gd.wasCanceled()) 
            return false;
        ovalDistance = (int) gd.getNextNumber();
        return true;
    }

	public void drawBars(int ovalDistance) {

		int width = 400;
		int height = 400;

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

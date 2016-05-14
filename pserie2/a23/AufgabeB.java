package dbv.pserie2.a23;

import ij.*;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.filter.*;

public class AufgabeB implements PlugInFilter {
	ImagePlus imp;

	public int setup(String arg, ImagePlus imp) {
		this.imp = imp;
		return DOES_ALL;
	}

	public void run(ImageProcessor ip) {
		int width = ip.getWidth();
		int height = ip.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if(ip.getPixel(i, j) >= 120 && ip.getPixel(i, j) <= 130 ){
					ip.set(i, j, 0);
				}
			}
		}
	}

}

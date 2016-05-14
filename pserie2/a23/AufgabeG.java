package dbv.pserie2.a23;

import ij.*;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.filter.*;

public class AufgabeG implements PlugInFilter {
	
	static final int rasterWidth = 10;
	
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
				if(i % rasterWidth == 0 || j % rasterWidth == 0) {
					ip.set(i, j,  ((255 & 0xff)<<16)+((0 & 0xff)<<8) + (0 & 0xff));
				}
			}
		}
	}

}

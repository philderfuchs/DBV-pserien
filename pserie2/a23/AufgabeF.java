package dbv.pserie2.a23;

import ij.*;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.filter.*;

public class AufgabeF implements PlugInFilter {
	ImagePlus imp;

	public int setup(String arg, ImagePlus imp) {
		this.imp = imp;
		return DOES_ALL;
	}

	public void run(ImageProcessor ip) {
		int positions[][] = { { 2, 2 }, { 10, 10 }, { 50, 50 }, { 100, 100 } };

		for (int i = 0; i < positions.length; i++) {
			ip.setColor(new Color(255, 255, 0));
			ip.drawString ("hallo" , positions[i][0], positions[i][1], new Color(0, 0, 0));
			ip.drawRect(positions[i][0], positions[i][1], 5, 5);
		}
	}

}

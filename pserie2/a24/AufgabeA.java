package dbv.pserie2.a24;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.PlugIn;
import ij.plugin.filter.*;

public class AufgabeA implements PlugIn {

	public void run(String arg) {
		int[] wList = WindowManager.getIDList();
		if (wList==null || wList.length<2) {
            IJ.showMessage("There must be at least two windows open");
            return;
        }
		
		ImagePlus ip1 = WindowManager.getImage(wList[0]);
		ImageProcessor processor1 = ip1.getProcessor();
		ImagePlus ip2 = WindowManager.getImage(wList[1]);
		ImageProcessor processor2 = ip2.getProcessor();
		ImagePlus ip3 = NewImage.createImage("test", ip1.getWidth(), ip1.getHeight(), 1, ip1.getBitDepth(), NewImage.FILL_BLACK);
		ImageProcessor processor3 = ip3.getProcessor();
		for (int i = 0; i < ip3.getWidth(); i++) {
			for (int j = 0; j < ip3.getHeight(); j++) {
				processor3.set(i, j, processor1.get(i, j) - processor2.get(i, j));
			}
		}		
		ip3.show();
		ip3.updateAndDraw();
	}
	
}

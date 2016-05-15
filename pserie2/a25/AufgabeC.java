package dbv.pserie2.a25;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;

import ij.plugin.PlugIn;
import ij.plugin.filter.*;

public class AufgabeC implements PlugIn {

	public void run(String arg) {
		int[] wList = WindowManager.getIDList();
		if (wList == null || wList.length < 2) {
			IJ.showMessage("There must be at least two windows open");
			return;
		}

		ImagePlus ip1 = WindowManager.getImage(wList[0]);
		ImageProcessor processor1 = ip1.getProcessor();
		ImagePlus ip2 = WindowManager.getImage(wList[1]);
		ImageProcessor processor2 = ip2.getProcessor();

		// Calculate OR Image
		ImagePlus orIp = NewImage.createImage("OR", ip1.getWidth(),
				ip1.getHeight(), 1, ip1.getBitDepth(), NewImage.FILL_BLACK);
		ImageProcessor orProcessor = orIp.getProcessor();
		for (int i = 0; i < orProcessor.getWidth(); i++) {
			for (int j = 0; j < orProcessor.getHeight(); j++) {
				orProcessor.set(i, j,
						Math.max(processor1.get(i, j), processor2.get(i, j)));
			}
		}

		// Calculate AND image
		ImagePlus diffIp = NewImage.createImage("DIFF", ip1.getWidth(),
				ip1.getHeight(), 1, ip1.getBitDepth(), NewImage.FILL_BLACK);
		ImageProcessor diffProcessor = diffIp.getProcessor();
		for (int i = 0; i < diffProcessor.getWidth(); i++) {
			for (int j = 0; j < diffProcessor.getHeight(); j++) {
				int pixelValue = processor1.get(i, j) - processor2.get(i, j);
				if (pixelValue < 255) pixelValue = 0;
				diffProcessor.set(i, j, pixelValue);
			}
		}
		
		diffIp.show();
		diffIp.updateAndDraw();

		// Calculate RGB Image
		ImagePlus rgbIp = NewImage.createRGBImage("GREEN", ip1.getWidth(),
				ip1.getHeight(), 1, NewImage.FILL_BLACK);
		ImageProcessor rgbProcessor = rgbIp.getProcessor();
		for (int i = 0; i < diffProcessor.getWidth(); i++) {
			for (int j = 0; j < diffProcessor.getHeight(); j++) {
				if(diffProcessor.get(i, j) == 0) {
				rgbProcessor.set(i, j, ((orProcessor.get(i, j) & 0xff) << 16)
						+ ((orProcessor.get(i, j) & 0xff) << 8)
						+ (orProcessor.get(i, j) & 0xff));
				} else {
					rgbProcessor.set(i, j, ((0 & 0xff) << 16)
							+ ((255 & 0xff) << 8)
							+ (0 & 0xff));
				}
			}
		}
		
		rgbIp.show();
		rgbIp.updateAndDraw();
	}

}

package dbv.pserie2.a23;

import ij.*;
import ij.process.*;
import ij.gui.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import ij.plugin.filter.*;

public class AufgabeC implements PlugInFilter {
	ImagePlus imp;
	static final int countOfSubPixelValues = 5;

	public int setup(String arg, ImagePlus imp) {
		this.imp = imp;
		return DOES_ALL;
	}

	public void run(ImageProcessor ip) {
		int width = ip.getWidth();
		int height = ip.getHeight();
		
		// Initialize subPixelValue-Lists
		ArrayList<Integer> meansOfPixelValues = new ArrayList<Integer>();
		ArrayList<Integer> pixelValues = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> subPixelValues = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < AufgabeC.countOfSubPixelValues; i++) {
			subPixelValues.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				pixelValues.add(ip.get(i, j));
			}
		}
		Collections.sort(pixelValues);
		int currentSubPixelValueList = 0;
		int switchListIndicator = 0;
		for (int i = 0; i < pixelValues.size(); i++) {
			subPixelValues.get(currentSubPixelValueList).add(pixelValues.get(i));
			switchListIndicator++;
			if(switchListIndicator == (pixelValues.size()/AufgabeC.countOfSubPixelValues)){
				currentSubPixelValueList++;
				if (currentSubPixelValueList == AufgabeC.countOfSubPixelValues) break;
				switchListIndicator = 0;
			}
		}
		for (ArrayList<Integer> list : subPixelValues) {
			meansOfPixelValues.add(this.calculateMeanOfPixelValue(list));
		}
		
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				for (int k = 0; k < subPixelValues.size(); k++){
					if (ip.get(i, j) >= subPixelValues.get(k).get(0) && 
						ip.get(i, j) <= subPixelValues.get(k).get(subPixelValues.get(k).size() - 1))	{
						ip.set(i, j, meansOfPixelValues.get(k));
					}
				}
			}
		}
		
	}
	
	private int calculateMeanOfPixelValue(ArrayList<Integer> pixelValues) {
		int i = 0;
		for (Integer value : pixelValues) {
			i += value;
		}
		return i/pixelValues.size();
	}

}

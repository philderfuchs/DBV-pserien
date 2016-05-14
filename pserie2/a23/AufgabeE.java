package dbv.pserie2.a23;

import ij.*;
import ij.process.*;
import ij.gui.*;
import java.awt.*;
import ij.plugin.*;
import ij.plugin.frame.*;

public class AufgabeE implements PlugIn {

	static int degree;
	
    public void run(String arg) {
        ImageProcessor ip = IJ.getProcessor();
        if (showDialog()) {
//            ImagePlus imp2 = shrink(imp);
        	ip.rotate(degree*(-1));
        	
        }
    }
    
    boolean showDialog() {
        GenericDialog gd = new GenericDialog("Image Rotation");
        gd.addNumericField("Rotatation Degree:", degree, 0);
        gd.showDialog();
        if (gd.wasCanceled()) 
            return false;
        degree = (int) gd.getNextNumber();
        return true;
    }

}

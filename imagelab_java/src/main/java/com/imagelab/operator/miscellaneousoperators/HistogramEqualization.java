package com.imagelab.operator.miscellaneousoperators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.drawing.DrawCircle;
import com.imagelab.operator.drawing.DrawLine;
import com.imagelab.operator.filtering.ApplyBoxFilter;
import com.imagelab.operator.filtering.ApplyErosion;
import com.imagelab.operator.filtering.ApplyImagePyramid;
import com.imagelab.operator.filtering.ApplyImagePyramidDown;
import com.imagelab.operator.geotransformation.ImageAffine;
import com.imagelab.operator.geotransformation.ImageReflection;
import com.imagelab.operator.geotransformation.RotateImage;
import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import com.imagelab.operator.imagebluring.ApplyGaussianBlurEffect;
import com.imagelab.operator.imagebluring.ApplyMedianBlurEffect;
import com.imagelab.operator.imageconversion.ColoredImageToBinary;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;

public class HistogramEqualization extends OpenCVOperator {

	@Override
	public boolean validate(OpenCVOperator previous) {
		if (previous == null) {
            return false;
        }
        return allowedOperators().contains(previous.getClass());
	}

	@Override
	public Mat compute(Mat image) {
		// TODO Auto-generated method stub
		System.out.println("Applied Histogram Equalization");
	    return histogramEqualization(image);
	}
	
	private Mat histogramEqualization(Mat src) {
		// Creating an empty matrix
		Mat equ = new Mat();
		src.copyTo(equ);
		
		// Applying blur
		Imgproc.blur(equ, equ, new Size(3,3));
		
		//Applying color
		Imgproc.cvtColor(equ, equ, Imgproc.COLOR_BGR2YCrCb);
		List<Mat> channels = new ArrayList<Mat>();

	    // Splitting the channels
	    Core.split(equ, channels);

	    // Equalizing the histogram of the image
	    Imgproc.equalizeHist(channels.get(0), channels.get(0));
	    Core.merge(channels, equ);
	    Imgproc.cvtColor(equ, equ, Imgproc.COLOR_YCrCb2BGR);

	    Mat gray = new Mat();
	    Imgproc.cvtColor(equ, gray, Imgproc.COLOR_BGR2GRAY);
	    Mat grayOrig = new Mat();
	    Imgproc.cvtColor(src, grayOrig, Imgproc.COLOR_BGR2GRAY);
		
		return equ;
	}

	@Override
	public Set<Class<?>> allowedOperators() {
		Set<Class<?>> allowed = new HashSet<>();
		allowed.add(ReadImage.class);
        allowed.add(RotateImage.class);
        allowed.add(WriteImage.class);
        allowed.add(DrawLine.class);
        allowed.add(DrawCircle.class);
        allowed.add(ColoredImageToBinary.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(ApplyBlurEffect.class);
        allowed.add(ApplyGaussianBlurEffect.class);
        allowed.add(ApplyMedianBlurEffect.class);
        allowed.add(ApplyBoxFilter.class);
        allowed.add(ApplyImagePyramidDown.class);
        allowed.add(ApplyImagePyramid.class);
        allowed.add(ApplyErosion.class);
        allowed.add(ImageAffine.class);
        allowed.add(ImageReflection.class);
        return allowed;
	}
	public enum Information {
        /**
         * Operator information in string format.
         */
        OPERATOR_INFO {
            /**
             * @return - Operator information and name
             * of the operator.
             */
            public String toString() {
                return "Histogram Equalization \n\n histogram of an image shows the frequency of pixels intensity values."
                        + " In an image histogram, X-axis shows gray level intensities and Y-axis shows the frequency of these intensities."
                        + " Histogram equalization improves the constrast of an image, in order to stretch out the intensity range."
                        + " You can equlaize the histogram of a given using the method equalizeHist() of the Imgproc class.";
            }
        }
    }

}

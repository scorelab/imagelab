package com.imagelab.operator.miscellaneousoperators;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
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

public class CannyEdgeDetection extends OpenCVOperator{

	private int lowThreshold = 60;
	
	private int highThreshold = 180;

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
		System.out.println("Applied Canny Edge Detection");
        return cannyEdgeDetection(image,getLowThreshold(),getHighThresold());
	}

	private Mat cannyEdgeDetection(Mat src,int low,int high){
		  // Creating an empty matrix to store the result -> store the edges
	      Mat dst = new Mat();
	      // Empty matrix for gry image
	      Mat gray = new Mat();
	      
	      // Converting the image from color to Gray
	      Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
	      
	      // Detecting the edges
	      Imgproc.Canny(gray, dst, low, high);
	     
	      return dst;
	}
	/**
	 * Type integer
	 * @return
	 */
	public int getLowThreshold() {
		return this.lowThreshold;
	}
	/**
     * To set the dilation iteration of the output image.
     *
     * @return - output depth.
     */ 
	public void setLowThreshold(int low) {
		this.lowThreshold = low;
	}
	/**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
    public int getHighThresold() {
        return this.highThreshold;
    }

    /**
     * To set the depth of the output image.
     *
     * @param depth - output depth.
     */
    public void setHighThresold(int high) {
        this.highThreshold = high;
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
                return "Canny Edge Detection \n\n used to detect the edges in an image."
                        + " It accepts a gray scale image as input and it uses a multistage algorithm."
                        + " You can perform this operation on an image using the Canny() function in OpenCV.";
            }
        }
    }
	
	
}

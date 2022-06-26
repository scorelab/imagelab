package com.imagelab.operator.miscellaneousoperators;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
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

public class HoughLineTransform extends OpenCVOperator{

	private int threshold = 100;
	
	private double rho = 1;
	
	private double theta = Math.PI/180; 

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
		System.out.println("Applied Hough Line Transform");
        return houghLineTransform(image,getThreshold(),getRho(),getTheta());
	}

	private Mat houghLineTransform(Mat src,int threshold,double rho,double theta){
		  // Creating an empty matrix to store the result -> store the edges
	      Mat dst = new Mat();
	      // Empty matrix for gray image
	      Mat cannyColor = new Mat();
	      // Detecting edges of it
	      Mat canny = new Mat();
	      Imgproc.Canny(src, canny, 50, 200, 3, false);
	      
	      // Converting the image from color to Gray
	      Imgproc.cvtColor(canny, cannyColor, Imgproc.COLOR_GRAY2BGR);
	      
	      // Detecting the hough line from canny
	      Imgproc.HoughLines(canny, dst, rho, theta, threshold);
	      
	      //Local variables
	      double[] data;
	      //double rho, theta;
	      Point pt1 = new Point();
	      Point pt2 = new Point();
	      double a, b;
	      double x0, y0;
	      
	      //Drawing the lines on the image
	      for (int i = 0; i < dst.cols(); i++) {
	          data = dst.get(0, i);
	          rho = data[0];
	          theta = data[1];
	          
	          a = Math.cos(theta);
	          b = Math.sin(theta);
	          x0 = a*rho;
	          y0 = b*rho;
	          
	          pt1.x = Math.round(x0 + 1000*(-b));
	          pt1.y = Math.round(y0 + 1000*(a));
	          pt2.x = Math.round(x0 - 1000*(-b));
	          pt2.y = Math.round(y0 - 1000 *(a));
	          
	          // Define Line Properties
	          Imgproc.line(cannyColor, pt1, pt2, new Scalar(0, 0, 255), 6);
	       }
	      // return the canny color output
	      return cannyColor;
	}
	/**
	 * Type integer
	 * @return
	 */
	public int getThreshold() {
		return this.threshold;
	}
	/**
     * To set the dilation iteration of the output image.
     *
     * @return - output depth.
     */ 
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	/**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
    public double getRho() {
        return this.rho;
    }

    /**
     * To set the depth of the output image.
     *
     * @param depth - output depth.
     */
    public void setRho(int rho) {
        this.rho = rho;
    }
    /**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
    public double getTheta() {
        return this.theta;
    }

    /**
     * To set the depth of the output image.
     *
     * @param depth - output depth.
     */
    public void setTheta(int theta) {
        this.theta = theta*(Math.PI/180);
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
                return "Hough Line Transform \n\n used to detect shapes given by an image."
                        + " It is transform used to detect stright lines. To apply the Transform,"
                        + " first an edge detection pre-processing is desirable. Usually it uses canny edge detection.";
            }
        }
    }
	
	
}

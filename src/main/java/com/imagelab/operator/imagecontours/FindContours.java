package com.imagelab.operator.imagecontours;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
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
import com.sun.prism.impl.BaseGraphicsResource;

public class FindContours extends OpenCVOperator {

	/*
	 * canny threshold value
	 */
	private int canny_thresh = 100;
	/*
	 * Random number
	 */
	private Random rng = new Random(12345);
	/*
	 * Contour list
	 */
	private static ArrayList<MatOfPoint> contourList;
	/**
	 * Apply validation for the finding contours
	 * Before applying the contours operator pipeline should follow
	 * image conversion with BGR to Gray
	 * image smoothing with blurring
	 */
	@Override
	public boolean validate(OpenCVOperator previous) {
		if (previous == null) {
            return false;
        }else if(previous.getClass() == ApplyBlurEffect.class) {
			System.out.println("Applied Blur for Contours");
		}else if(previous.getClass() == ConvertToGrayscale.class) {
			System.out.println("Applied image conversion for contours");
		}
        return allowedOperators().contains(previous.getClass());
	}

	@Override
	public Mat compute(Mat image) {
		// TODO Auto-generated method stub
		return findContours(image,getThreshold());
	}

	private Mat findContours(Mat src, int threshold) {
		Mat cannyOutput = new Mat();
	    Imgproc.Canny(src, cannyOutput, threshold, threshold * 2);
	    
	    ArrayList<MatOfPoint> contours = new ArrayList<>();
	    Mat hierarchy = new Mat();
	    Imgproc.findContours(cannyOutput, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
	    
	    Mat drawing = Mat.zeros(cannyOutput.size(), CvType.CV_8UC3);
	    
        for (int i = 0; i < contours.size(); i++) {
            Scalar color = new Scalar(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
            Imgproc.drawContours(drawing, contours, i, color, 2, Imgproc.LINE_8, hierarchy, 0, new Point());
        }
        /*
         * Assign private variable to local parameter
         */
        contourList = contours;
	    
		return drawing;
		
	}
	/**
	 * 
	 * @return canny threshold value
	 */
	public int getThreshold() {
		return this.canny_thresh;
	}
	/**
	 * 
	 * @param threshold
	 */
	public void setThreshold(int threshold) {
		this.canny_thresh = threshold;
	}
	/**
	 * 
	 * @return contours mat points as an ArrayList
	 */
	public static ArrayList<MatOfPoint> getContours(){
		return contourList;
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
                return "Find Contours\n\n"
                		+"Contours can be explained simply as a curve joining all the continuous points (along the boundary), "
                		+ "having same color or intensity."
                		+ "The contours are a useful tool for shape analysis and object detection and recognitio."
                		+"You can use findContours() & drawContours() in imgproc class to proceed this action";
            }
        }
    }

}

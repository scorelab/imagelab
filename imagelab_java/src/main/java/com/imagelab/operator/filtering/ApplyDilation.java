package com.imagelab.operator.filtering;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.geotransformation.ColorMaps;
import com.imagelab.operator.geotransformation.ImageAffine;
import com.imagelab.operator.geotransformation.ImageReflection;
import com.imagelab.operator.geotransformation.RotateImage;
import com.imagelab.operator.geotransformation.ScaleImage;
import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import com.imagelab.operator.imagebluring.ApplyGaussianBlurEffect;
import com.imagelab.operator.imagebluring.ApplyMedianBlurEffect;
import com.imagelab.operator.imageconversion.ColoredImageToBinary;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;

public class ApplyDilation extends OpenCVOperator{
	
	/**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
	private int iteration = 1;
	
	/**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
	private double pointX = -1d;
	
	/**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
	private double pointY = -1d;
	
	/**
     * This method contains the logic which validates the applicable
     * openCV operations for a particular openCV operator.
     *
     * @param previous - accepts the previous operator to validate.
     * @return - whether the received operator is valid or not.
     */
	@Override
	public boolean validate(OpenCVOperator previous) {
		if (previous == null) {
            return false;
        }
        return allowedOperators().contains(previous.getClass());
	}
	/**
     * This method contains the openCV operator related specific logic.
     *
     * @param image - accepts the mat object processed from the previous steps.
     * @return - processed computed Mat obj.
     */
	@Override
	public Mat compute(Mat image) {
		// call to the private function
		return applyDilation(image, getIteration(),getPointX(),getPointY());
	}
	/**
     * This method contains the applicable openCV operator for the selected
     * openCV operator.
     *
     * @return - applicable operator.
     */
	@Override
	public Set<Class<?>> allowedOperators() {
		Set<Class<?>> allowed = new HashSet<>();
		allowed.add(ReadImage.class);
        allowed.add(WriteImage.class);
        allowed.add(ImageReflection.class);
        allowed.add(RotateImage.class);
        allowed.add(ColorMaps.class);
        allowed.add(ImageAffine.class);
        allowed.add(ScaleImage.class);
        allowed.add(ColoredImageToBinary.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(ApplyBlurEffect.class);
        allowed.add(ApplyGaussianBlurEffect.class);
        allowed.add(ApplyMedianBlurEffect.class);
        allowed.add(ApplyBoxFilter.class);
        allowed.add(ApplyBilateralFilter.class);
        allowed.add(ApplyImagePyramidDown.class);
        allowed.add(ApplyImagePyramid.class);
        allowed.add(ApplyErosion.class);
        allowed.add(ApplyFilter2D.class);
        allowed.add(ApplySQRBoxFilter.class);
        allowed.add(ApplyMorphological.class);
        return allowed;
	}
	private Mat applyDilation(Mat src,int iteration,double xPoint,double yPoint) {
		 // Creating an empty matrix to store the result
	      Mat image = new Mat();

	      // Preparing the kernel matrix object
	      // only supported 
	      // MorphsShapes supported :- MORPH_RECT,MORPH_CROSS,MORPH_ELLIPSE
	      //
	      Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, 
	         new Size((2*1) +1 , (2*1)+1));
	      
	      Point point = new Point(xPoint, yPoint);

	      // Applying dilate on the Image
	      Imgproc.dilate(src, image, kernel,point,iteration);
	      
	      return image;
		
	}
	/**
     * To get the iteration of dilation of the output image.
     *
     * @return - output depth.
     */
	public int getIteration() {
		return iteration;
	}
	/**
     * To set the dilation iteration of the output image.
     *
     * @return - output depth.
     */ 
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
	
	public double getPointX() {
        return pointX;
    }

    /**
     * To set the point X for the OpenCV Point obj.
     *
     * @param pointX - double.
     */
    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    /**
     * To get the point Y for the OpenCV Point obj.
     *
     * @return pointY.
     */
    public double getPointY() {
        return pointY;
    }

    /**
     * To set the point Y for the OpenCV Point obj.
     *
     * @param pointY - double.
     */
    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

	
	public enum Information{
		OPERATOR_INFO{
			public String toString() {
				return "Dilation\n\n This Filter operation allows"
						+" convolution with some kernel of a specific shape such as a square or a circle"
						+" the size of an object in white shade or bright shade increases."
						+" while the size of an object in black shade or dark shade decreases";
			}
		}
	}
}
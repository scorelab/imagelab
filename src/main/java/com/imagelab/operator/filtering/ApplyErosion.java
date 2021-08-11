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

public class ApplyErosion extends OpenCVOperator{

	// number of times erosion is applied 
	private int iteration = 1;
	
	// anchor :- position of the anchor within the element
	// default :- (-1,-1) which is center
	// point x
	private double pointX = -1d;
	
	// point y
	private double pointY = -1d;
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
		return applyErosion(image,getIteration(),getPointX(),getPointY());
	}

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
        allowed.add(ApplyDilation.class);
        allowed.add(ApplyFilter2D.class);
        allowed.add(ApplySQRBoxFilter.class);
        allowed.add(ApplyMorphological.class);
        return allowed;
	}
	private Mat applyErosion(Mat src,int iteration,double xPoint,double yPoint) {
		// Creating an empty matrix to store the result
	      Mat image = new Mat();

	      // Preparing the kernel matrix object
	      Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, 
	         new  Size((2*2) + 1, (2*2)+1));
	      
	      // create a point for anchor
	      Point point = new Point(xPoint, yPoint);

	      // Applying erode on the Image
	      Imgproc.erode(src, image, kernel,point, iteration);
	      
	      return image;
	}
	/**
     * To get the number of erosion applied.
     *
     * @return iteration.
     */
	public int getIteration() {
		return iteration;
	}
	/**
     * To set the iteration of erosion applied.
     *
     * @return iteration.
     */
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
	/**
     * To get the point X for the OpenCV Point obj.
     *
     * @return pointX.
     */
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
     * To ser the point Y for the OpenCV Point obj.
     *
     * @param pointY - double.
     */
    public void setPointY(double pointY) {
        this.pointY = pointY;
    }
	public enum Information{
		OPERATOR_INFO{
			public String toString() {
				return "Erosion Filter\n\n Erosion is quite a similar process as dilation."
						+" With this procedure the areas of dark regions grow in size and bright regions reduce."
						+" The size of an object in white shade or bright shade increases."
						+" while it decreases in white shade or bright shade";
			}
		}
	}
	
}
package com.imagelab.operator.sobelderivation;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.Mat;
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

public class SobelOperator extends OpenCVOperator {

	private int ddepth = -1;
	
	private int type = 1;

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
		System.out.println("Applied Sobel Derivation");
        return sobelDerivation(image,getDepth(),getType());
	}

	private Mat sobelDerivation(Mat src,int depth,int type) {
		  // Creating an empty matrix to store the result
	      Mat dst = new Mat();
	      switch(type) {
	      	case 1 :  Imgproc.Sobel(src, dst, depth, 0, 1);break;// capture edges with horinzontal direction only
	      	case 2 :  Imgproc.Sobel(src, dst, depth, 1, 0);break;// capture edges with vertical direction only
	      	case 3 :  Imgproc.Sobel(src, dst, depth, 1, 1);break;// capture both vertical and horizontal  
	      }
	      
	      return dst;
	}
	/**
	 * Type integer
	 * @return
	 */
	public int getType() {
		return type;
	}
	/**
     * To set the dilation iteration of the output image.
     *
     * @return - output depth.
     */ 
	public void setType(int type) {
		this.type = type;
	}
	/**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
    public int getDepth() {
        return ddepth;
    }

    /**
     * To set the depth of the output image.
     *
     * @param depth - output depth.
     */
    public void setDepth(int depth) {
        this.ddepth = depth;
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
                return "Sobel Operator\n\nThis operator allows you to"
                        + " detect edges of an image of both horizontal and vertaical direction"
                        + " Moreover it is a first order derivative."
                        + " In order to apply this operation you need to use Sobel() function in OpenCV.";
            }
        }
    }
	
	
}

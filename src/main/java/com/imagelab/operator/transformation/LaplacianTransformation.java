package com.imagelab.operator.transformation;

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

public class LaplacianTransformation extends OpenCVOperator {

	private int ddepth = 10;


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
		System.out.println("Applied Laplacian Transformation");
        return laplacianTransformation(image,getDepth());
	}

	private Mat laplacianTransformation(Mat src,int depth) {
		  // Creating an empty matrix to store the result
	      Mat dst = new Mat();
	      
	      Imgproc.Laplacian(src, dst, depth);
	      
	      return dst;
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
                return "Laplacian Transformation \n\nis also a derivate which used to find edges"
                        + " in an image.It is a second order derivate mask"
                        + " Moreover in this mask two classifications one is Postive Laplacian and Negative Laplacian"
                        + " Unlike other opertors Laplacian diidn't take out edges in any particular direction but it takes"
                        + " out edges in inward edges and outward edges."
                        + " In order to apply this operation you need to use laplacianTramsformation() function in OpenCV.";
            }
        }
    }
	
	
}

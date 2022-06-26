package com.imagelab.operator.transformation;

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

public class DistanceTransformation extends OpenCVOperator {

	private int ddepth = 3;
	
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
		System.out.println("Applied Laplacian Transformation");
        return laplacianTransformation(image,getDepth(),getType());
	}

	private Mat laplacianTransformation(Mat src,int depth,int type){
		  // Creating an empty matrix to store the result
	      Mat dst = new Mat();
	      Mat binary = new Mat();
	      // Converting the grayscale image to binary image
	      Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2GRAY);
	      Imgproc.threshold(src, binary, 100, 255, Imgproc.THRESH_BINARY);
	      //Imgproc.distanceTransform(binary, dst, Imgproc.DIST_L2, 3);
	     
	      switch(type) {
	      	case 1:  Imgproc.distanceTransform(binary, dst, Imgproc.DIST_C, 3);break;
	      	case 2:  Imgproc.distanceTransform(binary, dst, Imgproc.DIST_L1, 3);break;
	      	case 3:  Imgproc.distanceTransform(binary, dst, Imgproc.DIST_L2, 3);break;
	      	case 4:  Imgproc.distanceTransform(binary, dst, Imgproc.DIST_LABEL_PIXEL, 3);break;
	      	case 5:  Imgproc.distanceTransform(binary, dst, Imgproc.DIST_MASK_3, 3);break;
	      }
	      
	      Core.normalize(dst, dst, 0, 1.0, Core.NORM_MINMAX);
	      Core.multiply(dst, new Scalar(255), dst);
	      dst.convertTo(dst, CvType.CV_8U);
	      //Core.convertScaleAbs( dst, dst );
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
                return "Distance Transformation \n\n generally takes binary images as inputs."
                        + " In this operation,the gray level intensities of the points inside the foreground"
                        + " regions are chnaged to distance their respective distances from the closest 0 value."
                        + " In order to apply this operation you need to use distanceTransform() function in OpenCV.";
            }
        }
    }
	
	
}

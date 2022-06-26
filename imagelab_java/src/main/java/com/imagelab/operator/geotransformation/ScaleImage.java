package com.imagelab.operator.geotransformation;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.drawing.DrawArrowLine;
import com.imagelab.operator.drawing.DrawCircle;
import com.imagelab.operator.drawing.DrawEllipse;
import com.imagelab.operator.drawing.DrawLine;
import com.imagelab.operator.drawing.DrawRectangle;
import com.imagelab.operator.drawing.DrawText;
import com.imagelab.operator.filtering.ApplyBoxFilter;
import com.imagelab.operator.filtering.ApplyErosion;
import com.imagelab.operator.filtering.ApplyFilter2D;
import com.imagelab.operator.filtering.ApplyImagePyramid;
import com.imagelab.operator.filtering.ApplyImagePyramidDown;
import com.imagelab.operator.filtering.ApplySQRBoxFilter;
import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import com.imagelab.operator.imagebluring.ApplyGaussianBlurEffect;
import com.imagelab.operator.imagebluring.ApplyMedianBlurEffect;
import com.imagelab.operator.imageconversion.ColoredImageToBinary;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;

public class ScaleImage extends OpenCVOperator{
	
	private double fx = 0.5d;
	private double fy = 0.5d;
	private int dsize = 1;
	

	@Override
	public boolean validate(OpenCVOperator previous) {
		if (previous == null) {
            return false;
        }
        return allowedOperators().contains(previous.getClass());
	}

	@Override
	public Mat compute(Mat image) {
		System.out.println("Image Scaled");
        return scaleImage(image,getX(),getY());
	}

	private Mat scaleImage(Mat image,double x,double y) {
		// Creating an empty matrix to store the result
	      Mat dst = new Mat();

	      // Creating the Size object
	      Size size = new Size(image.rows()*x, image.rows()*y);

	      // Scaling the Image
	      Imgproc.resize(image, dst, size, x, y, Imgproc.INTER_AREA);
	      return dst;
	}

	@Override
	public Set<Class<?>> allowedOperators() {
		Set<Class<?>> allowed = new HashSet<>();
		allowed.add(ReadImage.class);
        allowed.add(WriteImage.class);
        allowed.add(RotateImage.class);
        allowed.add(ColorMaps.class);
        allowed.add(ImageAffine.class);
        allowed.add(ImageReflection.class);
        allowed.add(ColoredImageToBinary.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(ApplyBlurEffect.class);
        allowed.add(ApplyGaussianBlurEffect.class);
        allowed.add(ApplyMedianBlurEffect.class);
        allowed.add(ApplyBoxFilter.class);
        allowed.add(ApplyImagePyramidDown.class);
        allowed.add(ApplyImagePyramid.class);
        allowed.add(ApplyErosion.class);
        allowed.add(ApplyFilter2D.class);
        allowed.add(ApplySQRBoxFilter.class);
        allowed.add(DrawArrowLine.class);
        allowed.add(DrawLine.class);
        allowed.add(DrawCircle.class);
        allowed.add(DrawEllipse.class);
        allowed.add(DrawRectangle.class);
        allowed.add(DrawText.class);
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
                return "Scale Image\n\nThis operator allows you to"
                        + " scale an image to a specific size."
                        + " Moreover you can change angle and scale"
                        + " related to the rotation.";
            }
        }
    }
	 /**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
    public double getX() {
        return fx;
    }

    /**
     * To set the depth of the output image.
     *
     * @param depth - output depth.
     */
    public void setX(double fx) {
        this.fx = fx;
    }
    /**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
    public double getY() {
        return fy;
    }

    /**
     * To set the depth of the output image.
     *
     * @param depth - output depth.
     */
    public void setY(double fy) {
        this.fy = fy;
    }
}

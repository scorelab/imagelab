package com.imagelab.operator.filtering;

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
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;


public class ApplyImagePyramid extends OpenCVOperator {

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
		return imagePyramidsUp(image);
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
        allowed.add(ApplyDilation.class);
        allowed.add(ApplyErosion.class);
        allowed.add(ApplyFilter2D.class);
        allowed.add(ApplySQRBoxFilter.class);
        allowed.add(ApplyMorphological.class);
        return allowed;
	}
	
	private Mat imagePyramidsUp(
					Mat src) {
		// Creating an empty matrix to store the result
        Mat image = new Mat();

        // Set the new Size of Image to double of the size of the Image
        // Code can be changed into the user inputed size application limited to the size 400*300 by UI Element Operator
        

        // Applying Pyramid up filter on the Image
        Imgproc.pyrUp(src,image,new Size(src.cols()*2, src.rows()*2),Core.BORDER_DEFAULT);
        
        
        return image;
	}
	/* 
	 * Information regarding the Image Pyramids operator
	 * */
	public enum Information{
		OPERATOR_INFO{
			public String toString() {
				return "Pyramids Up\n\n This Filter operation allows"
						+" Pyramid, or pyramid representation, is a type of multi scale signal reprsenatation"
						+" in which a signal or an image is subject to repeated smooted and subsampling"
						+" you to apply pyramid up effect to your image"
						+" image is initially up-sampled and then blurred from this filter."
						+" use scaler to up sampled the image";
			}
		}
	}
	
}
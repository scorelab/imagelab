package com.imagelab.operator.filtering;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.filtering.ApplyBoxFilter;
import com.imagelab.operator.filtering.ApplyDilation;
import com.imagelab.operator.filtering.ApplyErosion;
import com.imagelab.operator.filtering.ApplyImagePyramid;
import com.imagelab.operator.filtering.ApplyImagePyramidDown;
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

public class ApplyMorphological extends OpenCVOperator {

	// Define the morphological operator type	
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
		// call to the private function
		return MorphologicalOperator(image);
	}
	
	private Mat MorphologicalOperator(Mat src) {
		  // Create an empty image matrix
		  Mat image = new Mat();
		  // Creating kernel matrix
		
	      Mat kernel = Mat.ones(5,5, CvType.CV_32F);

	    //Morphological operator switch statement to applying to the image
			switch(type) {
			case 1 : Imgproc.morphologyEx(src, image, Imgproc.MORPH_TOPHAT, kernel);break;
			case 2 : Imgproc.morphologyEx(src, image, Imgproc.MORPH_CLOSE, kernel);break;
			case 3 : Imgproc.morphologyEx(src, image, Imgproc.MORPH_CROSS, kernel);break;
			case 4 : Imgproc.morphologyEx(src, image, Imgproc.MORPH_GRADIENT, kernel);break;
			case 5 : Imgproc.morphologyEx(src, image, Imgproc.MORPH_RECT, kernel);break;
			case 6 : Imgproc.morphologyEx(src, image, Imgproc.MORPH_BLACKHAT, kernel);break;
			case 7 : Imgproc.morphologyEx(src, image, Imgproc.MORPH_OPEN, kernel);break;
		  }
	      
	      return image;
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
        allowed.add(ApplyImagePyramid.class);
        allowed.add(ApplyImagePyramidDown.class);
        allowed.add(ApplyDilation.class);
        allowed.add(ApplyErosion.class);
        allowed.add(ApplyFilter2D.class);
        allowed.add(ApplySQRBoxFilter.class);
        return allowed;
	}
	/**
	 * Get the type
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

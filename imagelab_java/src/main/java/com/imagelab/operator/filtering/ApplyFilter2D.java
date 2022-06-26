package com.imagelab.operator.filtering;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.CvType;
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

public class ApplyFilter2D extends OpenCVOperator {
	/**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
	private int ddepth = -1;
	
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
		return applyFilter2D(image, getDepth());
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
        allowed.add(ApplyDilation.class);
        allowed.add(ApplySQRBoxFilter.class);
        allowed.add(ApplyMorphological.class);
        return allowed;
	}
	private Mat applyFilter2D(Mat src, int ddepth) {
		 // Creating an empty matrix to store the result
	      Mat image = new Mat();
	      
	      // creating kernel matrix
	      Mat kernel = Mat.ones(2,2, CvType.CV_32F);
	      
	      //construct the kernel
	      for(int i = 0; i<kernel.rows(); i++) {
	          for(int j = 0; j<kernel.cols(); j++) {
	             double[] m = kernel.get(i, j);

	             for(int k = 1; k<m.length; k++) {
	                m[k] = m[k]/(2 * 2);
	             }
	             kernel.put(i,j, m);
	          }
	       }
	      //Apply the filter to convoluate
	      Imgproc.filter2D(src, image, ddepth, kernel);
	      
	      return image;
		
	}
	/**
     * To get the ddepth of the output image.
     *
     * @return - output depth.
     */
	public int getDepth() {
		return ddepth;
	}
	/**
     * To set the filter depth of the output image.
     *
     * @return - output depth.
     */ 
	public void setDepth(int depth) {
		this.ddepth = depth;
	}
		
	public enum Information{
		OPERATOR_INFO{
			public String toString() {
				return "Filter2D\n\n This Filter operation"
						+" convolves an image with the kernel. ddepth respresent the depth of output image."
						+" You can perfrom this operation on an image using the Filter2D() method of imgproc class.";
			}
		}
	}
}

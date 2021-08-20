package com.imagelab.operator.filtering;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
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

public class ApplySQRBoxFilter extends OpenCVOperator{

	/**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
	private int ddepth = -1;
	
	/**
	 * To get the ksize x
	 */
	private int ksizex = 1;
	/**
	 * To get the ksize y
	 */
	private int ksizey = 1;
	
	
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
		
		return applySQRBox(image, getDepth(),getX(),getY());
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
        allowed.add(ApplyImagePyramid.class);
        allowed.add(ApplyImagePyramidDown.class);
        allowed.add(ApplyDilation.class);
        allowed.add(ApplyErosion.class);
        allowed.add(ApplyFilter2D.class);
        allowed.add(ApplyMorphological.class);
        return allowed;
	}
	private Mat applySQRBox(Mat src, int ddepth,int x,int y) {
		  // Creating an empty matrix to store the result
	      Mat image = new Mat();
	      
	      //Apply the filter
	      Imgproc.sqrBoxFilter(src, image, ddepth, new Size(x,y));
	      
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
	/**
	 * 
	 * @return ksizex
	 */
	public int getX() {
		return ksizex;
	}
	/**
	 * Set the ksizex
	 * @param x
	 */
	public void setX(int x) {
		this.ksizex = x;
	}
	/**
	 * 
	 * @return ksizey
	 */
	public int getY() {
		return ksizey;
	}
	/**
	 * set the value ksizey
	 * @param y
	 */
	public void setY(int y) {
		this.ksizey = y;
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

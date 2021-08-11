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

public class ApplyBilateralFilter extends OpenCVOperator{

	/**
     * To get the frame size of the output image.
     *
     * @return - output depth.
     */
	private int filterSize = 5;
	
	/**
     * To get the sigma color of the output image.
     *
     * @return - output depth.
     */
	private double sigmaColor = 80d;
	
	/**
     * To get the sigma space of the output image.
     *
     * @return - output depth.
     */
	private double sigmaSpace = 80d;
	
	// encapsulate fields
	public int getFilterSize() {
		return filterSize;
	}
	public void setFilterSize(int filterSize) {
		this.filterSize = filterSize;
	}
	public double getSigmaColor() {
		return sigmaColor;
	}
	public void setSigmaColor(double sigmaColor) {
		this.sigmaColor = sigmaColor;
	}
	public double getSigmaSpace() {
		return sigmaSpace;
	}
	public void setSigmaSpace(double sigmaSpace) {
		this.sigmaSpace = sigmaSpace;
	}
	
	private Mat applyBilateral(Mat src,int filterSize,double sigmaColor,double sigmaSpace) {
		 // Creating an empty matrix to store the result
	      Mat image = new Mat();

	      // Applying bilateral filter on the Image
	      Imgproc.bilateralFilter(src, image, filterSize, sigmaColor, sigmaSpace);
	      
	      return image;
		
	}
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
		return applyBilateral(image, getFilterSize(),getSigmaColor(),getSigmaSpace());
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
        allowed.add(ApplyImagePyramidDown.class);
        allowed.add(ApplyImagePyramid.class);
        allowed.add(ApplyDilation.class);
        allowed.add(ApplyErosion.class);
        allowed.add(ApplyFilter2D.class);
        allowed.add(ApplySQRBoxFilter.class);
        allowed.add(ApplyMorphological.class);
        return allowed;
	}
	public enum Information{
		OPERATOR_INFO{
			public String toString() {
				return "Bilateral Filter\n\n This Filter can reduce unwanted noise very well while keeping edges fairly sharpe"
						+" ,It is very slow compared to most filters"
						+" Sigma Values: If they are small(<10), filter will not have much effect."
						+" whereas if they are large(>150), they will have a very strong effect, making image look cartoonish";
			}
		}
	}
}
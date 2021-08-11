package com.imagelab.operator.geotransformation;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.Mat;
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
import com.imagelab.operator.filtering.ApplyDilation;
import com.imagelab.operator.filtering.ApplyErosion;
import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import com.imagelab.operator.imagebluring.ApplyGaussianBlurEffect;
import com.imagelab.operator.imagebluring.ApplyMedianBlurEffect;
import com.imagelab.operator.imageconversion.ColoredImageToBinary;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;

public class ColorMaps extends OpenCVOperator{

	
	/**
     * To get the type of color map.
     *
     * @return - output type with number int.
     */
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
		return applyColorMaps(image, getType());
	}
	
	private Mat applyColorMaps(Mat image,int type) {
		
		Mat dst = new Mat();
		//Color map to applying to the image
		switch(type) {
		case 1 : Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_HOT);break;
		case 2 : Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_AUTUMN);break;
		case 3 : Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_BONE);break;
		case 4 : Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_COOL);break;
		case 5 : Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_RAINBOW);break;
		case 6 : Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_HSV);break;
		case 7 : Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_JET);break;
		case 8 : Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_OCEAN);break;
		case 9 : Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_PARULA);break;
		case 10 :Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_PINK);break;
		case 11 :Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_SPRING);break;
		case 12 :Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_SUMMER);break;
		case 13 :Imgproc.applyColorMap(image, dst, Imgproc.COLORMAP_WINTER);break;
		}
		//return the return image
		return dst;
	}

	@Override
	public Set<Class<?>> allowedOperators() {
		Set<Class<?>> allowed = new HashSet<>();
		allowed.add(ReadImage.class);
        allowed.add(WriteImage.class);
        allowed.add(RotateImage.class);
        allowed.add(ScaleImage.class);
        allowed.add(ImageAffine.class);
        allowed.add(ImageReflection.class);
        allowed.add(ColoredImageToBinary.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(ApplyBlurEffect.class);
        allowed.add(ApplyGaussianBlurEffect.class);
        allowed.add(ApplyMedianBlurEffect.class);
        allowed.add(ApplyBoxFilter.class);
        allowed.add(ApplyDilation.class);
        allowed.add(ApplyErosion.class);
        allowed.add(DrawArrowLine.class);
        allowed.add(DrawLine.class);
        allowed.add(DrawCircle.class);
        allowed.add(DrawEllipse.class);
        allowed.add(DrawRectangle.class);
        allowed.add(DrawText.class);
        return allowed;
		
	}
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
				return "Color Maps\n\n Colormaps can apply different color maps to an image using this method."
						+" OpenCV caters various other types"
						+" All these types are represents by predefined static fields(fixed values)";
						
			}
		}
	}
	
}
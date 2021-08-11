package com.imagelab.operator.geotransformation;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.CvType;
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
import com.imagelab.operator.filtering.ApplyErosion;
import com.imagelab.operator.filtering.ApplyImagePyramid;
import com.imagelab.operator.filtering.ApplyImagePyramidDown;
import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import com.imagelab.operator.imagebluring.ApplyGaussianBlurEffect;
import com.imagelab.operator.imagebluring.ApplyMedianBlurEffect;
import com.imagelab.operator.imageconversion.ColoredImageToBinary;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;

public class ImageReflection extends OpenCVOperator {

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
		System.out.println("Image Reflection Applied");
		return ImageReflection(image, getType());
	}
	public Mat ImageReflection(Mat src,int type) {
		//Creating an empty matrix to store the result
	    Mat dst = new Mat();
	    
		Mat mapX = new Mat(src.size(), CvType.CV_32F);
        Mat mapY = new Mat(src.size(), CvType.CV_32F);
        
        float buffX[] = new float[(int) (mapX.total() * mapX.channels())];
        mapX.get(0, 0, buffX);
        float buffY[] = new float[(int) (mapY.total() * mapY.channels())];
        mapY.get(0, 0, buffY);
        
        switch(type) {
			case 1 : 
				for (int i = 0; i < mapX.rows(); i++) {
		            for (int j = 0; j < mapX.cols(); j++) {
		                    buffX[i*mapX.cols() + j] = j;
		                    buffY[i*mapY.cols() + j] = mapY.rows() - i;
		                }
		        }
				break;
	        case 2:
	        	for (int i = 0; i < mapX.rows(); i++) {
		            for (int j = 0; j < mapX.cols(); j++) {
			            buffX[i*mapX.cols() + j] = mapY.cols() - j;
			            buffY[i*mapY.cols() + j] = i;
		            }
	        	}
	            break;
	        case 3:
	        	for (int i = 0; i < mapX.rows(); i++) {
		            for (int j = 0; j < mapX.cols(); j++) {
		            	buffX[i*mapX.cols() + j] = mapY.cols() - j;
		                buffY[i*mapY.cols() + j] = mapY.rows() - i;
		            }
	        	}
	            break;
	        default:
	            break;
        }
		
        mapX.put(0, 0, buffX);
        mapY.put(0, 0, buffY);
        
        Imgproc.remap(src, dst, mapX, mapY, Imgproc.INTER_LINEAR);
		return dst;
	}

	@Override
	public Set<Class<?>> allowedOperators() {
		Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        allowed.add(RotateImage.class);
        allowed.add(WriteImage.class);
        allowed.add(ScaleImage.class);
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
        allowed.add(ScaleImage.class);
        allowed.add(ImageAffine.class);
        allowed.add(ImageReflection.class);
        allowed.add(DrawArrowLine.class);
        allowed.add(DrawLine.class);
        allowed.add(DrawCircle.class);
        allowed.add(DrawEllipse.class);
        allowed.add(DrawRectangle.class);
        allowed.add(DrawText.class);
        return allowed;
	}
	/**
	 * 
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
	public enum Information{
		OPERATOR_INFO{
			public String toString() {
				return "Reflection(ReMapping)\n\n "
						+"Refelction produces a missror image like about and\n"
						+"an axis of reflection. There are two type of reflection.\n"
						+"One is x direction reflection and other is y direction reflection\n";
			}
		}
	}

	
}

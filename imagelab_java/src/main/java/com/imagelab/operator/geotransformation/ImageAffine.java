package com.imagelab.operator.geotransformation;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
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
import com.imagelab.operator.filtering.ApplyImagePyramid;
import com.imagelab.operator.filtering.ApplyImagePyramidDown;
import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import com.imagelab.operator.imagebluring.ApplyGaussianBlurEffect;
import com.imagelab.operator.imagebluring.ApplyMedianBlurEffect;
import com.imagelab.operator.imageconversion.ColoredImageToBinary;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;

public class ImageAffine extends OpenCVOperator{

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
		System.out.println("Image Affine Applied");
		return imageAffine(image);
	}
	
	private Mat imageAffine(Mat src) {

	      //Creating an empty matrix to store the result
	      Mat dst = new Mat();

	      Point p1 = new Point( 0,0 );
	      Point p2 = new Point( src.cols() - 1, 0 );
	      Point p3 = new Point( 0, src.rows() - 1 );
	      Point p4 = new Point( src.cols()*0.0, src.rows()*0.33 );
	      Point p5 = new Point( src.cols()*0.85, src.rows()*0.25 );
	      Point p6 = new Point( src.cols()*0.15, src.rows()*0.7 );
	      
	      MatOfPoint2f ma1 = new MatOfPoint2f(p1,p2,p3);
	      MatOfPoint2f ma2 = new MatOfPoint2f(p4,p5,p6);

	      // Creating the transformation matrix
	      Mat tranformMatrix = Imgproc.getAffineTransform(ma1,ma2);

	      // Creating object of the class Size
	      Size size = new Size(src.cols(), src.cols());

	      // Applying Wrap Affine
	      Imgproc.warpAffine(src, dst, tranformMatrix, size);
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
        allowed.add(DrawArrowLine.class);
        allowed.add(DrawLine.class);
        allowed.add(DrawCircle.class);
        allowed.add(DrawEllipse.class);
        allowed.add(DrawRectangle.class);
        allowed.add(DrawText.class);
        return allowed;
	}
	public enum Information{
		OPERATOR_INFO{
			public String toString() {
				return "Image Affine Transformation\n\n"
						+"Image Affine Translation or shearing express in a materix form.\n"
						+"It's a combination of shearing and reflection\n";
			}
		}
	}

}

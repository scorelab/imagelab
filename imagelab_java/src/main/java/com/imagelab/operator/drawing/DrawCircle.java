package com.imagelab.operator.drawing;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.filtering.ApplyBilateralFilter;
import com.imagelab.operator.filtering.ApplyBoxFilter;
import com.imagelab.operator.filtering.ApplyDilation;
import com.imagelab.operator.filtering.ApplyErosion;
import com.imagelab.operator.filtering.ApplyFilter2D;
import com.imagelab.operator.filtering.ApplyImagePyramid;
import com.imagelab.operator.filtering.ApplyImagePyramidDown;
import com.imagelab.operator.filtering.ApplySQRBoxFilter;
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
import com.imagelab.operator.sobelderivation.ScharrOperator;
import com.imagelab.operator.sobelderivation.SobelOperator;
import com.imagelab.operator.transformation.DistanceTransformation;
import com.imagelab.operator.transformation.LaplacianTransformation;
import com.imagelab.view.forms.DilationFilterPropertiesForm;

public class DrawCircle extends OpenCVOperator{
	
	/*
	 * radius value of the circle
	 */
	private int radius = 100;
	
	private int thickness = 5;
	/**
     * pointX value for the openCV point.
     */
    private double pointX = 230d;
    /**
     * pointY value of the openCV point.
     */
    private double pointY = 160d;
	/*
	 * Red value of the color
	 */
    private int R = 10;
    /*
	 * Red value of the color
	 */
    private int G = 10;
    /*
	 * Red value of the color
	 */
    private int B = 10;
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getThickness() {
		return thickness;
	}
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	public int getR() {
		return R;
	}
	public void setR(int r) {
		this.R = r;
	}
	public int getG() {
		return G;
	}
	public void setG(int g) {
		this.G = g;
	}
	public int getB() {
		return B;
	}
	public void setB(int b) {
		this.B = b;
	}
    /*
     * get the pointX value
     * 
     */
	public double getPointX() {
        return pointX;
    }

    /**
     * To set the point X for the OpenCV Point obj.
     *
     * @param pointX - double.
     */
    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    /**
     * To get the point Y for the OpenCV Point obj.
     *
     * @return pointY.
     */
    public double getPointY() {
        return pointY;
    }

    /**
     * To set the point Y for the OpenCV Point obj.
     *
     * @param pointY - double.
     */
    public void setPointY(double pointY) {
        this.pointY = pointY;
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
		// TODO Auto-generated method stub
		return drawCircle(image,getRadius(),getThickness(),getPointX(),getPointY(),
				getR(),getG(),getB()
				);
	}

	private Mat drawCircle(Mat src,int radius,int thickness,double pointX,double pointY,
			int r, int g , int b) {
		// Creating an empty matrix to store the result
        Mat image = new Mat();
        Point point = new Point(pointX, pointY);
        Scalar scalar = new Scalar(b,g,r);
        // Applying Pyramid up filter on the Image
        Imgproc.circle(src,point,radius,scalar,thickness);
        // Return the procceed image
        return src;
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
        allowed.add(ApplyBilateralFilter.class);
        allowed.add(ApplyBoxFilter.class);
        allowed.add(ApplyDilation.class);
        allowed.add(ApplyErosion.class);
        allowed.add(ApplyFilter2D.class);
        allowed.add(ApplyImagePyramidDown.class);
        allowed.add(ApplyImagePyramid.class);
        allowed.add(ApplySQRBoxFilter.class);
        allowed.add(DrawArrowLine.class);
        allowed.add(DrawLine.class);
        allowed.add(DrawCircle.class);
        allowed.add(DrawEllipse.class);
        allowed.add(DrawRectangle.class);
        allowed.add(DrawText.class);
        allowed.add(ScharrOperator.class);
        allowed.add(SobelOperator.class);
        allowed.add(DistanceTransformation.class);
        allowed.add(LaplacianTransformation.class);
        return allowed;
	}
	/* 
	 * Information regarding the Image Pyramids operator
	 * */
	public enum Information{
		OPERATOR_INFO{
			public String toString() {
				return "Drawing Circle\n\n "
						+"You can draw various shape like Circle, Rectangle, Line, Ellipse, polylines, Convex,"
						+"Polylines on an image using respective methods."
						+"You can draw a circle on an image using the method circle()";
						
			}
		}
	}
}
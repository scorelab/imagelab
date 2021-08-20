package com.imagelab.operator.histogram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
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
import com.imagelab.operator.imagecontours.BoundingBoxesForContours;
import com.imagelab.operator.imagecontours.ConvexHull;
import com.imagelab.operator.imagecontours.FindContours;
import com.imagelab.operator.imagecontours.ImageMoments;
import com.imagelab.operator.imageconversion.ColoredImageToBinary;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;
import com.imagelab.operator.miscellaneousoperators.CannyEdgeDetection;
import com.imagelab.operator.miscellaneousoperators.HistogramEqualization;
import com.imagelab.operator.miscellaneousoperators.HoughLineTransform;
import com.imagelab.operator.sobelderivation.ScharrOperator;
import com.imagelab.operator.sobelderivation.SobelOperator;
import com.imagelab.operator.transformation.DistanceTransformation;
import com.imagelab.operator.transformation.LaplacianTransformation;

import javafx.scene.image.Image;

public class HistogramCalculation extends OpenCVOperator{

	private Mat histImageProcessed;
	
	boolean gray = false;
	
	private int[] rdata;
	
	private int[] gdata;
	
	private int[] bdata;
	
	@Override
	public boolean validate(OpenCVOperator previous) {
		if (previous == null) {
            return false;
        }else if(previous.getClass() == ConvertToGrayscale.class ) {
			//return false;
        	gray = true;
		}
        return allowedOperators().contains(previous.getClass());
	}

	@Override
	public Mat compute(Mat image) {
		// TODO Auto-generated method stub
		return histogramCalculation(image);
		//return image;
	}
	
	private Mat histogramCalculation(Mat src) {
		
		ArrayList <Mat> bgrPlanes = new ArrayList<>();
        
		Core.split(src, bgrPlanes);
		
        int histSize = 256;
        float[] range = {0, 256}; //the upper boundary is exclusive
        MatOfFloat histRange = new MatOfFloat(range);
        
        boolean accumulate = false;
        
        Mat bHist = new Mat(), gHist = new Mat(), rHist = new Mat();
        
        int histW = 512, histH = 300;
	    int binW = (int) Math.round((double) histW / histSize);
	    Mat histImage = new Mat( histH, histW, CvType.CV_8UC3, new Scalar( 255,255,255) ); 
	    /**
	     * When the gray equals to zero
	     */
        if(!gray) {
	        Imgproc.calcHist(bgrPlanes, new MatOfInt(0), new Mat(), bHist, new MatOfInt(histSize), histRange, accumulate);
	        Imgproc.calcHist(bgrPlanes, new MatOfInt(1), new Mat(), gHist, new MatOfInt(histSize), histRange, accumulate);
	        Imgproc.calcHist(bgrPlanes, new MatOfInt(2), new Mat(), rHist, new MatOfInt(histSize), histRange, accumulate);
	       
		    Core.normalize(bHist, bHist, 0, histImage.rows(), Core.NORM_MINMAX);
	        Core.normalize(gHist, gHist, 0, histImage.rows(), Core.NORM_MINMAX);
	        Core.normalize(rHist, rHist, 0, histImage.rows(), Core.NORM_MINMAX);
	        
		    float[] bHistData = new float[(int) (bHist.total() * bHist.channels())];
	        bHist.get(0, 0, bHistData);
	        
	        int[] bdata = new int[(int) (rHist.total() * rHist.channels())];
	        
	        float[] gHistData = new float[(int) (gHist.total() * gHist.channels())];
	        gHist.get(0, 0, gHistData);
	        
	        int[] gdata = new int[(int) (gHist.total() * gHist.channels())];
	        
	        float[] rHistData = new float[(int) (rHist.total() * rHist.channels())];
	        rHist.get(0, 0, rHistData);
	        
	        int[] rdata = new int[(int) (bHist.total() * bHist.channels())];
	        
	        for( int i = 1; i < histSize; i++ ) {
	            Imgproc.line(histImage, new Point(binW * (i - 1), histH - Math.round(bHistData[i - 1])),
	                    new Point(binW * (i), histH - Math.round(bHistData[i])), new Scalar(255, 0, 0), 2);
	            Imgproc.line(histImage, new Point(binW * (i - 1), histH - Math.round(gHistData[i - 1])),
	                    new Point(binW * (i), histH - Math.round(gHistData[i])), new Scalar(0, 255, 0), 2);
	            Imgproc.line(histImage, new Point(binW * (i - 1), histH - Math.round(rHistData[i - 1])),
	                    new Point(binW * (i), histH - Math.round(rHistData[i])), new Scalar(0, 0, 255), 2);
	        }
	    /**
	     * when gray equals to true
	     */
        }else {
        	//This function calls only when the image with only one channel
        	Imgproc.calcHist(bgrPlanes, new MatOfInt(0), new Mat(), bHist, new MatOfInt(histSize), histRange, accumulate);
        	
        	Core.normalize(bHist, bHist, 0, histImage.rows(), Core.NORM_MINMAX);
        	
        	float[] bHistData = new float[(int) (bHist.total() * bHist.channels())];
	        bHist.get(0, 0, bHistData);
	        
	        for( int i = 1; i < histSize; i++ ) {
	            Imgproc.line(histImage, new Point(binW * (i - 1), histH - Math.round(bHistData[i - 1])),
	                    new Point(binW * (i), histH - Math.round(bHistData[i])), new Scalar(97, 106, 107), 2);
	        }
        }
        System.out.println(histSize);
        // assign image to computed version
    	return histImage;
	}
	
	public int getR(int i) {
		System.out.println(rdata[i]);
		return rdata[i];
	}
	
	public int[] getG() {
		return gdata;
	}
	
	public int[] getB() {
		return bdata;
	}

	@Override
	public Set<Class<?>> allowedOperators() {
		Set<Class<?>> allowed = new HashSet<>();
		allowed.add(ReadImage.class);
        allowed.add(WriteImage.class);
        allowed.add(RotateImage.class);
        allowed.add(ColorMaps.class);
        allowed.add(ScaleImage.class);
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
        allowed.add(ImageAffine.class);
        allowed.add(ImageReflection.class);
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
        allowed.add(CannyEdgeDetection.class);
        allowed.add(HistogramEqualization.class);
        allowed.add(HoughLineTransform.class);
        allowed.add(BoundingBoxesForContours.class);
        allowed.add(FindContours.class);
        allowed.add(ImageMoments.class);
        allowed.add(ConvexHull.class);
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
                return "Histogram Calculation\n\n"
                		+"Histograms are collected counts of data organized into a set of predefined bins."
                		+"If the image is RGB it has 3 channels or image is in Gray it has only 1 channel."
                		+"Moreover it displays the frequency values of the image pixels with respect to the intensities of each channel.";
            }
        }
    }

}

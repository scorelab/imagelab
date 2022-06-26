package com.imagelab.operator.imagecontours;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;

public class ImageMoments extends OpenCVOperator {

	/*
	 * Contours
	 */
	private ArrayList<MatOfPoint> contours;
	/*
	 * Random value - colors
	 */
	private Random rng = new Random(12345);
	
	@Override
	public boolean validate(OpenCVOperator previous) {
		if (previous == null || previous.getClass() != FindContours.class) {
            return false;
        }else if(previous.getClass() == FindContours.class) {
			contours = FindContours.getContours();
		}
        return allowedOperators().contains(previous.getClass());
	}

	@Override
	public Mat compute(Mat image) {
		return imageMoments(image,getContoursList());
	}

	private Mat imageMoments(Mat cannyOutput, ArrayList<MatOfPoint> contours) {
		// TODO Auto-generated method stub
		/**
		 * Save all image Moments
		 */
		ArrayList<Moments> mu = new ArrayList<>(contours.size());
        for (int i = 0; i < contours.size(); i++) {
            mu.add(Imgproc.moments(contours.get(i)));
        }
        /**
         * List of Contour Points
         */
        ArrayList<Point> mc = new ArrayList<>(contours.size());
        for (int i = 0; i < contours.size(); i++) {
            //add 1e-5 to avoid division by zero
            mc.add(new Point(mu.get(i).m10 / (mu.get(i).m00 + 1e-5), mu.get(i).m01 / (mu.get(i).m00 + 1e-5)));
        }
        /**
         * Assign CannyOutput for the drawing Mat Object
         */
        Mat drawing = Mat.zeros(cannyOutput.size(), CvType.CV_8UC3);
        for (int i = 0; i < contours.size(); i++) {
            Scalar color = new Scalar(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
            Imgproc.drawContours(drawing, contours, i, color, 2);
            Imgproc.circle(drawing, mc.get(i), 4, color, -1);
        }
        
        System.out.println("\t Info: Area and Contour Length \n");
        for (int i = 0; i < contours.size(); i++) {
            System.out.format(" * Contour[%d] - Area (M_00) = %.2f - Area OpenCV: %.2f - Length: %.2f\n", i,
                    mu.get(i).m00, Imgproc.contourArea(contours.get(i)),
                    Imgproc.arcLength(new MatOfPoint2f(contours.get(i).toArray()), true));
        }
        
		return drawing;
	}

	@Override
	public Set<Class<?>> allowedOperators() {
		Set<Class<?>> allowed = new HashSet<>();
		allowed.add(ReadImage.class);
        allowed.add(WriteImage.class);
        allowed.add(FindContours.class);
        return allowed;
	}
	
	public ArrayList<MatOfPoint>  getContoursList() {
		return this.contours;
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
                return "Image Moments\n\n In Image processing, computer vision and related fields, "
                		+ "an image moment is a certain particular weighted average of the image pixels' intensities, "
                		+ "or a function of such moments, usually chosen to have some attractive property or interpreation."
                		+ "Image moments are useful to describe objects after segmentation.";
            }
        }
    }

}

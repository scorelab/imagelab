package com.imagelab.operator.imagecontours;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;

public class ConvexHull extends OpenCVOperator{

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
		// TODO Auto-generated method stub
		if (previous == null || previous.getClass() != FindContours.class) {
            return false;
        }else if(previous.getClass() == FindContours.class) {
			contours = FindContours.getContours();
		}
        return allowedOperators().contains(previous.getClass());
	}

	@Override
	public Mat compute(Mat image) {
		System.out.println("Applied the convex Hull");
		return convexHull(image,getContoursList());
	}

	private Mat convexHull(Mat cannyOutput, ArrayList<MatOfPoint> contours) {
		// Define the empty Matrix for convexHull
		Mat drawing = Mat.zeros(cannyOutput.size(), CvType.CV_8UC3);
		/**
		 * Define the points for convex Hull using a ArrayList
		 */
		ArrayList<MatOfPoint> hullList = new ArrayList<>();
        
		/**
		 * Save the points  from contours
		 */
		for (MatOfPoint contour : contours) {
            MatOfInt hull = new MatOfInt();
            /**
             * Apply ConvexHull Operation for identify the boundaries
             */
            Imgproc.convexHull(contour, hull);
            
            Point[] contourArray = contour.toArray();
            Point[] hullPoints = new Point[hull.rows()];
            List<Integer> hullContourIdxList = hull.toList();
            
            for (int i = 0; i < hullContourIdxList.size(); i++) {
                hullPoints[i] = contourArray[hullContourIdxList.get(i)];
            }
            hullList.add(new MatOfPoint(hullPoints));
        }
        
        for (int i = 0; i < contours.size(); i++) {
            Scalar color = new Scalar(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
            Imgproc.drawContours(drawing, contours, i, color);
            Imgproc.drawContours(drawing, hullList, i, color );
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
                return "Convex Hull \n\n "
                		+ "It is a binary image with set of pixels included in the smallest convex ploygon"
                		+ " that surrounded all white pixels in the input. "
                		+ "We can use convexHull() function OpenCV improve class in order to operate this action.";
            }
        }
    }

}

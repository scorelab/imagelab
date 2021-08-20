package com.imagelab.operator.histogram;


import static org.opencv.imgcodecs.Imgcodecs.imread;

import java.util.HashSet;
import java.util.Set;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;

public class TemplateMatching extends OpenCVOperator {

	/**
	 * Default template for the image
	 */
    private String ImageURL = "src/main/resources/com/imagelab/"
            + "images/templateScorelab.jpg";

    /**
     * Match Method
     */
    private int match_method = 1;
    /**
     * This method validates the possible
     * operations before the readImage
     * operation. Here this returns true
     * since there are no previous elements
     * to this element.
     *
     * @param previous - previous elements acceptable for the Read Image.
     * @return - true
     */
    @Override
    public boolean validate(OpenCVOperator previous) {
    	if (previous == null) {
            return false;
        }
        return allowedOperators().contains(previous.getClass());
    }

    /**
     * This method accepts a Mat object processed
     * from previous steps and point
     * it to the openCV logic related to this element.
     * This method is responsible for
     * executing the openCV logic.
     *
     * @param image - accepts a null Mat object to initiate the process.
     * @return - readImage() - Mat object read from the given resource file.
     */
    @Override
    public Mat compute(Mat image) {
        System.out.println("Template Image URL: " + getImageURL());
        return matchTemplate(image,getMatchingMethodType());
    }

    /**
     * This method contains the allowed previous elements related to
     * this openCV operation.
     *
     * @return - allowed operation set.
     */
    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        return allowed;
    }

    /**
     * OpenCV logic related to readImage.
     *
     * @return - read image file as a mat object.
     */
    public Mat matchTemplate(Mat source, int match_method) {
    	Mat result = new Mat();
    	Mat img_display = new Mat();
    	Mat mask = new Mat();
        source.copyTo(img_display);
        Mat template = imread(getImageURL());
    
        int result_cols = source.cols() - template.cols() + 1;
        int result_rows = source.rows() - template.rows() + 1;
        result.create(result_rows, result_cols, CvType.CV_32FC1);
        
        switch(match_method) {
		case 1 : Imgproc.matchTemplate(source, template, result, Imgproc.TM_SQDIFF,mask);;break;
		case 2 : Imgproc.matchTemplate(source, template, result, Imgproc.TM_SQDIFF_NORMED,mask);break;
		case 3 : Imgproc.matchTemplate(source, template, result, Imgproc.TM_CCORR);break;
		case 4 : Imgproc.matchTemplate(source, template, result, Imgproc.TM_CCORR_NORMED);break;
		case 5 : Imgproc.matchTemplate(source, template, result, Imgproc.TM_CCOEFF);break;
		case 6 : Imgproc.matchTemplate(source, template, result, Imgproc.TM_CCOEFF_NORMED);break;
		}
        
        Core.normalize(result, result, 0, 1, Core.NORM_MINMAX, -1, new Mat());
        
        Point matchLoc;
        
        Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
        
        if (match_method == 1 || match_method == 2) {
            matchLoc = mmr.minLoc;
        } else {
            matchLoc = mmr.maxLoc;
        }
        // Draw the matching areas
        Imgproc.rectangle(img_display, matchLoc, new Point(matchLoc.x + template.cols(), matchLoc.y + template.rows()),
                new Scalar(0, 0, 255), 2, 8, 0);
        Imgproc.rectangle(result, matchLoc, new Point(matchLoc.x + template.cols(), matchLoc.y + template.rows()),
                new Scalar(0, 0, 255), 2, 8, 0);

        return img_display;
    }

    /**
     * To get the image URL to be read.
     *
     * @return - imageURL to proceed with the logic.
     */
    public String getImageURL() {
        return ImageURL;
    }

    /**
     * To set the image URL to be read using openCV.
     *
     * @param imageURL - the image URL to be read.
     */
    public void setImageURL(String imageURL) {
        this.ImageURL = imageURL;
    }
    /**
     * 
     * @return matching type
     */
    public int getMatchingMethodType() {
		return match_method;
	}
	/**
     * To set the dilation iteration of the output image.
     *
     * @return - output depth.
     */ 
	public void setMatchingMethodType(int type) {
		this.match_method = type;
	}
	public enum Information {
        /**
         * Operator information in string format.
         */
        OPERATOR_INFO {
            /**
             * @return - Operator information and name of the operator.
             */
            public String toString() {
                return "Template Matching\n\nThis operator helps you to"
                        + " read an template image and search the matches it in the source image using siding. OpenCV supports 6 types of matching methods"
                        + " for search template in the source image";
            }
        }
    }

}

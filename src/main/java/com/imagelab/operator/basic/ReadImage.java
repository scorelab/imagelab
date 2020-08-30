package com.imagelab.operator.basic;

import com.imagelab.operator.OpenCVOperator;
import org.opencv.core.Mat;

import java.util.HashSet;
import java.util.Set;

import static org.opencv.imgcodecs.Imgcodecs.imread;

/**
 * Operator class which contains the logic related to the
 * ReadImage UI element.
 */
public class ReadImage extends OpenCVOperator {
    //Default URL to load an image resource.
    private String ImageURL = "src/main/resources/com/imagelab/"
            + "images/scorelabLogo.jpg";

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
        return true;
        // return allowedOperators().contains(previous.getClass());
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
        System.out.println("Image URL: " + getImageURL());
        return readImage();
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
    public Mat readImage() {
        return imread(getImageURL());
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
     * Information related to the RotateImage operation.
     */
    public enum Information {
        /**
         * Operator information in string format.
         */
        OPERATOR_INFO {
            /**
             * @return - Operator information and name of the operator.
             */
            public String toString() {
                return "Read Image\n\nThis operator helps you to"
                        + " read an image file and convert it"
                        + " to an OpenCV Mat object.";
            }
        }
    }
}

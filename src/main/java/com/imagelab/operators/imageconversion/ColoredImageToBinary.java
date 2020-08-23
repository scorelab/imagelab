package com.imagelab.operators.imageconversion;

import com.imagelab.operators.OpenCVOperator;
import com.imagelab.operators.basic.ReadImage;
import com.imagelab.operators.basic.WriteImage;
import com.imagelab.operators.geotransformation.RotateImage;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

public class ColoredImageToBinary extends OpenCVOperator {

    public enum Information {
        OPERATOR_INFO {
            /**
             * @return - Operator information and name of the operator.
             */
            public String toString() {
                return "Color Image to Binary\n\nThis operations allows you to convert your" +
                        " colored (RGB) images into a binary image. Moreover, you can adjust the" +
                        "conversion threshold values and the threshold values as well.";
            }
        }
    }

    private double thresholdValue;
    private double maxValue;
    private String thresholdType;

    /**
     * This method contains the logic which validates the applicable
     * openCV operations for a particular openCV operator.
     *
     * @param previous - accepts the previous operator to validate.
     * @return - whether the received operator is valid or not.
     */
    @Override
    public boolean validate(OpenCVOperator previous) {
        if (previous == null) {
            return false;
        }
        return allowedOperators().contains(previous.getClass());
    }

    /**
     * This method contains the openCV operator related specific logic.
     *
     * @param image - accepts the mat object processed from the previous steps.
     * @return - processed computed Mat obj.
     */
    @Override
    public Mat compute(Mat image) {
        return convertColorToBinary(image, getThresholdValue(), getMaxValue(), getThresholdType());
    }

    /**
     * This method contains the applicable openCV operators for the selected
     * openCV operator.
     *
     * @return - applicable operators.
     */
    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        allowed.add(RotateImage.class);
        allowed.add(WriteImage.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(GrayscaleToBinary.class);
        allowed.add(ColoredImageToBinary.class);
        return allowed;
    }

    /**
     * This method converts a given mat rgb image to binary image.
     *
     * @param imageFile     - mat RGB image.
     * @param threshVal     - conversion threshold value.
     * @param maxValue      - conversion threshold maxValue.
     * @param thresholdType - THRESH_BINARY or THRESH_BINARY_INV
     * @return - image (binary mat image).
     */
    private Mat convertColorToBinary(Mat imageFile, Double threshVal, Double maxValue, String thresholdType) {
        Mat image = new Mat(); //Creating the empty destination matrix.

        // Converting to binary image.
        switch (thresholdType) {
            case "THRESH_BINARY":
                Imgproc.threshold(imageFile, image, threshVal, maxValue, Imgproc.THRESH_BINARY);
                System.out.println("Selected Thresh Type: THRESH_BINARY");
                break;
            case "THRESH_BINARY_INV":
                Imgproc.threshold(imageFile, image, threshVal, maxValue, Imgproc.THRESH_BINARY_INV);
                System.out.println("Selected Thresh Type: THRESH_BINARY_INV");
            default:
                Imgproc.threshold(imageFile, image, threshVal, maxValue, Imgproc.THRESH_BINARY);
        }

        // Extracting data from the transformed image (dst).
        byte[] data1 = new byte[image.rows() * image.cols() * (int) (image.elemSize())];
        image.get(0, 0, data1);
        return image;
    }

    //Getters and setters
    public double getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(double thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public String getThresholdType() {
        return thresholdType;
    }

    public void setThresholdType(String thresholdType) {
        this.thresholdType = thresholdType;
    }
}

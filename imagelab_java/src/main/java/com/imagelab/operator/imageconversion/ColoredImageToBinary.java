package com.imagelab.operator.imageconversion;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.geotransformation.ColorMaps;
import com.imagelab.operator.geotransformation.ImageAffine;
import com.imagelab.operator.geotransformation.ImageReflection;
import com.imagelab.operator.geotransformation.RotateImage;
import com.imagelab.operator.geotransformation.ScaleImage;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

/**
 * Operator class which contains the logic related to the
 * converting a RGB image to binary UI element.
 */
public class ColoredImageToBinary extends OpenCVOperator {
    /**
     * Properties related to the
     * colored image to binary conversion.
     */
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
        return convertColorToBinary(image,
                getThresholdValue(),
                getMaxValue(),
                getThresholdType());
    }

    /**
     * This method contains the applicable openCV operator for the selected
     * openCV operator.
     *
     * @return - applicable operator.
     */
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
    private Mat convertColorToBinary(Mat imageFile,
                                     Double threshVal, Double maxValue,
                                     String thresholdType) {
        Mat image = new Mat(); //Creating the empty destination matrix.
        // Converting to binary image.
        switch (thresholdType) {
            case "THRESH_BINARY":
                Imgproc.threshold(imageFile,
                        image, threshVal, maxValue,
                        Imgproc.THRESH_BINARY);
                System.out.println("Selected Thresh Type: THRESH_BINARY");
                break;
            case "THRESH_BINARY_INV":
                Imgproc.threshold(imageFile, image,
                        threshVal, maxValue,
                        Imgproc.THRESH_BINARY_INV);
                System.out.println("Selected Thresh Type: THRESH_BINARY_INV");
            default:
                Imgproc.threshold(imageFile, image,
                        threshVal, maxValue,
                        Imgproc.THRESH_BINARY);
        }

        // Extracting data from the transformed image (dst).
        byte[] byteData = new byte[image.rows()
                * image.cols()
                * (int) (image.elemSize())];
        image.get(0, 0, byteData);
        return image;
    }

    /**
     * To get threshold value related
     * to the conversion.
     *
     * @return - thresholdValue.
     */
    public double getThresholdValue() {
        return thresholdValue;
    }

    /**
     * To set threshold value related
     * to the conversion.
     *
     * @param thresholdValue - double.
     */
    public void setThresholdValue(double thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    /**
     * To get the max value related
     * to the conversion.
     *
     * @return - maxValue.
     */
    public double getMaxValue() {
        return maxValue;
    }

    /**
     * To set the max value related
     * to the conversion.
     *
     * @param maxValue - double.
     */
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * To get the threshold type related
     * to the conversion.
     *
     * @return thresholdType.
     */
    public String getThresholdType() {
        return thresholdType;
    }

    /**
     * To set the threshold type related
     * to the conversion.
     *
     * @param thresholdType - double.
     */
    public void setThresholdType(String thresholdType) {
        this.thresholdType = thresholdType;
    }

    /**
     * Information related to the ColoredImageToBinary operator.
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
                return "Color Image to Binary\n\nThis operations allows"
                        + " you to convert your colored (RGB) images into "
                        + "a binary image. Moreover, you can adjust the"
                        + "conversion threshold values and the threshold"
                        + " type as well.";
            }
        }
    }
}

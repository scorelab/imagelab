package com.imagelab.operator.imageconversion;

import com.imagelab.operator.OpenCVOperator;
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
 * image conversion from a grayscale image to a binary.
 */
public class GrayscaleToBinary extends OpenCVOperator {
    private double thresholdValue;
    private double maxValue;

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
        return convertGrayscaleToBinary(image,
                getThresholdValue(),
                getMaxValue());
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
        allowed.add(RotateImage.class);
        allowed.add(ColorMaps.class);
        allowed.add(ScaleImage.class);
        allowed.add(ImageAffine.class);
        allowed.add(ImageReflection.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(GrayscaleToBinary.class);
        return allowed;
    }

    /**
     * This method contains the operation logic related
     * to the openCV grayscale to binary image conversion.
     *
     * @param imageFile - Mat source image.
     * @param threshVal - threshold value.
     * @param maxValue  - double max value.
     * @return - converted binary image.
     */
    private Mat convertGrayscaleToBinary(Mat imageFile,
                                         Double threshVal, Double maxValue) {
        Mat image = new Mat(); //Creating the empty destination matrix.
        // Converting to binary image...
        Imgproc.threshold(imageFile, image, 200, 500, Imgproc.THRESH_BINARY);
        // Extracting data from the transformed image (dst)
        byte[] data1 = new byte[image.rows()
                * image.cols() * (int) (image.elemSize())];
        image.get(0, 0, data1);
        return image;
    }

    /**
     * To get the threshold value related
     * to the conversion.
     *
     * @return thresholdValue.
     */
    public double getThresholdValue() {
        return thresholdValue;
    }

    /**
     * To set the threshold value related
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
     * @return maxValue.
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
     * Information related to the GrayscaleToBinary operator.
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
                return "Grayscale Image to Binary\n\nThis operations"
                        + " allows you to convert your grayscale image"
                        + " into a binary image. Moreover, you can adjust"
                        + " the conversion threshold values as well.";
            }
        }
    }
}

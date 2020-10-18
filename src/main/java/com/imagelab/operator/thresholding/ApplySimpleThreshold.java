package com.imagelab.operator.thresholding;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.filtering.ApplyBoxFilter;
import com.imagelab.operator.geotransformation.RotateImage;
import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import com.imagelab.operator.imagebluring.ApplyGaussianBlurEffect;
import com.imagelab.operator.imagebluring.ApplyMedianBlurEffect;
import com.imagelab.operator.imageconversion.ColoredImageToBinary;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

/**
 * Operator class which contains the logic related to the
 * apply threshold effects to an image  UI element.
 */
public class ApplySimpleThreshold extends OpenCVOperator {
    /**
     * threshold value of fro the processing.
     */
    private double thresholdValue = 50d;
    /**
     * max value related to the threshold operation.
     */
    private double maxValue = 255d;

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
        return applySimpleThreshold(
                image,
                getThresholdValue(),
                getMaxValue()
        );
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
        allowed.add(RotateImage.class);
        allowed.add(WriteImage.class);
        allowed.add(ColoredImageToBinary.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(ApplyBlurEffect.class);
        allowed.add(ApplyGaussianBlurEffect.class);
        allowed.add(ApplyMedianBlurEffect.class);
        allowed.add(ApplyBoxFilter.class);
        allowed.add(ApplySimpleThreshold.class);
        return allowed;
    }

    /**
     * This method contains applying simple threshold
     * related opencv logic.
     *
     * @param imageFile - source mat image.
     * @param thresh    - threshold value.
     * @param maxVal    - max value.
     * @return - threshold applied image.
     */
    private Mat applySimpleThreshold(Mat imageFile,
                                     double thresh,
                                     double maxVal) {
        // Creating an empty matrix to store the result.
        Mat image = new Mat();

        // Applying simple threshold on the image.
        Imgproc.threshold(
                imageFile, image,
                50,
                255,
                Imgproc.THRESH_BINARY);

        return image;
    }

    /**
     * To get the threshold value.
     *
     * @return - Threshold value.
     */
    public double getThresholdValue() {
        return thresholdValue;
    }

    /**
     * To set the threshold value.
     *
     * @param thresholdValue - threshold value.
     */
    public void setThresholdValue(double thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    /**
     * To get the threshold related max value.
     *
     * @return - maxValue.
     */
    public double getMaxValue() {
        return maxValue;
    }

    /**
     * To set the threshold operation
     * related max value.
     *
     * @param maxValue - maxValue.
     */
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Information related to the
     * ApplySimpleThreshold operator.
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
                return "Simple Threshold Effect\n\nThresholding is a method"
                        + " of image segmentation, in general it is used"
                        + " to create binary images. "
                        + "You can change the threshold value from the properties"
                        + "as well as you can assign a max value.";
            }
        }
    }
}

package com.imagelab.operator.thresholding;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

/**
 * Operator class which contains the logic related to the
 * apply adaptive threshold effects to an
 * image  UI element.
 */
public class ApplyAdaptiveThreshold extends OpenCVOperator {
    /**
     * max value related to the threshold operation.
     */
    private double maxValue = 125d;

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
        return applyAdaptiveThreshold(
                image,
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
        allowed.add(ConvertToGrayscale.class);
        allowed.add(ApplyAdaptiveThreshold.class);
        return allowed;
    }

    /**
     * This method contains applying adaptive threshold
     * related opencv logic.
     *
     * @param imageFile - source mat image.
     * @param maxValue  - max value.
     * @return - threshold applied image.
     */
    private Mat applyAdaptiveThreshold(Mat imageFile,
                                       double maxValue) {
        // Creating an empty matrix to store the result.
        Mat image = new Mat();

        // Applying adaptive threshold on the image.
        Imgproc.adaptiveThreshold(imageFile, image,
                maxValue,
                Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C,
                Imgproc.THRESH_BINARY,
                11, 12);

        return image;
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
     * ApplyAdaptiveThreshold operator.
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
                return "Adaptive Threshold Effect\n\n Adaptive thresholding is the"
                        + " method where the threshold value is calculated for smaller"
                        + " regions and therefore, there will be different threshold"
                        + " values for different regions";
            }
        }
    }
}

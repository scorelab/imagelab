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
import org.opencv.core.Core;
import org.opencv.core.Mat;

import java.util.HashSet;
import java.util.Set;

/**
 * Operator class which contains the logic related to the
 * apply border to an image  UI element.
 */
public class ApplyBorder extends OpenCVOperator {
    /**
     * top border size.
     */
    private int borderTop = 20;
    /**
     * bottom border size.
     */
    private int borderBottom = 20;
    /**
     * left border size.
     */
    private int borderLeft = 20;
    /**
     * right border size.
     */
    private int borderRight = 20;

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
        return applyBorders(
                image,
                getBorderTop(), getBorderBottom(),
                getBorderLeft(), getBorderRight()
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
        allowed.add(ApplyBorder.class);
        return allowed;
    }

    /**
     * This method contains applying borders
     * related opencv logic.
     *
     * @param imageFile - source mat image.
     * @param borderTop - top border size.
     * @param borderBottom - bottom border size.
     * @param borderLeft - left border size.
     * @param borderRight - right border size.
     * @return - border applied image.
     */
    private Mat applyBorders(Mat imageFile,
                             int borderTop, int borderBottom,
                             int borderLeft, int borderRight) {
        // Creating an empty matrix to store the result.
        Mat image = new Mat();

        // Applying borders on the image.
        Core.copyMakeBorder(
                imageFile, image,
                borderTop, borderBottom,
                borderLeft, borderRight,
                Core.BORDER_CONSTANT);

        return image;
    }

    /**
     * To get the top border size.
     *
     * @return - borderTop.
     */
    public int getBorderTop() {
        return borderTop;
    }

    /**
     * To set the top border size.
     *
     * @param borderTop top border size.
     */
    public void setBorderTop(int borderTop) {
        this.borderTop = borderTop;
    }

    /**
     * To get the bottom border size.
     *
     * @return - borderBottom.
     */
    public int getBorderBottom() {
        return borderBottom;
    }

    /**
     * To set the bottom border size.
     *
     * @param borderBottom - bottom border size.
     */
    public void setBorderBottom(int borderBottom) {
        this.borderBottom = borderBottom;
    }

    /**
     * To get the bottom left size.
     *
     * @return - borderLeft.
     */
    public int getBorderLeft() {
        return borderLeft;
    }

    /**
     * To set the left border size.
     *
     * @param borderLeft - left border size.
     */
    public void setBorderLeft(int borderLeft) {
        this.borderLeft = borderLeft;
    }

    /**
     * To get the right border size.
     *
     * @return - borderRight.
     */
    public int getBorderRight() {
        return borderRight;
    }

    /**
     * To set the right border size.
     *
     * @param borderRight - right border size.
     */
    public void setBorderRight(int borderRight) {
        this.borderRight = borderRight;
    }

    /**
     * Information related to the
     * ApplyBorder operator.
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
                return "Apply Borders effect\n\nThis effect adds a border around"
                        + " the given image. You can set the top, bottom, left and"
                        + " right border sizes from the properties.";
            }
        }
    }
}

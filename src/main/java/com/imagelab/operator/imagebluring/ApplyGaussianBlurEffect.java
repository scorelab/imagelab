package com.imagelab.operator.imagebluring;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.geotransformation.ColorMaps;
import com.imagelab.operator.geotransformation.ImageAffine;
import com.imagelab.operator.geotransformation.ImageReflection;
import com.imagelab.operator.geotransformation.RotateImage;
import com.imagelab.operator.geotransformation.ScaleImage;
import com.imagelab.operator.imageconversion.ColoredImageToBinary;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

/**
 * Operator class which contains the logic related to the
 * applying gaussian blur effects to an image  UI element.
 */
public class ApplyGaussianBlurEffect extends OpenCVOperator {
    // properties of gaussian blur effect.
    private double widthSize = 45D;
    private double heightSize = 45D;

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
        return applyGaussianBlurEffect(image, getWidthSize(), getHeightSize());
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
        allowed.add(ColorMaps.class);
        allowed.add(ScaleImage.class);
        allowed.add(ImageAffine.class);
        allowed.add(ImageReflection.class);
        allowed.add(WriteImage.class);
        allowed.add(ColoredImageToBinary.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(ApplyBlurEffect.class);
        allowed.add(ApplyGaussianBlurEffect.class);
        allowed.add(ApplyMedianBlurEffect.class);
        return allowed;
    }

    /**
     * This method contains applying gaussian blur related
     * opencv logic.
     *
     * @param imageFile - source mat image.
     * @param width     - width size.
     * @param height    - height size.
     * @return - gaussian blur applied mat image.
     */
    private Mat applyGaussianBlurEffect(Mat imageFile,
                                        Double width, Double height) {
        // Creating an empty matrix to store the result.
        Mat image = new Mat();
        Size size = new Size(width, height);
        // Applying GaussianBlur on the Image.
        Imgproc.GaussianBlur(imageFile, image, size, 0);
        return image;
    }

    /**
     * To get the width size related
     * to the blur effect.
     *
     * @return widthSize.
     */
    public double getWidthSize() {
        return widthSize;
    }

    /**
     * To set the width size related
     * to the blur effect.
     *
     * @param widthSize - double.
     */
    public void setWidthSize(double widthSize) {
        this.widthSize = widthSize;
    }

    /**
     * To get the height size related
     * to the blur effect.
     *
     * @return heightSize.
     */
    public double getHeightSize() {
        return heightSize;
    }

    /**
     * To set the height size related
     * to the blur effect.
     *
     * @param heightSize - double.
     */
    public void setHeightSize(double heightSize) {
        this.heightSize = heightSize;
    }

    /**
     * Information related to the ApplyGaussianBlurEffect operator.
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
                return "Apply gaussian blur\n\nThis operations allows"
                        + " you to apply gaussian blur effects to your image.";
            }
        }
    }
}

package com.imagelab.operators.imagebluring;

import com.imagelab.operators.OpenCVOperator;
import com.imagelab.operators.basic.ReadImage;
import com.imagelab.operators.basic.WriteImage;
import com.imagelab.operators.geotransformation.RotateImage;
import com.imagelab.operators.imageconversion.ColoredImageToBinary;
import com.imagelab.operators.imageconversion.ConvertToGrayscale;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

/**
 * Operator class which contains the logic related to the
 * applying gaussian blur effects to an image  UI element.
 */
public class ApplyGaussianBlurEffect extends OpenCVOperator {
    public enum Information {
        OPERATOR_INFO {
            /**
             * @return - Operator information and name of the operator.
             */
            public String toString() {
                return "Apply gaussian blur\n\nThis operations allows you to apply" +
                        "gaussian blur effects to your image.";
            }
        }
    }

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
        allowed.add(ColoredImageToBinary.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(ApplyBlurEffect.class);
        allowed.add(ApplyGaussianBlurEffect.class);
        allowed.add(ApplyMedianBlurEffect.class);
        return allowed;
    }

    /**
     * @param imageFile
     * @param width
     * @param height
     * @return
     */
    private Mat applyGaussianBlurEffect(Mat imageFile, Double width, Double height) {
        // Creating an empty matrix to store the result.
        Mat image = new Mat();
        Size size = new Size(width, height);
        // Applying GaussianBlur on the Image.
        Imgproc.GaussianBlur(imageFile, image, size, 0);
        return image;
    }

    // Getters and setter related to the gaussian blur properties.
    public double getWidthSize() {
        return widthSize;
    }

    public void setWidthSize(double widthSize) {
        this.widthSize = widthSize;
    }

    public double getHeightSize() {
        return heightSize;
    }

    public void setHeightSize(double heightSize) {
        this.heightSize = heightSize;
    }
}

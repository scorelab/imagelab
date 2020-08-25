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
 * applying simple blur effects to an image  UI element.
 */
public class ApplyBlurEffect extends OpenCVOperator {
    public enum Information {
        OPERATOR_INFO {
            /**
             * @return - Operator information and name of the operator.
             */
            public String toString() {
                return "Simple Blur Effect\n\nThis operations allows you to apply" +
                        "simple blur effects to your image. You can change size and point" +
                        "properties to change the blur effect";
            }
        }
    }

    // properties of simple blur effect.
    private double widthSize = 45d;
    private double heightSize = 45d;
    private double pointX = 20d;
    private double pointY = 30d;

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
        return applyBlurEffect(
                image,
                getWidthSize(), getHeightSize(),
                getPointX(), getPointY()
        );
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
     * This method contains applying simple blur related
     * opencv logic.
     *
     * @param imageFile - source mat image.
     * @param width     - width size.
     * @param height    - height size.
     * @param X         - point x.
     * @param Y         - point y.
     * @return - simple blur applied mat image.
     */
    private Mat applyBlurEffect(Mat imageFile, double width, double height, double X, double Y) {
        // Creating an empty matrix to store the result.
        Mat image = new Mat();

        // Creating the Size and Point objects.
        Size size = new Size(width, height);
        Point point = new Point(X, Y);

        // Applying Blur effect on the Image.
        Imgproc.blur(imageFile, image, size, point, Core.BORDER_DEFAULT);
        return image;
    }

    // Getter and setter related to the properties.
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

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }
}

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
    /**
     * width of the openCV Size obj.
     */
    private double widthSize = 45d;
    /**
     * height of the openCV Size obj.
     */
    private double heightSize = 45d;
    /**
     * pointX value for the openCV point.
     */
    private double pointX = 20d;
    /**
     * pointY value of the openCV point.
     */
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
     * This method contains applying simple blur related
     * opencv logic.
     *
     * @param imageFile - source mat image.
     * @param width     - width size.
     * @param height    - height size.
     * @param pointX    - point x.
     * @param pointY    - point y.
     * @return - simple blur applied mat image.
     */
    private Mat applyBlurEffect(Mat imageFile,
                                double width, double height,
                                double pointX, double pointY) {
        // Creating an empty matrix to store the result.
        Mat image = new Mat();

        // Creating the Size and Point objects.
        Size size = new Size(width, height);
        Point point = new Point(pointX, pointY);

        // Applying Blur effect on the Image.
        Imgproc.blur(imageFile, image, size, point, Core.BORDER_DEFAULT);
        return image;
    }

    /**
     * To get the width for the OpenCV Size obj.
     *
     * @return widthSize.
     */
    public double getWidthSize() {
        return widthSize;
    }

    /**
     * To set the width for the OpenCV Size obj.
     *
     * @param widthSize - double.
     */
    public void setWidthSize(double widthSize) {
        this.widthSize = widthSize;
    }

    /**
     * To get the height for the OpenCV Size obj.
     *
     * @return heightSize.
     */
    public double getHeightSize() {
        return heightSize;
    }

    /**
     * To set the height for the OpenCV Size obj.
     *
     * @param heightSize - double.
     */
    public void setHeightSize(double heightSize) {
        this.heightSize = heightSize;
    }

    /**
     * To get the point X for the OpenCV Point obj.
     *
     * @return pointX.
     */
    public double getPointX() {
        return pointX;
    }

    /**
     * To ser the point X for the OpenCV Point obj.
     *
     * @param pointX - double.
     */
    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    /**
     * To get the point Y for the OpenCV Point obj.
     *
     * @return pointY.
     */
    public double getPointY() {
        return pointY;
    }

    /**
     * To ser the point Y for the OpenCV Point obj.
     *
     * @param pointY - double.
     */
    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * Information related to the ApplyBlurEffect operator.
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
                return "Simple Blur Effect\n\nThis operations allows"
                        + " you to apply simple blur effects to your image."
                        + " You can change size and point properties to"
                        + " change the blur effect";
            }
        }
    }
}

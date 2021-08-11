package com.imagelab.operator.filtering;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.geotransformation.ColorMaps;
import com.imagelab.operator.geotransformation.ImageAffine;
import com.imagelab.operator.geotransformation.ImageReflection;
import com.imagelab.operator.geotransformation.RotateImage;
import com.imagelab.operator.geotransformation.ScaleImage;
import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import com.imagelab.operator.imagebluring.ApplyGaussianBlurEffect;
import com.imagelab.operator.imagebluring.ApplyMedianBlurEffect;
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
 * ApplyBoxFilter operator class which contains
 * adding a box filter to an image related
 * functionalities.
 */
public class ApplyBoxFilter extends OpenCVOperator {
    /**
     * depth of the output image.
     */
    private int depth = 50;
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
    private double pointX = -1d;
    /**
     * pointY value of the openCV point.
     */
    private double pointY = -1d;

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
        return applyBoxFilter(
                image,
                getDepth(),
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
        allowed.add(WriteImage.class);
        allowed.add(ImageReflection.class);
        allowed.add(RotateImage.class);
        allowed.add(ColorMaps.class);
        allowed.add(ImageAffine.class);
        allowed.add(ScaleImage.class);
        allowed.add(ColoredImageToBinary.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(ApplyBlurEffect.class);
        allowed.add(ApplyGaussianBlurEffect.class);
        allowed.add(ApplyMedianBlurEffect.class);
        allowed.add(ApplyBoxFilter.class);
        allowed.add(ApplyBilateralFilter.class);
        allowed.add(ApplyImagePyramidDown.class);
        allowed.add(ApplyImagePyramid.class);
        allowed.add(ApplyDilation.class);
        allowed.add(ApplyFilter2D.class);
        allowed.add(ApplySQRBoxFilter.class);
        allowed.add(ApplyMorphological.class);
        return allowed;
    }

    /**
     * This method contains applying box filter related
     * opencv logic.
     *
     * @param imageFile - source mat image.
     * @param depth     - depth of the output image
     * @param width     - width size.
     * @param height    - height size.
     * @param pointX    - point x.
     * @param pointY    - point y.
     * @return - box filter applied mat image.
     */
    private Mat applyBoxFilter(Mat imageFile,
                               int depth,
                               double width, double height,
                               double pointX, double pointY) {
        // Creating an empty matrix to store the result
        Mat image = new Mat();
        
        // Creating the objects for Size and Point
        Size size = new Size(width, height);
        Point point = new Point(pointX, pointY);

        // Applying Box Filter effect on the Image
        Imgproc.boxFilter(imageFile,
                image,
                depth,
                size, point,
                true, Core.BORDER_DEFAULT);

        return image;
    }

    /**
     * To get the depth of the output image.
     *
     * @return - output depth.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * To set the depth of the output image.
     *
     * @param depth - output depth.
     */
    public void setDepth(int depth) {
        this.depth = depth;
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
     * Information related to the ApplyBoxFilter operator.
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
                return "Box Filter\n\nThis operations allows"
                        + " you to apply simple box filter effects to your image."
                        + " You can change size and point properties to"
                        + " change the blur effect";
            }
        }
    }
}

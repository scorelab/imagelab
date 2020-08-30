package com.imagelab.operator.geotransformation;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.imageconversion.ConvertToGrayscale;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

/**
 * Rotate image operator class which contains
 * rotating an image related functionalities.
 */
public class RotateImage extends OpenCVOperator {
    /**
     * Information related to the RotateImage operator.
     */
    public enum Information {
        /**
         * Operator information in string format.
         */
        OPERATOR_INFO {
            /**
             * @return - Operator information and name
             * of the operator.
             */
            public String toString() {
                return "Rotate Image\n\nThis operator allows you to"
                        + " rotate an image to a specific angle."
                        + " Moreover you can change angle and scale"
                        + " related to the rotation.";
            }
        }
    }

    private double angle; // Rotation angle.
    private double scale; // Rotation scale.

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
        System.out.println("Image Rotated");
        return rotateImage(image);
    }

    /**
     * This contains the allowed previous operator
     * to the rotate image operation.
     *
     * @return - allowed operator set.
     */
    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        allowed.add(RotateImage.class);
        allowed.add(WriteImage.class);
        allowed.add(ConvertToGrayscale.class);
        return allowed;
    }

    /**
     * This method contains the image rotation logic.
     *
     * @param imageFile - Mat source image.
     * @return - rotated/processed image.
     */
    private Mat rotateImage(Mat imageFile) {
        // Creating an empty matrix to store the result.
        Mat image = new Mat();
        // Creating a Point object.
        final double pointX = 300.0; // X value point.
        final double pointY = 200.0; // Y value point.
        Point point = new Point(pointX, pointY);
        // Creating the transformation matrix M.
        //rotationAngle - 90, scale - 1.
        Mat rotationMatrix = Imgproc.getRotationMatrix2D(
                point,
                getAngle(),
                getScale());
        // Creating the object of the class Size.
        Size size = new Size(imageFile.cols(), imageFile.cols());
        // Rotating the given image.
        Imgproc.warpAffine(imageFile, image, rotationMatrix, size);
        //Rotated Image.
        return image;
    }

    /**
     * To get the angle.
     *
     * @return angle.
     */
    public double getAngle() {
        return angle;
    }

    /**
     * To set the angle.
     *
     * @param angle - double.
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * To get the scale value.
     *
     * @return - scale.
     */
    public double getScale() {
        return scale;
    }

    /**
     * To set the scale value.
     *
     * @param scale - double.
     */
    public void setScale(double scale) {
        this.scale = scale;
    }
}

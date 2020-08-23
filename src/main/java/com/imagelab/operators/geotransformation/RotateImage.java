package com.imagelab.operators.geotransformation;

import com.imagelab.operators.OpenCVOperator;
import com.imagelab.operators.basic.ReadImage;
import com.imagelab.operators.basic.WriteImage;
import com.imagelab.operators.imageconversion.ConvertToGrayscale;
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
    public enum Information {
        OPERATOR_INFO {
            /**
             * @return - Operator information and name of the operator.
             */
            public String toString() {
                return "Rotate Image\n\nThis operator allows you to rotate an image to a specific angle." +
                        " Moreover you can change angle and scale related to the rotation.";
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
        return rotateImage(image, getAngle(), getScale());
    }

    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        allowed.add(RotateImage.class);
        allowed.add(WriteImage.class);
        allowed.add(ConvertToGrayscale.class);
        return allowed;
    }

    private Mat rotateImage(Mat imageFile, double rotationAngle, double scale) {
        // Creating an empty matrix to store the result.
        Mat image = new Mat();

        // Creating a Point object.
        Point point = new Point(300, 200);

        // Creating the transformation matrix M.
        //rotationAngle - 90, scale - 1.
        Mat rotationMatrix = Imgproc.getRotationMatrix2D(point, rotationAngle, scale);

        // Creating the object of the class Size.
        Size size = new Size(imageFile.cols(), imageFile.cols());

        // Rotating the given image.
        Imgproc.warpAffine(imageFile, image, rotationMatrix, size);

        //Rotated Image.
        return image;
    }

    //Getters and setters.
    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}

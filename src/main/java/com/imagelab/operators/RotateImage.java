package com.imagelab.operators;

import lombok.Getter;
import lombok.Setter;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;

public class RotateImage extends OpenCVOperator {

    private double angle;
    private double scale;

    @Override
    public boolean validate(OpenCVOperator previous) {
        if (previous == null) {
            return false;
        }
        return allowedOperators().contains(previous.getClass());
    }

    @Override
    public Mat compute(Mat mat) {
        System.out.println("Image Rotated");
        return rotateImage(mat, getAngle(), getScale());
    }

    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        allowed.add(RotateImage.class);
        allowed.add(WriteImage.class);
        return allowed;
    }

    private Mat rotateImage(Mat imageFile, double rotationAngle, double scale) {
        // Creating an empty matrix to store the result
        Mat image = new Mat();

        // Creating a Point object
        Point point = new Point(300, 200);

        // Creating the transformation matrix M
        //rotationAngle - 90, scale - 1
        Mat rotationMatrix = Imgproc.getRotationMatrix2D(point, rotationAngle, scale);

        // Creating the object of the class Size
        Size size = new Size(imageFile.cols(), imageFile.cols());

        // Rotating the given image
        Imgproc.warpAffine(imageFile, image, rotationMatrix, size);

        //Rotated Image
        return image;
    }

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

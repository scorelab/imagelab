package com.imagelab.operators.imageconversion;

import com.imagelab.operators.OpenCVOperator;
import com.imagelab.operators.basic.ReadImage;
import com.imagelab.operators.basic.WriteImage;
import com.imagelab.operators.geotransformation.RotateImage;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

/**
 * Operator class which contains the logic related to the
 * image conversion from a grayscale image to a binary.
 */
public class GrayscaleToBinary extends OpenCVOperator {

    public enum Information {
        OPERATOR_INFO {
            /**
             * @return - Operator information and name of the operator.
             */
            public String toString() {
                return "Convert Grayscale\n\nThis operations allows you to convert your image into a gray image.";
            }
        }
    }

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
        return convertGrayscaleToBinary(image);
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
        allowed.add(ConvertToGrayscale.class);
        allowed.add(GrayscaleToBinary.class);
        return allowed;
    }

    private Mat convertGrayscaleToBinary(Mat imageFile) {
        Mat image = new Mat(); //Creating the empty destination matrix.

        // Converting to binary image...
        Imgproc.threshold(imageFile, image, 200, 500, Imgproc.THRESH_BINARY);

        // Extracting data from the transformed image (dst)
        byte[] data1 = new byte[image.rows() * image.cols() * (int) (image.elemSize())];
        image.get(0, 0, data1);
        return image;
    }
}

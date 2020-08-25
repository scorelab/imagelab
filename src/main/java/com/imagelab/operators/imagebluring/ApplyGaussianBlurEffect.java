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
        return applyGaussianBlurEffect(image);
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

    private Mat applyGaussianBlurEffect(Mat imageFile) {
        // Creating an empty matrix to store the result
        Mat image = new Mat();
        Size size = new Size(45, 45);
        // Applying GaussianBlur on the Image
        Imgproc.GaussianBlur(imageFile, image, size, 0);
        return image;
    }
}

package com.imagelab.operators.imagebluring;

import com.imagelab.App;
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
                return "Apply simple blur\n\nThis operations allows you to apply" +
                        "blur effects to your image.";
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
        return applyBlurEffect(image);
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

    private Mat applyBlurEffect(Mat imageFile) {
        // Creating an empty matrix to store the result
        Mat image = new Mat();

        // Creating the Size and Point objects
        Size size = new Size(45, 45);
        Point point = new Point(20, 30);

        // Applying Blur effect on the Image
        Imgproc.blur(imageFile, image, size, point, Core.BORDER_DEFAULT);
        return image;
    }
}

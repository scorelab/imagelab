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
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.util.HashSet;
import java.util.Set;

/**
 * Operator class which contains the logic related to the
 * applying median blur effects to an image  UI element.
 */
public class ApplyMedianBlurEffect extends OpenCVOperator {
    // properties of median blur effect.
    private int kernelSize = 15;

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
        return applyMedianBlurEffect(image, getKernelSize());
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
     * This method contains applying median blur related
     * opencv logic.
     *
     * @param imageFile  - source file.
     * @param kernelSize - size of the kernel. Should be int odd value.
     * @return - median blur applied mat obj.
     */
    private Mat applyMedianBlurEffect(Mat imageFile, int kernelSize) {
        // Creating an empty matrix to store the result.
        Mat image = new Mat();

        // Applying MedianBlur on the Image.
        Imgproc.medianBlur(imageFile, image, kernelSize);
        return image;
    }

    /**
     * To get the kernel size related
     * to the blur effect.
     *
     * @return kernelSize.
     */
    public int getKernelSize() {
        return kernelSize;
    }

    /***
     * To set the kernel size related
     * to the blur effect.
     * @param kernelSize - int.
     */
    public void setKernelSize(int kernelSize) {
        this.kernelSize = kernelSize;
    }

    /**
     * Information related to the ApplyMedianBlurEffect operator.
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
                return "Apply median blur\n\nThis operations allows"
                        + " you to apply median blur effects to your image."
                        + " Moreover, you can change kernel value from"
                        + " the properties.";
            }
        }
    }
}

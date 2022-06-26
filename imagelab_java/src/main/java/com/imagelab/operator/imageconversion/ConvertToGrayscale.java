package com.imagelab.operator.imageconversion;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.geotransformation.ColorMaps;
import com.imagelab.operator.geotransformation.ImageAffine;
import com.imagelab.operator.geotransformation.ImageReflection;
import com.imagelab.operator.geotransformation.RotateImage;
import com.imagelab.operator.geotransformation.ScaleImage;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

/**
 * Operator class which contains the logic related to the
 * ConvertToGrayscale UI element.
 */
public class ConvertToGrayscale extends OpenCVOperator {
    /**
     * This method validates the acceptable operations before perform
     * this operation.
     *
     * @param previous - previous elements acceptable
     *                 for the grayScale operation.
     * @return - true/false.
     */
    @Override
    public boolean validate(OpenCVOperator previous) {
        if (previous == null) {
            return false;
        }
        return allowedOperators().contains(previous.getClass());
    }

    /**
     * This method execute the openCV logic related to this operator.
     *
     * @param image - Mat object need to be processed.
     * @return - gray scaled image in mat format.
     */
    @Override
    public Mat compute(Mat image) {
        System.out.println("Performed - Convert to Grayscale");
        return convertToGrayScale(image);
    }

    /**
     * This method contains the allowed previous elements related to
     * this openCV operation.
     *
     * @return - allowed operation set.
     */
    @Override
    public Set<Class<?>> allowedOperators() {
        Set<Class<?>> allowed = new HashSet<>();
        allowed.add(ReadImage.class);
        allowed.add(WriteImage.class);
        allowed.add(ConvertToGrayscale.class);
        allowed.add(RotateImage.class);
        allowed.add(ColorMaps.class);
        allowed.add(ScaleImage.class);
        allowed.add(ImageAffine.class);
        allowed.add(ImageReflection.class);
        return allowed;
    }

    /**
     * This method contains the openCV logic to convert an image to a grays.
     *
     * @param imageFile - Mat image that needs to be converted to gray.
     * @return - gray scaled Mat object.
     */
    private Mat convertToGrayScale(Mat imageFile) {
        Mat image = new Mat(); //Creating the empty destination matrix.

        //Converting the image to grayscale and saving it in the dst matrix.
        Imgproc.cvtColor(imageFile, image, Imgproc.COLOR_RGB2GRAY);

        //Extracting data from the transformed image (dst).
        byte[] data1 = new byte[image.rows()
                * image.cols()
                * (int) (image.elemSize())];
        image.get(0, 0, data1);

        //Creating Buffered image using the data.
        BufferedImage bufImage = new BufferedImage(image.cols(), image.rows(),
                BufferedImage.TYPE_BYTE_GRAY);

        //Setting the data elements to the image.
        bufImage.getRaster().setDataElements(0, 0,
                image.cols(),
                image.rows(),
                data1);
        return image;
    }

    /**
     * Information related to the ConvertToGrayscale operator.
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
                return "Convert Grayscale\n\nThis operations allows"
                        + " you to convert your image into a gray image.";
            }
        }
    }
}

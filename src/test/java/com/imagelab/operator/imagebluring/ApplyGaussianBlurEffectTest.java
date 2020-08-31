package com.imagelab.operator.imagebluring;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.ReadImage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.opencv.core.Mat;

import java.util.Set;

/**
 * ApplyGaussianBlurEffectTest class related tests.
 */
class ApplyGaussianBlurEffectTest {
    /**
     * To test whether validate method
     * returns true if it receives an allowed operator
     * and false for not allowed operators.
     */
    @Test
    void validate() {
        ApplyGaussianBlurEffect applyGaussianBlurEffect = new ApplyGaussianBlurEffect();
        OpenCVOperator readImage, testOperator;
        readImage = new ReadImage();
        testOperator = new TestOperator();
        //Test for allowed operators
        Assert.assertTrue(applyGaussianBlurEffect.validate(readImage));
        Assert.assertFalse(applyGaussianBlurEffect.validate(testOperator));
    }

    /**
     * Mock class.
     */
    static class TestOperator extends OpenCVOperator {
        @Override
        public boolean validate(OpenCVOperator previous) {
            return false;
        }

        @Override
        public Mat compute(Mat image) {
            return null;
        }

        @Override
        public Set<Class<?>> allowedOperators() {
            return null;
        }
    }
}

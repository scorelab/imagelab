package com.imagelab.operator.geotransformation;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * RotateImage class related tests.
 */
class RotateImageTest {
    /**
     * To test whether validate method
     * returns true if it receives an allowed operator
     * and false for not allowed operators.
     */
    @Test
    void validateShouldCheckWhetherOperatorIsAllowed() {
        RotateImage rotateImage = new RotateImage();
        OpenCVOperator writeImgOperator, blurImageOperator;
        writeImgOperator = new WriteImage();
        blurImageOperator = new ApplyBlurEffect();
        //Test for allowed operators
        Assert.assertTrue(rotateImage.validate(writeImgOperator));
        //Test for not allowed operators.
        Assert.assertFalse(rotateImage.validate(blurImageOperator));
    }
}

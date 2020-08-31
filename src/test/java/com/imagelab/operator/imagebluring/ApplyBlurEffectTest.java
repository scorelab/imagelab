package com.imagelab.operator.imagebluring;

import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.WriteImage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * ApplyBlurEffectTest class related tests.
 */
class ApplyBlurEffectTest {
    /**
     * To test whether validate method
     * returns true if it receives an allowed operator
     * and false for not allowed operators.
     */
    @Test
    void validate() {
        ApplyBlurEffect applyBlurEffect = new ApplyBlurEffect();
        OpenCVOperator writeImgOperator = new WriteImage();
        //Test for allowed operators
        Assert.assertTrue(applyBlurEffect.validate(writeImgOperator));
    }
}

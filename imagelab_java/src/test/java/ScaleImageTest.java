import com.imagelab.operator.OpenCVOperator;
import com.imagelab.operator.basic.WriteImage;
import com.imagelab.operator.filtering.ApplyErosion;
import com.imagelab.operator.geotransformation.ScaleImage;
import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import com.imagelab.operator.transformation.LaplacianTransformation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


/**
 * ScaleImage class related tests.
 */
public class ScaleImageTest {
	 /**
     * To test whether validate method
     * returns true if it receives an allowed operator
     * and false for not allowed operators.
     */
    @Test
    void validateShouldCheckWhetherOperatorIsAllowed() {
        ScaleImage scaleImage = new ScaleImage();
        OpenCVOperator writeImgOperator, blurImageOperator,applyImgErosion,applyImgLaplacian;
        writeImgOperator = new WriteImage();
        blurImageOperator = new ApplyBlurEffect();
        applyImgErosion = new ApplyErosion();
        applyImgLaplacian = new LaplacianTransformation();
        //Test for allowed operators
        Assert.assertTrue(scaleImage.validate(writeImgOperator));
        //Test for allowed operators
        Assert.assertTrue(scaleImage.validate(applyImgErosion));
        //Test for disallowed operators
        Assert.assertFalse(scaleImage.validate(applyImgLaplacian));
    }
}

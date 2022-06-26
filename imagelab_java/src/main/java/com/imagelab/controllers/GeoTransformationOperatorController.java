package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.geotransformation.ColorMaps;
import com.imagelab.operator.geotransformation.ImageAffine;
import com.imagelab.operator.geotransformation.ImageReflection;
import com.imagelab.operator.geotransformation.RotateImage;
import com.imagelab.operator.geotransformation.ScaleImage;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.AffineTransformationPropertiesForm;
import com.imagelab.view.forms.ColorMapsPropertiesForm;
import com.imagelab.view.forms.ImageReflectionPropertiesForm;
import com.imagelab.view.forms.ImageScalePropertiesForm;
import com.imagelab.view.forms.RotateImgPropertiesForm;

public class GeoTransformationOperatorController {

	public static OperatorUIElement rotateImageElement() {
		//RotateImage UI element.
        OperatorUIElement rotateImage = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(RotateImage
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new RotateImgPropertiesForm((RotateImage) this.operator);
            }
        };
        rotateImage.operator = new RotateImage();
        rotateImage.operatorId = RotateImage.class.getCanonicalName();
        rotateImage.operatorName = "ROTATE-IMAGE";
        rotateImage.elementStyleId = "rotateImage";
        rotateImage.buildElement();
        return rotateImage;
	}
	public static OperatorUIElement colorMapsElement() {
		//ColorMaps UI element
        OperatorUIElement colorMaps = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ColorMaps
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new ColorMapsPropertiesForm((ColorMaps) this.operator);
            }
        };
        colorMaps.operator = new ColorMaps();
        colorMaps.operatorId = ColorMaps.class.getCanonicalName();
        colorMaps.operatorName = "COLOR-MAPS";
        colorMaps.elementStyleId = "colorMaps";
        colorMaps.buildElement();
        return colorMaps;
	}
	public static OperatorUIElement scaleImageElement() {
		//RotateImage UI element.
        OperatorUIElement scaleImage = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ScaleImage
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new ImageScalePropertiesForm((ScaleImage) this.operator);
            }
        };
        scaleImage.operator = new ScaleImage();
        scaleImage.operatorId = ScaleImage.class.getCanonicalName();
        scaleImage.operatorName = "SCALE-IMAGE";
        scaleImage.elementStyleId = "scaleImage";
        scaleImage.buildElement();
        return scaleImage;
	}
	public static OperatorUIElement affineTransformationElement() {
		//RotateImage UI element.
        OperatorUIElement affineTransform = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ImageAffine
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new AffineTransformationPropertiesForm((ImageAffine) this.operator);
            }
        };
        affineTransform.operator = new ImageAffine();
        affineTransform.operatorId = ImageAffine.class.getCanonicalName();
        affineTransform.operatorName = "AFFINE-IMAGE";
        affineTransform.elementStyleId = "affineTransform";
        affineTransform.buildElement();
        return affineTransform;
	}
	public static OperatorUIElement reflectionTransformationElement() {
		//RotateImage UI element.
        OperatorUIElement reflectionTransform = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ImageReflection
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new ImageReflectionPropertiesForm((ImageReflection) this.operator);
            }
        };
        reflectionTransform.operator = new ImageReflection();
        reflectionTransform.operatorId = ImageReflection.class.getCanonicalName();
        reflectionTransform.operatorName = "REFLECTION-IMAGE";
        reflectionTransform.elementStyleId = "reflectionTransform";
        reflectionTransform.buildElement();
        return reflectionTransform;
	}
}

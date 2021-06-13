package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.geotransformation.ColorMaps;
import com.imagelab.operator.geotransformation.RotateImage;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.ColorMapsPropertiesForm;
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
        rotateImage.operatorName = "ROTATE_IMAGE";
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
        colorMaps.operatorName = "COLOR_MAPS";
        colorMaps.elementStyleId = "colorMaps";
        colorMaps.buildElement();
        return colorMaps;
	}
}

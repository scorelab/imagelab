package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.transformation.LaplacianTransformation;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.LaplacianTransformationPropertiesForm;

public class TransformationOperatorController {
	public static OperatorUIElement laplacianTransformationElement() {
		//Laplacian Transformation UI element.
        OperatorUIElement laplacianTransformation = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(LaplacianTransformation
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new LaplacianTransformationPropertiesForm((LaplacianTransformation) this.operator);
            }
        };
        laplacianTransformation.operator = new LaplacianTransformation();
        laplacianTransformation.operatorId = LaplacianTransformation.class.getCanonicalName();
        laplacianTransformation.operatorName = "LAPLACIAN";
        laplacianTransformation.elementStyleId = "laplacianTransform";
        laplacianTransformation.buildElement();
        return laplacianTransformation;
	}
}

package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.sobelderivation.SobelOperator;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.SobelDerivationPropertiesForm;

public class SobelDerivationController {
	public static OperatorUIElement sobelOpeartorElement() {
		//Sobel Opeartor UI element.
        OperatorUIElement sobelOperator = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(SobelOperator
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new SobelDerivationPropertiesForm((SobelOperator) this.operator);
            }
        };
        sobelOperator.operator = new SobelOperator();
        sobelOperator.operatorId = SobelOperator.class.getCanonicalName();
        sobelOperator.operatorName = "SOBEL-DERIVATE";
        sobelOperator.elementStyleId = "sobelDerivate";
        sobelOperator.buildElement();
        return sobelOperator;
	}
}

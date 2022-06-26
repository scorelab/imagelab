package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.imagebluring.ApplyBlurEffect;
import com.imagelab.operator.imagebluring.ApplyGaussianBlurEffect;
import com.imagelab.operator.imagebluring.ApplyMedianBlurEffect;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.GaussianBlurPropertiesForm;
import com.imagelab.view.forms.MedianBlurPropertiesForm;
import com.imagelab.view.forms.SimpleBlurPropertiesForm;

public class BlurringOperatorController {
	public static OperatorUIElement applyBlurEffectElement() {
		//applyBlurEffect UI element.
        OperatorUIElement applyBlurEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ApplyBlurEffect
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new SimpleBlurPropertiesForm((ApplyBlurEffect) this.operator);
            }
        };
        applyBlurEffect.operator = new ApplyBlurEffect();
        applyBlurEffect.operatorId = ApplyBlurEffect.class.getCanonicalName();
        applyBlurEffect.operatorName = "APPLY-BLUR";
        applyBlurEffect.elementStyleId = "applyBlur";
        applyBlurEffect.buildElement();
        return applyBlurEffect;
	}
	public static OperatorUIElement applyGaussianEffectElement() {
		//applyGaussianBlurEffect UI element.
        OperatorUIElement applyGaussianBlurEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ApplyGaussianBlurEffect
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new GaussianBlurPropertiesForm((ApplyGaussianBlurEffect) this.operator);
            }
        };
        applyGaussianBlurEffect.operator = new ApplyGaussianBlurEffect();
        applyGaussianBlurEffect.operatorId = ApplyGaussianBlurEffect.class.getCanonicalName();
        applyGaussianBlurEffect.operatorName = "APPLY-GAUSSIAN-BLUR";
        applyGaussianBlurEffect.elementStyleId = "applyGaussianBlur";
        applyGaussianBlurEffect.buildElement();
        return applyGaussianBlurEffect;
	}
	public static OperatorUIElement applyMedainBlurEffectElement() {
		//applyMedianBlurEffect UI element.
        OperatorUIElement applyMedianBlurEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ApplyMedianBlurEffect
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new MedianBlurPropertiesForm((ApplyMedianBlurEffect) this.operator);
            }
        };
        applyMedianBlurEffect.operator = new ApplyMedianBlurEffect();
        applyMedianBlurEffect.operatorId = ApplyMedianBlurEffect.class.getCanonicalName();
        applyMedianBlurEffect.operatorName = "APPLY-MEDIAN-BLUR";
        applyMedianBlurEffect.elementStyleId = "applyMedianBlur";
        applyMedianBlurEffect.buildElement();
        return applyMedianBlurEffect;
	}
}

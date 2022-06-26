package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.thresholding.ApplyAdaptiveThreshold;
import com.imagelab.operator.thresholding.ApplyBorder;
import com.imagelab.operator.thresholding.ApplySimpleThreshold;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.AdaptiveThresholdPropertiesForm;
import com.imagelab.view.forms.ApplyBordersPropertiesForm;
import com.imagelab.view.forms.SimpleThresholdPropertiesForm;

public class ThresholdingOperatorController {
	
	public static OperatorUIElement applySimpleThresholdEffectElement() {
		//applySimpleThresholdEffect UI element.
	    OperatorUIElement applySimpleThresholdEffect = new OperatorUIElement() {
	        @Override
	        public AbstractInformationUI buildInformationUI() {
	            return new InformationContainerView(ApplySimpleThreshold
	                    .Information.OPERATOR_INFO.toString());
	        }

	        @Override
	        public AbstractPropertiesForm buildPropertiesFormUI() {
	            return new SimpleThresholdPropertiesForm((ApplySimpleThreshold) this.operator);
	        }
	    };
	    applySimpleThresholdEffect.operator = new ApplySimpleThreshold();
	    applySimpleThresholdEffect.operatorId = ApplySimpleThreshold.class.getCanonicalName();
	    applySimpleThresholdEffect.operatorName = "APPLY-THRESHOLD";
	    applySimpleThresholdEffect.elementStyleId = "applyThreshold";
	    applySimpleThresholdEffect.buildElement();
	    return applySimpleThresholdEffect;
	}
	public static OperatorUIElement applyAdaptiveThresholdEffectElement() {
		//applySimpleThresholdEffect UI element.
	    OperatorUIElement applyAdaptiveThresholdEffect = new OperatorUIElement() {
	        @Override
	        public AbstractInformationUI buildInformationUI() {
	            return new InformationContainerView(ApplyAdaptiveThreshold
	                    .Information.OPERATOR_INFO.toString());
	        }

	        @Override
	        public AbstractPropertiesForm buildPropertiesFormUI() {
	            return new AdaptiveThresholdPropertiesForm((ApplyAdaptiveThreshold) this.operator);
	        }
	    };
	    applyAdaptiveThresholdEffect.operator = new ApplyAdaptiveThreshold();
	    applyAdaptiveThresholdEffect.operatorId = ApplyAdaptiveThreshold.class.getCanonicalName();
	    applyAdaptiveThresholdEffect.operatorName = "ADAPTIVE-THRESHOLD";
	    applyAdaptiveThresholdEffect.elementStyleId = "adaptiveThreshold";
	    applyAdaptiveThresholdEffect.buildElement();
	    return applyAdaptiveThresholdEffect;
	}
	public static OperatorUIElement applyBorderThresholdEffectElement() {
		//applyBorders UI element.
	    OperatorUIElement applyBorders = new OperatorUIElement() {
	        @Override
	        public AbstractInformationUI buildInformationUI() {
	            return new InformationContainerView(ApplyBorder
	                    .Information.OPERATOR_INFO.toString());
	        }

	        @Override
	        public AbstractPropertiesForm buildPropertiesFormUI() {
	            return new ApplyBordersPropertiesForm((ApplyBorder) this.operator);
	        }
	    };
	    applyBorders.operator = new ApplyBorder();
	    applyBorders.operatorId = ApplyBorder.class.getCanonicalName();
	    applyBorders.operatorName = "APPLY-BORDERS";
	    applyBorders.elementStyleId = "applyBorders";
	    applyBorders.buildElement();
	    return applyBorders;
	}

}

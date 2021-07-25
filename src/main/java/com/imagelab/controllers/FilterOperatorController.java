package com.imagelab.controllers;

import com.imagelab.component.OperatorUIElement;
import com.imagelab.operator.filtering.ApplyBilateralFilter;
import com.imagelab.operator.filtering.ApplyBoxFilter;
import com.imagelab.operator.filtering.ApplyDilation;
import com.imagelab.operator.filtering.ApplyErosion;
import com.imagelab.operator.filtering.ApplyFilter2D;
import com.imagelab.operator.filtering.ApplyImagePyramid;
import com.imagelab.operator.filtering.ApplyImagePyramidDown;
import com.imagelab.operator.filtering.ApplyMorphological;
import com.imagelab.view.AbstractInformationUI;
import com.imagelab.view.InformationContainerView;
import com.imagelab.view.forms.AbstractPropertiesForm;
import com.imagelab.view.forms.BilateralFilterPropertiesForm;
import com.imagelab.view.forms.BoxFilterPropertiesForm;
import com.imagelab.view.forms.DilationFilterPropertiesForm;
import com.imagelab.view.forms.ErosionFilterPropertiesForm;
import com.imagelab.view.forms.Filter2DPropertiesForm;
import com.imagelab.view.forms.MorphologicalPropertiesForm;
import com.imagelab.view.forms.PyramidDownFilterPropertiesForm;
import com.imagelab.view.forms.PyramidUpFilterPropertiesForm;

public class FilterOperatorController {
	public static OperatorUIElement boxFilerEffectElement() {
		//applyBoxFilterEffect UI element.
		//applyBoxFilterEffect UI element.
        OperatorUIElement applyBoxFilterEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ApplyBoxFilter
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new BoxFilterPropertiesForm((ApplyBoxFilter) this.operator);
            }
        };
        applyBoxFilterEffect.operator = new ApplyBoxFilter();
        applyBoxFilterEffect.operatorId = ApplyBoxFilter.class.getCanonicalName();
        applyBoxFilterEffect.operatorName = "APPLY-BOX-FILTER";
        applyBoxFilterEffect.elementStyleId = "applyBoxFilter";
        applyBoxFilterEffect.buildElement();
        return applyBoxFilterEffect;
	}
	public static OperatorUIElement imageDilationEffectElement() {
		//applyDilationFilterEffect UI element.
        OperatorUIElement applyDilationFilterEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ApplyDilation
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new DilationFilterPropertiesForm((ApplyDilation) this.operator);
            }
        };
        applyDilationFilterEffect.operator = new ApplyDilation();
        applyDilationFilterEffect.operatorId = ApplyDilation.class.getCanonicalName();
        applyDilationFilterEffect.operatorName = "APPLY-DILATION";
        applyDilationFilterEffect.elementStyleId = "applyDilationFilter";
        applyDilationFilterEffect.buildElement();
        return applyDilationFilterEffect;
	}
    public static OperatorUIElement erosionFilterEffectElement() {
    	//applyErosionFilterEffect UI element
        OperatorUIElement applyErosionFilterEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ApplyErosion
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new ErosionFilterPropertiesForm((ApplyErosion) this.operator);
            }
        };
        applyErosionFilterEffect.operator = new ApplyErosion();
        applyErosionFilterEffect.operatorId =  ApplyErosion.class.getCanonicalName();
        applyErosionFilterEffect.operatorName = "APPLY-EROSION";
        applyErosionFilterEffect.elementStyleId = "applyErosionFilter";
        applyErosionFilterEffect.buildElement();
        return applyErosionFilterEffect;
    }
    public static OperatorUIElement pyramidsUpFilterEffectElement() {
    	//ImagePyramidsUp UI element
        OperatorUIElement applyPyramidUpFilterEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(ApplyImagePyramid
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new PyramidUpFilterPropertiesForm((ApplyImagePyramid) this.operator);
            }
        };
        applyPyramidUpFilterEffect.operator = new ApplyImagePyramid();
        applyPyramidUpFilterEffect.operatorId = ApplyImagePyramid.class.getCanonicalName();
        applyPyramidUpFilterEffect.operatorName = "PYRAMID-UP";
        applyPyramidUpFilterEffect.elementStyleId = "imagePyramidUpFilter";
        applyPyramidUpFilterEffect.buildElement();
        return applyPyramidUpFilterEffect;
    }
    public static OperatorUIElement pyramidsDownFilterEffectElement() {
    	//ImagePyramidsDown UI element
        OperatorUIElement applyPyramidDownFilterEffect = new OperatorUIElement() {
        	@Override
        	public AbstractInformationUI buildInformationUI() {
				return new InformationContainerView(ApplyImagePyramidDown
						.Information.OPERATOR_INFO.toString());
        		
        	}
        	@Override
        	public AbstractPropertiesForm buildPropertiesFormUI() {
                return new PyramidDownFilterPropertiesForm((ApplyImagePyramidDown) this.operator);
            }
        };
        applyPyramidDownFilterEffect.operator = new ApplyImagePyramidDown();
        applyPyramidDownFilterEffect.operatorId = ApplyImagePyramidDown.class.getCanonicalName();
        applyPyramidDownFilterEffect.operatorName = "PYRAMID-DOWN";
        applyPyramidDownFilterEffect.elementStyleId = "imagePyramidDownFilter";
        applyPyramidDownFilterEffect.buildElement();
        return applyPyramidDownFilterEffect;
    }
    public static OperatorUIElement bilateralFilterEffectElement() {
    	//applyBilateral Filter UI element
        OperatorUIElement applybilateralFilter = new OperatorUIElement() {
        	@Override
        	public AbstractInformationUI buildInformationUI() {
        		return new InformationContainerView(ApplyBilateralFilter
                        .Information.OPERATOR_INFO.toString());
        	}
        	@Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new BilateralFilterPropertiesForm((ApplyBilateralFilter) this.operator);
            }
        };
        applybilateralFilter.operator = new ApplyBilateralFilter();
        applybilateralFilter.operatorId = ApplyBilateralFilter.class.getCanonicalName();
        applybilateralFilter.operatorName = "APPLY-BILATERAL";
        applybilateralFilter.elementStyleId = "applyBilateralFilter";
        applybilateralFilter.buildElement();
        return applybilateralFilter;
    }
    public static OperatorUIElement morphologicalOperatorEffectElement() {
    	//applyBilateral Filter UI element
        OperatorUIElement morphologicalOperator = new OperatorUIElement() {
        	@Override
        	public AbstractInformationUI buildInformationUI() {
        		return new InformationContainerView(ApplyMorphological
                        .Information.OPERATOR_INFO.toString());
        	}
        	@Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new MorphologicalPropertiesForm((ApplyMorphological) this.operator);
            }
        };
        morphologicalOperator.operator = new ApplyMorphological();
        morphologicalOperator.operatorId = ApplyMorphological.class.getCanonicalName();
        morphologicalOperator.operatorName = "MORPHOLOGICAL";
        morphologicalOperator.elementStyleId = "applyMorphological";
        morphologicalOperator.buildElement();
        return morphologicalOperator;
    }
    public static OperatorUIElement filter2DOperatorEffectElement() {
    	//applyFilter2D Filter UI element
        OperatorUIElement filter2DOperator = new OperatorUIElement() {
        	@Override
        	public AbstractInformationUI buildInformationUI() {
        		return new InformationContainerView(ApplyFilter2D
                        .Information.OPERATOR_INFO.toString());
        	}
        	@Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new Filter2DPropertiesForm((ApplyFilter2D) this.operator);
            }
        };
        filter2DOperator.operator = new ApplyFilter2D();
        filter2DOperator.operatorId = ApplyFilter2D.class.getCanonicalName();
        filter2DOperator.operatorName = "FILTER2D";
        filter2DOperator.elementStyleId = "applyFilter2D";
        filter2DOperator.buildElement();
        return filter2DOperator;
    }

}

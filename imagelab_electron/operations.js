const PROCESS_OPERATIONS = {
  READIMAGE: "basic_readimage",
  WRITEIMAGE: "basic_writeimage",
  REFLECTIMAGE: "geometric_reflectimage",
  ROTATEIMAGE: "geometric_rotateimage",
  AFFINEIMAGE: "geometric_affineimage",
  SCALEIMAGE: "geometric_scaleimage",
  DRAWLINE: "drawingoperations_drawline",
  DRAWELLIPSE: "drawingoperations_drawellipse",
  DRAWARROWLINE: "drawingoperations_drawarrowline",
  DRAWTEXT: "drawingoperations_drawtext",
  DRAWCIRCLE: "drawingoperations_drawcircle",
  DRAWRECTANGLE: "drawingoperations_drawrectangle",
  BLURIMAGE: "blurring_applyblur",
  GAUSSIANBLUR: "blurring_applygaussianblur",
  MEDIANBLUR: "blurring_applymedianblur",
  BILATERALFILTER: "filtering_bilateral",
  BOXFILTER: "filtering_boxfilter",
  PYRAMIDUP: "filtering_pyramidup",
  PYRAMIDDOWN: "filtering_pyramiddown",
  EROSION: "filtering_erosion",
  DILATION: "filtering_dilation",
  MORPHOLOGICAL: "filtering_morphological",
  SOBEL: "sobelderivatives_soblederivate",
  SCHARR: "sobelderivatives_scharrderivate"
};

module.exports = PROCESS_OPERATIONS;

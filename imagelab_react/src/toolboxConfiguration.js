export const MY_TOOLBOX = {
    "kind": "categoryToolbox",
    "contents": [
      {
        "kind": "category",
        "name": "Basic",
        "colour": "#5ba58c",
        "contents": [
          {"kind": "block", "type": "basic_readimage"},
          {"kind": "block", "type": "basic_writeimage"},
          {"kind": "block", "type": "browse_file"},
          {"kind": "block", "type": "browse_folder"}
        ]
      },
      {
        "kind": "category",
        "name": "Geometric",
        "colour": "#a5745b",
        "contents": [
          {"kind": "block", "type": "geometric_reflectimage"},
          {"kind": "block", "type": "geometric_rotateimage"},
          {"kind": "block", "type": "geometric_affineimage"},
          {"kind": "block", "type": "geometric_scaleimage"}
        ]
      },
      {
        "kind": "category",
        "name": "Convertions",
        "colour": "#a55b80",
        "contents": [
          {"kind": "block", "type": "imageconvertions_grayimage"},
          {"kind": "block", "type": "imageconvertions_colormaps"},
          {"kind": "block", "type": "imageconvertions_graytobinary"},
          {"kind": "block", "type": "imageconvertions_colortobinary"}
        ]
      },
      {
        "kind": "category",
        "name": "Drawing",
        "colour": "#5b67a5",
        "contents": [
          {"kind": "block", "type": "drawingoperations_drawline"},
          {"kind": "block", "type": "drawingoperations_drawellipse"},
          {"kind": "block", "type": "drawingoperations_drawarrowline"},
          {"kind": "block", "type": "drawingoperations_drawtext"},
          {"kind": "block", "type": "drawingoperations_drawcircle"},
          {"kind": "block", "type": "drawingoperations_drawrectangle"}
        ]
      },
      {
        "kind": "category",
        "name": "Blurring",
        "colour": "#9fa55b",
        "contents": [
          {"kind": "block", "type": "blurring_applyblur"},
          {"kind": "block", "type": "blurring_applygaussianblur"},
          {"kind": "block", "type": "blurring_applymedianblur"}
        ]
      },
      {
        "kind": "category",
        "name": "Filtering",
        "colour": "#5ba55b",
        "contents": [
          {"kind": "block", "type": "filtering_bilateral"},
          {"kind": "block", "type": "filtering_pyramidup"},
          {"kind": "block", "type": "filtering_boxfilter"},
          {"kind": "block", "type": "filtering_pyramiddown"},
          {"kind": "block", "type": "filtering_erosion"},
          {"kind": "block", "type": "filtering_dilation"},
          {"kind": "block", "type": "filtering_morphological"}
        ]
      },
      {
        "kind": "category",
        "name": "Thresholding",
        "colour": "#745ba5",
        "contents": [
          {"kind": "block", "type": "thresholding_applyborders"},
          {"kind": "block", "type": "border_for_all"},
          {"kind": "block", "type": "border_each_side"},
          {"kind": "block", "type": "thresholding_adaptivethreshold"},
          {"kind": "block", "type": "thresholding_applythreshold"}
        ]
      },
      {
        "kind": "category",
        "name": "Sobel Derivatives",
        "colour": "#a55b80",
        "contents": [
          {"kind": "block", "type": "sobelderivatives_soblederivate"},
          {"kind": "block", "type": "sobelderivatives_scharrderivate"}
        ]
      },
      {
        "kind": "category",
        "name": "Transformation",
        "colour": "#5b80a5",
        "contents": [
          {"kind": "block", "type": "transformation_distance"},
          {"kind": "block", "type": "transformation_laplacian"}
        ]
      }
    ]
  };
  
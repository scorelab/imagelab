import Blockly from "blockly";
import "./browse-blocks-functions"
/* Configuration of all blocks included in our application in JSON format. */

Blockly.defineBlocksWithJsonArray([
    //Basic
    {
      type: "browse_file",
      message0: " %1",
      args0: [
        {
          name: "file_browse",
          type: "field_image",
          src: "imagelab_demo/src/image-plus.png",
          width: 40,
          height: 40,
          alt: "*",
          flipRtl: false,
        },
      ],
      output: "browse_file",
      colour: 160,
      tooltip: "Choose an image",
      helpUrl: "",
      extensions: ["file_button"],
    },
    {
      type: "browse_folder",
      message0: " %1",
      args0: [
        {
          name: "folder_browse",
          type: "field_image",
          src: "./folder-plus.png",
          width: 40,
          height: 40,
          alt: "*",
          flipRtl: false,
        },
      ],
      output: "browse_folder",
      colour: 160,
      tooltip: "Choose output folder",
      helpUrl: "",
      extensions: ["folder_button"],
    },
    {
      type: "basic_readimage",
      id: "1",
      message0: "Read image %1",
      args0: [
        {
          type: "input_value",
          id: "1",
          name: "imageURL",
          check: "browse_file",
        },
      ],
      nextStatement: null,
      colour: 160,
      tooltip:
        "This operator helps you to read an image file and convert it to an OpenCV Mat object.",
      helpUrl: "",
    },
    {
      type: "basic_writeimage",
      message0: "Write image",
      previousStatement: null,
      colour: 160,
      tooltip: "This operator allows you to save your processed image as a file.",
      helpUrl: "",
    },
  
    //Geometric
    {
      type: "geometric_reflectimage",
      message0: "Reflect image in %1 direction",
      args0: [
        {
          type: "field_dropdown",
          name: "type",
          options: [
            ["X", "X"],
            ["Y", "Y"],
            ["Both", "Both"],
          ],
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 20,
      tooltip:
        "Refelction produces a missror image like about and an axis of reflection. There are two type of reflection. One is x direction reflection and other is y direction reflection",
      helpUrl: "",
    },
    {
      type: "geometric_rotateimage",
      message0: "Rotate image with angle of %1 and rescale by %2",
      args0: [
        {
          type: "field_angle",
          name: "angle",
          angle: 90,
        },
        {
          type: "field_number",
          name: "scale",
          value: 1,
          min: 0,
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 20,
      tooltip:
        "This operator allows you to rotate an image to a specific angle. Moreover you can change angle and scale related to the rotation.",
      helpUrl: "",
    },
  
    {
      type: "geometric_affineimage",
      message0: "Affine Image",
      previousStatement: null,
      nextStatement: null,
      colour: 20,
      tooltip:
        "Image Affine Translation or shearing express in a materix form. It's a combination of shearing and reflection",
      helpUrl: "",
    },
    {
      type: "geometric_scaleimage",
      message0: "Scale Image by %1 in X axis and by %2 in Y axis",
      args0: [
        {
          type: "field_number",
          name: "fx",
          value: 1,
          min: 0,
        },
        {
          type: "field_number",
          name: "fy",
          value: 1,
          min: 0,
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 20,
      tooltip:
        "Image Affine Translation or shearing express in a materix form. It's a combination of shearing and reflection",
      helpUrl: "",
    },
  
    //Convertions
    {
      type: "imageconvertions_grayimage",
      message0: "Gray the image",
      previousStatement: null,
      nextStatement: null,
      colour: 315,
      tooltip:
        "This operations allows you to convert your image into a gray image.",
      helpUrl: "",
    },
    {
      type: "imageconvertions_colormaps",
      message0: "Color map image with %1 filter",
      args0: [
        {
          type: "field_dropdown",
          name: "type",
          options: [
            ["Hot", "HOT"],
            ["Autumn", "AUTUMN"],
            ["Bone", "BONE"],
            ["Cool", "COOL"],
            ["HSV", "HSV"],
            ["JET", "JET"],
            ["Ocean", "OCEAN"],
            ["Parula", "PARULA"],
            ["Piink", "PINK"],
            ["Rainbow", "RAINBOW"],
          ],
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 315,
      tooltip:
        "Color maps can apply different color maps to an image using this method. OpenCV caters various other types All these types are represents by predefined static fields(fixed values).",
      helpUrl: "",
    },
    {
      type: "imageconvertions_colortobinary",
      message0:
        "Convert colored image to a binary one %1 by %2 type %3 with threshold value  %4 and max value  %5 ",
      args0: [
        {
          type: "input_dummy",
        },
        {
          type: "field_dropdown",
          name: "thresholdType",
          options: [
            ["Threshold Binary", "threshold_binary"],
            ["Threshold Binary Inv", "threshold_binary_inv"],
          ],
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "thresholdValue",
          value: 0,
          min: 0,
        },
        {
          type: "field_number",
          name: "maxValue",
          value: 0,
          min: 0,
        },
      ],
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 315,
      tooltip:
        "This operations allows you to convert your colored (RGB) images into a binary image. Moreover, you can adjust the conversion threshold values and the threshold  type as well.",
      helpUrl: "",
    },
    {
      type: "imageconvertions_graytobinary",
      message0:
        "Convert grayscale image to a binary one %1 with threshold value  %2 and max value  %3 ",
      args0: [
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "thresholdValue",
          value: 0,
          min: 0,
        },
        {
          type: "field_number",
          name: "maxValue",
          value: 0,
          min: 0,
        },
      ],
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 315,
      tooltip:
        "This operations allows you to convert your grayscale image into a binary image. Moreover, you can adjust the conversion threshold values as well.",
      helpUrl: "",
    },
  
    //Drawing
    {
      type: "drawingoperations_drawline",
      message0:
        "Draw a line %1 with thickness of %2 %3 and color %4 from point1 x1 %5 y1 %6 to point2 x2 %7 y2%8",
      args0: [
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "thickness",
          value: 2,
          min: 1,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_colour",
          name: "rgbcolors_input",
          check: "rgb_block",
          colour: "#2828cc",
          columns: 5,
        },
        {
          type: "field_number",
          name: "starting_point_x1",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "starting_point_y1",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "ending_point_x1",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "ending_point_y2",
          check: "point_block",
        },
      ],
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 240,
      tooltip:
        "You can draw a line on the image and dedicate its thickness, color and start and end points.",
      helpUrl: "",
    },
    {
      type: "drawingoperations_drawarrowline",
      message0:
        "Draw an arrow line %1 with color %2 with thickness %3 from starting point x %4 and y %5 to point ending point x %6 and y %7",
      args0: [
        {
          type: "input_dummy",
        },
        {
          type: "field_colour",
          name: "rgbcolors_input",
          check: "rgb_block",
          colour: "#2828cc",
          columns: 5,
        },
        {
          type: "field_number",
          name: "thickness",
          value: 2,
          check: "point_block",
          min: 1,
        },
        {
          type: "field_number",
          name: "starting_point_x",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "starting_point_y",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "ending_point_x",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "ending_point_y",
          check: "point_block",
        },
      ],
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 240,
      tooltip:
        "You can draw an arrow line on the image and dedicate its color and start and end points.",
      helpUrl: "",
    },
    {
      type: "drawingoperations_drawcircle",
      message0:
        "Draw a circle %1 with thickness of %2 , %3  radius of %4 %5 color %6 center point x %7 and y %8",
      args0: [
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "thickness",
          value: 2,
          min: 1,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "radius",
          value: 5,
          min: 1,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_colour",
          name: "rgbcolors_input",
          check: "rgb_block",
          colour: "#2828cc",
          columns: 5,
        },
        {
          type: "field_number",
          name: "center_point_x",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "center_point_y",
          check: "point_block",
        },
      ],
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 240,
      tooltip:
        "You can draw a circle on the image and dedicate its thickness, radius, color and its center point.",
      helpUrl: "",
    },
    {
      type: "drawingoperations_drawellipse",
      message0:
        "Draw an ellipse with thickness of %1 %2 , height %3 , width %4 , rotate by %5 %6 color %7 center point x %8 and y %9",
      args0: [
        {
          type: "field_number",
          name: "thickness",
          value: 2,
          min: 1,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "height",
          value: 0,
          min: 0,
        },
        {
          type: "field_number",
          name: "width",
          value: 0,
          min: 0,
        },
        {
          type: "field_angle",
          name: "angle",
          angle: 90,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_colour",
          name: "rgbcolors_input",
          check: "rgb_block",
          colour: "#2828cc",
          columns: 5,
        },
        {
          type: "field_number",
          name: "center_point_x",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "center_point_y",
          check: "point_block",
        },
      ],
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 240,
      tooltip:
        "You can draw an ellipse on the image and dedicate its thickness, height and width, rotation angle, color and its center point.",
      helpUrl: "",
    },
    {
      type: "drawingoperations_drawrectangle",
      message0:
        "Draw a rectangle %1 with thickness of %2 %3 , color %4 ,  starting point x 1 %5 and y %6, ending point x %7 and y %8",
      args0: [
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "thickness",
          value: 2,
          min: 1,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_colour",
          name: "rgbcolors_input",
          check: "rgb_block",
          colour: "#2828cc",
          columns: 5,
        },
        {
          type: "field_number",
          name: "starting_point_x",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "starting_point_y",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "ending_point_x",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "ending_point_y",
          check: "point_block",
        },
      ],
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 240,
      tooltip:
        "You can draw a rectangle on the image and dedicate its thickness, color and its diameter points.",
      helpUrl: "",
    },
    {
      type: "drawingoperations_drawtext",
      message0:
        "Draw text %1 %2 with thickness of %3 %4 , by scale of %5 %6 , color %7 at point x %8 and y %9",
      args0: [
        {
          type: "field_input",
          name: "draw_text",
          text: "Image Lab",
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "thickness",
          value: 2,
          min: 1,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "scale",
          value: 1,
          min: 1,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_colour",
          name: "rgbcolors_input",
          check: "rgb_block",
          colour: "#2828cc",
          columns: 5,
        },
        {
          type: "field_number",
          name: "starting_point_x",
          check: "point_block",
        },
        {
          type: "field_number",
          name: "starting_point_y",
          check: "point_block",
        },
      ],
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 240,
      tooltip:
        "You can write a text on the image and dedicate its thickness, scale, color and start point.",
      helpUrl: "",
    },
  
    //Blurring
    {
      type: "blurring_applyblur",
      message0:
        "Apply Blur with width %1 , height %2 %3 from point x %4 and y %5",
      args0: [
        {
          type: "field_number",
          name: "widthSize",
          value: 3,
          min: 0,
        },
        {
          type: "field_number",
          name: "heightSize",
          value: 3,
          min: 0,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "pointX",
          value: -1,
        },
        {
          type: "field_number",
          name: "pointY",
          value: -1,
        },
      ],
      inputsInline: true,
      previousStatement: null,
      nextStatement: null,
      colour: 75,
      tooltip:
        "This operations allows you to apply simple blur effects to your image. You can change size and point properties to change the blur effect.",
      helpUrl: "",
    },
    {
      type: "blurring_applygaussianblur",
      message0: "Apply gaussian Blur with width %1 , height %2",
      args0: [
        {
          type: "field_number",
          name: "widthSize",
          value: 1,
          min: 1,
        },
        {
          type: "field_number",
          name: "heightSize",
          value: 1,
          min: 1,
        },
      ],
      inputsInline: true,
      previousStatement: null,
      nextStatement: null,
      colour: 75,
      tooltip:
        "This operations allows you to apply gaussian blur effects to your image.",
      helpUrl: "",
    },
    {
      type: "blurring_applymedianblur",
      message0: "Apply median Blur with kernel value of %1",
      args0: [
        {
          type: "field_number",
          name: "kernelSize",
          value: 5,
          min: 1,
        },
      ],
      inputsInline: true,
      previousStatement: null,
      nextStatement: null,
      colour: 75,
      tooltip:
        "This operations allows you to apply gaussian blur effects to your image.",
      helpUrl: "",
    },
  
    //Filtering
    {
      type: "filtering_boxfilter",
      message0:
        "Apply box filter with width %1 %2 , height %3 , depth %4 , pointX %5 , pointY %6",
      args0: [
        {
          type: "field_number",
          name: "width",
          value: 50,
          min: 0,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "height",
          value: 50,
          min: 0,
        },
        {
          type: "field_number",
          name: "depth",
          value: 5,
          min: 0,
        },
        {
          type: "field_number",
          name: "point_x",
          value: -1,
        },
        {
          type: "field_number",
          name: "point_y",
          value: -1,
        },
      ],
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 135,
      tooltip:
        "This operations allows you to apply simple box filter effects to your image. You can change size and point properties to change the blur effect.",
      helpUrl: "",
    },
    {
      type: "filtering_dilation",
      message0: "Apply dilation with %1 iterations %2 , pointX %3, pointY %4",
      args0: [
        {
          type: "field_number",
          name: "iteration",
          value: 1,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "pointX",
          value: -1,
        },
        {
          type: "field_number",
          name: "pointY",
          value: -1,
        },
      ],
      inputsInline: true,
      previousStatement: null,
      nextStatement: null,
      colour: 135,
      tooltip:
        "}This Filter operation allows convolution with some kernel of a specific shape such as a square or a circle the size of an object in white shade or bright shade increases. while the size of an object in black shade or dark shade decreases",
      helpUrl: "",
    },
    {
      type: "filtering_erosion",
      message0: "Apply erosion with %1 iterations %2 , pointX %3, pointY %4",
      args0: [
        {
          type: "field_number",
          name: "iteration",
          value: 1,
          min: 0,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "point_x",
          value: -1,
        },
        {
          type: "field_number",
          name: "point_y",
          value: -1,
        },
      ],
      inputsInline: true,
      previousStatement: null,
      nextStatement: null,
      colour: 135,
      tooltip:
        "Erosion is quite a similar process as dilation. With this procedure the areas of dark regions grow in size and bright regions reduce. The size of an object in white shade or bright shade increases. while it decreases in white shade or bright shade",
      helpUrl: "",
    },
    {
      type: "filtering_bilateral",
      message0:
        "Apply bilateral  %1 no. of iterations %2 %3 Sigma color %4 %5 Sigma space %6",
      args0: [
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "filterSize",
          value: 5,
          min: 0,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "sigmaColor",
          value: 75,
          min: 0,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "sigmaSpace",
          value: 75,
          min: 0,
        },
      ],
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 135,
      tooltip:
        "This Filter can reduce unwanted noise very well while keeping edges fairly sharpe ,It is very slow compared to most filters Sigma Values: If they are small(<10), filter will not have much effect. whereas if they are large(>150), they will have a very strong effect, making image look cartoonish.",
      helpUrl: "",
    },
    {
      type: "filtering_pyramidup",
      message0: "Pyramid up",
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 135,
      tooltip:
        "This Filter operation allows Pyramid, or pyramid representation, is a type of multi scale signal reprsenatation in which a signal or an image is subject to repeated smooted and subsampling you to apply pyramid up effect to your image. image is initially up-sampled and then blurred from this filter. use scaler to up sampled the image.",
      helpUrl: "",
    },
    {
      type: "filtering_pyramiddown",
      message0: "Pyramid down",
      inputsInline: false,
      previousStatement: null,
      nextStatement: null,
      colour: 135,
      tooltip:
        "This Filter operation allows Pyramid, or pyramid representation, is a type of multi scale signal reprsenatation in which a signal or an image is subject to repeated smooted and subsampling you to apply pyramid up effect to your image. image is initially up-sampled and then blurred from this filter. use scaler to up sampled the image.",
      helpUrl: "",
    },
    {
      type: "filtering_morphological",
      message0: "Apply morphological with %1 filter",
      args0: [
        {
          type: "field_dropdown",
          name: "type",
          options: [
            ["Tophat", "TOPHAT"],
            ["Close", "CLOSE"],
            ["Cross", "CROSS"],
            ["Gradient", "GRADIENT"],
            ["Rect", "RECT"],
            ["Black hat", "BLACKHAT"],
            ["Open", "OPEN"],
          ],
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 135,
      tooltip:
        "This Filter operation allows convolution with some kernel of a specific shape such as a square or a circle the size of an object in white shade or bright shade increases. while the size of an object in black shade or dark shade decreases",
      helpUrl: "",
    },
  
    //Thresholding
    {
      type: "thresholding_applyborders",
      message0: "Apply borders  %1",
      args0: [
        {
          type: "input_value",
          name: "border",
          check: ["border_for_all", "border_each_side"],
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 270,
      tooltip:
        "This effect adds a border around the given image. You can set the top, bottom, left and right border sizes from the properties.",
      helpUrl: "",
    },
    {
      type: "thresholding_adaptivethreshold",
      message0: "Apply adaptive threshold with max value %1",
      args0: [
        {
          type: "field_number",
          name: "maxValue",
          value: 0,
          min: 0,
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 270,
      tooltip:
        "Adaptive thresholding is the method where the threshold value is calculated for smaller regions and therefore, there will be different threshold values for different regions",
      helpUrl: "",
    },
    {
      type: "thresholding_applythreshold",
      message0:
        "Apply simple threshold %1 with max value %2 %3 and threshold value %4",
      args0: [
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "maxValue",
          value: 0,
          min: 0,
        },
        {
          type: "input_dummy",
        },
        {
          type: "field_number",
          name: "thresholdValue",
          value: 0,
          min: 0,
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 270,
      tooltip:
        "Thresholding is a method of image segmentation, in general it is used to create binary images. You can change the threshold value from the properties as well as you can assign a max value.",
      helpUrl: "",
    },
    {
      type: "border_for_all",
      message0: "with thickness %1",
      args0: [
        {
          type: "field_number",
          name: "border_all_sides",
          value: 2,
          min: 0,
        },
      ],
      output: "border_for_all",
      colour: 270,
      tooltip: "",
      helpUrl: "",
    },
    {
      type: "border_each_side",
      lastDummyAlign0: "CENTRE",
      message0: "with thickness %1 %2 %3 %4 %5 %6 %7",
      args0: [
        {
          type: "input_dummy",
          align: "CENTRE",
        },
        {
          type: "field_number",
          name: "borderTop",
          value: 2,
          min: 0,
        },
        {
          type: "input_dummy",
          align: "CENTRE",
        },
        {
          type: "field_number",
          name: "borderLeft",
          value: 2,
          min: 0,
        },
        {
          type: "field_number",
          name: "borderRight",
          value: 2,
          min: 0,
        },
        {
          type: "input_dummy",
          align: "CENTRE",
        },
        {
          type: "field_number",
          name: "borderBottom",
          value: 2,
          min: 0,
        },
      ],
      inputsInline: false,
      output: "border_each_side",
      colour: 270,
      tooltip: "",
      helpUrl: "",
    },
  
    //Sobel Derivatives
    {
      type: "sobelderivatives_soblederivate",
      message0: "Apply  %1 sobel derivative with %2 depth",
      args0: [
        {
          type: "field_dropdown",
          name: "type",
          options: [
            ["Horizontal", "HORIZONTAL"],
            ["Vertical", "VERTICAL"],
            ["Both", "BOTH"],
          ],
        },
        {
          type: "field_number",
          name: "ddepth",
          value: 0,
          min: -10,
          max: 10,
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 345,
      tooltip:
        "This operator allows you to detect edges of an image of both horizontal and vertaical direction Moreover it is a first order derivative.",
      helpUrl: "",
    },
    {
      type: "sobelderivatives_scharrderivate",
      message0: "Apply  %1 scharr derivative with %2 depth",
      args0: [
        {
          type: "field_dropdown",
          name: "type",
          options: [
            ["Horizontal", "HORIZONTAL"],
            ["Vertical", "VERTICAL"],
          ],
        },
        {
          type: "field_number",
          name: "ddepth",
          value: 0,
          min: -10,
          max: 10,
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 345,
      tooltip:
        "This operator allows you to detect edges of an image in both horizontal and vertaical direction. Moreover it is a second order derivative.",
      helpUrl: "",
    },
  
    //Transformation
    {
      type: "transformation_distance",
      message0: "Apply  %1 distance with %2 depth",
      args0: [
        {
          type: "field_dropdown",
          name: "type",
          options: [
            ["DISTC", "DIST_C"],
            ["DISTL1", "DIST_L1"],
            ["DISTL2", "DIST_L2"],
            ["DISTLABEL_PIXEL", "DIST_LABEL_PIXEL"],
            ["DISTMASK_3", "DIST_MASK_3"],
          ],
        },
        {
          type: "field_number",
          name: "ddepth",
          value: 0,
          min: -10,
          max: 10,
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 195,
      tooltip:
        "Distance Transformation generally takes binary images as inputs. In this operation,the gray level intensities of the points inside the foreground regions are chnaged to distance their respective distances from the closest 0 value.",
      helpUrl: "",
    },
    {
      type: "transformation_laplacian",
      message0: "Apply laplacian with %1 depth",
      args0: [
        {
          type: "field_number",
          name: "ddepth",
          value: 0,
          min: -10,
          max: 10,
        },
      ],
      previousStatement: null,
      nextStatement: null,
      colour: 195,
      tooltip:
        "Laplacian Transformation is also a derivate which used to find edges in an image.It is a second order derivate mask Moreover in this mask two classifications one is Postive Laplacian and Negative Laplacian Unlike other opertors Laplacian didn't take out edges in any particular direction but it takes out edges in inward edges and outward edges.",
      helpUrl: "",
    },
  ]);
  
  /*
  Blockly.Blocks['MyBlock'] = {
    init: function() {
      this.appendDummyInput()
          .appendField(new MyFieldImage("https://www.gstatic.com/codesite/ph/images/star_on.gif", 15, 15, "*",true));
      this.setTooltip('');
      this.setHelpUrl('');
    }
  };
  */
  
  /*
  {
    "type": "MyBlock",
    "message0": "%1 Red",
    "args0": [
      {
        "type": "field_image",
        "src": "https://www.gstatic.com/codesite/ph/images/star_on.gif",
        "width": 15,
        "height": 15,
        "alt": "*",
        "opt_onClick": true,
        "flipRtl": false
      },
  
    ],
    "inputsInline": false,
    "output": null,
    "colour": 240,
    "tooltip": "",
    "helpUrl": ""
  },*/
  
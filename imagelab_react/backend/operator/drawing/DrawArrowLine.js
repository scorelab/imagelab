const OpenCvOperator = require("../OpenCvOperator");
const { hexToRgb } = require("../../helpers/convertColor");

/**
 * This function contains the main logic
 * to draw an arrowed line on the image
 */
class DrawArrowLine extends OpenCvOperator {
  #lineColor = { r: 40, g: 40, b: 240 };
  #thickness = 2;
  #startingPointX = 0;
  #startingPointY = 0;
  #endingPointX = 0;
  #endingPointY = 0;
  constructor(type, id) {
    super(type, id);
  }

  setParams(param, value) {
    if (param === "rgbcolors_input") {
      this.#lineColor = hexToRgb(value);
    } else if (param === "thickness") {
      this.#thickness = value;
    } else if (param === "starting_point_x") {
      this.#startingPointX = value;
    } else if (param === "starting_point_y") {
      this.#startingPointY = value;
    } else if (param === "ending_point_x") {
      this.#endingPointX = value;
    } else if (param === "ending_point_y") {
      this.#endingPointY = value;
    }
  }

  compute(image) {
    // There is no function in opencv.js to draw an arrowed line
    return image;
  }
}

module.exports = DrawArrowLine;

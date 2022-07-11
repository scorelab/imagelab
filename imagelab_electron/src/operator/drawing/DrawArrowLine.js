const { hexToRgb } = require("../../helpers/convertColor");
const OpenCvOperator = require("../OpenCvOperator");

class DrawArrowLine extends OpenCvOperator {
  #lineColor = { r: 40, g: 40, b: 240 };
  #thickness = 2;
  #startingPointX = 0;
  #startingPointY = 0;
  #endingPointX = 0;
  #endingPointY = 0;
  constructor(type) {
    super(type);
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
    let p1 = new this.cv2.Point(this.#startingPointX, this.#startingPointY);
    let p2 = new this.cv2.Point(this.#endingPointX, this.#endingPointY);
    this.cv2.arrowedLine(
      image,
      p1,
      p2,
      [this.#lineColor.r, this.#lineColor.g, this.#lineColor.b, 255],
      this.#thickness
    );
    return image;
  }
}

module.exports = DrawArrowLine;

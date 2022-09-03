const OpenCvOperator = require("../OpenCvOperator");
const { hexToRgb } = require("../../helpers/convertColor");

/**
 * This functions contains the main logic of
 * drawing a circle inside the input image
 */
class DrawCircle extends OpenCvOperator {
  #thickness = 2;
  #radius = 5;
  #circleColor = { r: 40, g: 40, b: 240 };
  #centerPointX = 0;
  #centerPointY = 0;
  constructor(type, id) {
    super(type, id);
  }
  setParams(param, value) {
    if (param === "rgbcolors_input") {
      this.#circleColor = hexToRgb(value);
    } else if (param === "thickness") {
      this.#thickness = value;
    } else if (param === "radius") {
      this.#radius = value;
    } else if (param === "center_point_x") {
      this.#centerPointX = value;
    } else if (param === "center_point_y") {
      this.#centerPointY = value;
    }
  }

  /**
   * This function is responsible for drawing a circle
   * in the input image according to the given inputs
   * @param {Mat} image
   * @returns {Mat}
   */
  compute(image) {
    let p1 = new this.cv2.Point(this.#centerPointX, this.#centerPointY);
    this.cv2.circle(
      image,
      p1,
      this.#radius,
      [this.#circleColor.r, this.#circleColor.g, this.#circleColor.b, 255],
      this.#thickness
    );
    return image;
  }
}

module.exports = DrawCircle;

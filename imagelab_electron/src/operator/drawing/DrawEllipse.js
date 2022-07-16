const OpenCvOperator = require("../OpenCvOperator");
const { hexToRgb } = require("../../helpers/convertColor");

/**
 * This class contains the main logic to draw an ellipse
 * On the input image
 */
class DrawEllipse extends OpenCvOperator {
  #thickness = 2;
  #height = 5;
  #width = 5;
  #centerPointX = 0;
  #centerPointY = 0;
  #ellipseColor = { r: 40, g: 40, b: 240 };
  #angle = 90;

  constructor(type) {
    super(type);
  }

  setParams(param, value) {
    if (param === "thickness") {
      this.#thickness = value;
    } else if (param === "height") {
      this.#height = value;
    } else if (param === "width") {
      this.#width = value;
    } else if (param === "angle") {
      this.#angle = value;
    } else if (param === "center_point_x") {
      this.#centerPointX = value;
    } else if (param === "center_point_y") {
      this.#centerPointY = value;
    } else if (param === "rgbcolors_input") {
      this.#ellipseColor = hexToRgb(value);
    }
  }

  /**
   * This function get the mat image and
   * draw an ellipse according to the given inputs
   * @param {Mat} image
   * @returns {Mat}
   */
  compute(image) {
    let p1 = new this.cv2.Point(this.#centerPointX, this.#centerPointY);
    let s1 = new this.cv2.Size(this.#height, this.#width);
    this.cv2.ellipse(
      image,
      p1,
      s1,
      this.#angle,
      0,
      360,
      [this.#ellipseColor.r, this.#ellipseColor.g, this.#ellipseColor.b, 255],
      this.#thickness
    );
    return image;
  }
}

module.exports = DrawEllipse;

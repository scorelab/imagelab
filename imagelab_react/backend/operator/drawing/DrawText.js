const OpenCvOperator = require("../OpenCvOperator");
const { hexToRgb } = require("../../helpers/convertColor");

/**
 * This class includes the main logic of
 * putting the text over an input image
 */
class DrawText extends OpenCvOperator {
  #text = "Image Lab";
  #thickness = 2;
  #scale = 1;
  #textColor = { r: 40, g: 40, b: 240 };
  #pointX = 0;
  #pointY = 0;

  constructor(type, id) {
    super(type, id);
  }
  setParams(param, value) {
    if (param === "draw_text") {
      this.#text = value;
    } else if (param === "thickness") {
      this.#thickness = value;
    } else if (param === "scale") {
      this.#scale = value;
    } else if (param === "rgbcolors_input") {
      this.#textColor = hexToRgb(value);
    } else if (param === "starting_point_x") {
      this.#pointX = value;
    } else if (param === "starting_point_y") {
      this.#pointY = value;
    }
  }

  /**
   * This function draws the text over the input
   * image according to the inputted values
   * @param {Mat} image
   * @returns {Mat}
   */
  compute(image) {
    let p1 = new this.cv2.Point(this.#pointX, this.#pointY);
    const font = this.cv2.FONT_HERSHEY_SIMPLEX;
    this.cv2.putText(
      image,
      this.#text,
      p1,
      font,
      this.#scale,
      [this.#textColor.r, this.#textColor.g, this.#textColor.b, 255],
      this.#thickness,
      this.cv2.LINE_AA
    );
    return image;
  }
}

module.exports = DrawText;

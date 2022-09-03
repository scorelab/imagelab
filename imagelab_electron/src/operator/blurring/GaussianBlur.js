const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic to add
 * gaussian blur to an image
 */
class GaussianBlur extends OpenCvOperator {
  #width = 1; // This value should be an odd number
  #height = 1; // This values should be an odd number
  constructor(type, id) {
    super(type, id);
  }

  setParams(param, value) {
    if (param === "widthSize") {
      this.#width = value;
    } else if (param === "heightSize") {
      this.#height = value;
    }
  }

  /**
   *
   * @param {Mat} image
   * @returns
   *
   * This function proccessed the gausian blur
   * of the Mat image
   */
  compute(image) {
    if (this.#height % 2 == 0) {
      throw new Error("Height should be an odd number!");
    }
    if (this.#width % 2 === 0) {
      throw new Error("Width should be an odd number!");
    }
    const dst = new this.cv2.Mat();
    const ksize = new this.cv2.Size(this.#width, this.#height);
    this.cv2.GaussianBlur(image, dst, ksize, 0, 0, this.cv2.BORDER_DEFAULT);
    return dst;
  }
}

module.exports = GaussianBlur;

const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic of
 * adding bilateralfilter to an image
 */
class BilateralFilter extends OpenCvOperator {
  #d = 5;
  #sigmaColor = 75;
  #sigmaSpace = 75;

  constructor(type, id) {
    super(type, id);
  }

  setParams(type, value) {
    if (type === "filterSize") {
      this.#d = value;
    } else if (type === "sigmaColor") {
      this.#sigmaColor = value;
    } else if (type === "sigmaSpace") {
      this.#sigmaSpace = value;
    }
  }

  /**
   *
   * @param {Mat} image
   * @returns
   * computes the bilateral filter of the mat image
   */
  compute(image) {
    let dst = new this.cv2.Mat();
    this.cv2.cvtColor(image, image, this.cv2.COLOR_RGBA2RGB, 0);
    this.cv2.bilateralFilter(
      image,
      dst,
      this.#d,
      this.#sigmaColor,
      this.#sigmaSpace,
      this.cv2.BORDER_DEFAULT
    );
    return dst;
  }
}

module.exports = BilateralFilter;

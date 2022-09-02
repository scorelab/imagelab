const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic
 * of adding dilation to an image
 */
class Dilation extends OpenCvOperator {
  #iterations = 1;
  #pointX = -1;
  #pointY = -1;
  constructor(type) {
    super(type);
  }

  setParams(type, value) {
    if (type === "iteration") {
      this.#iterations = value;
    } else if (type === "pointX") {
      this.#pointX = value;
    } else if (type === "pointY") {
      this.#pointY = value;
    }
  }

  /**
   *
   * @param {Mat} image
   * @returns
   * Computes the dilation filter to the mat image
   *
   */
  compute(image) {
    let dst = new this.cv2.Mat();
    let M = this.cv2.Mat.ones(5, 5, this.cv2.CV_8U);
    let anchor = new this.cv2.Point(this.#pointX, this.#pointY);
    this.cv2.dilate(
      image,
      dst,
      M,
      anchor,
      this.#iterations,
      this.cv2.BORDER_CONSTANT,
      this.cv2.morphologyDefaultBorderValue()
    );
    return dst;
  }
}

module.exports = Dilation;

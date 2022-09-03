const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic
 * of adding erosion to an image
 */
class Erosion extends OpenCvOperator {
  #iterations = 1;
  #pointX = -1;
  #pointY = -1;

  constructor(type, id) {
    super(type, id);
  }

  setParams(param, value) {
    if (param === "iteration") {
      this.#iterations = value;
    } else if (param === "point_x") {
      this.#pointX = value;
    } else if (param === "point_y") {
      this.#pointY = value;
    }
  }

  /**
   *
   * @param {Mat} image
   * @returns
   * Computes the erosion filter to the mat image
   */
  compute(image) {
    let dst = new this.cv2.Mat();
    let M = this.cv2.Mat.ones(5, 5, this.cv2.CV_8U);
    let anchor = new this.cv2.Point(this.#pointX, this.#pointY);
    this.cv2.erode(
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

module.exports = Erosion;

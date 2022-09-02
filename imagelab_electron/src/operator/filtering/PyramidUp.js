const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic
 * of adding pyramid up filter to an image
 */
class PyramidUp extends OpenCvOperator {
  constructor(type) {
    super(type);
  }

  setParams(param, value) {}

  /**
   *
   * @param {Mat} image
   * @returns
   * Computes the PyramidUp filter to the
   * processed mat image
   */
  compute(image) {
    let dst = new this.cv2.Mat();
    let size = new this.cv2.Size(image.cols * 2, image.rows * 2);
    this.cv2.pyrUp(image, dst, size, this.cv2.BORDER_DEFAULT);
    return dst;
  }
}

module.exports = PyramidUp;

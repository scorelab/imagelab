const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic to gray the image
 */
class GrayImage extends OpenCvOperator {
  constructor(type, id) {
    super(type, id);
  }

  /**
   * @param {Mat} image
   * @returns
   * This function grays the image
   */
  compute(image) {
    let dst = new this.cv2.Mat();
    this.cv2.cvtColor(image, dst, this.cv2.COLOR_BGR2GRAY);
    return dst;
  }
}

module.exports = GrayImage;
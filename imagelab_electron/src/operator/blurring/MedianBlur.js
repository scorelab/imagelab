const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic to add MedianBlur
 * to an image
 */
class MedianBlur extends OpenCvOperator {
  #kernalSize = 5; // This value should be an odd number
  constructor(type, id) {
    super(type, id);
  }
  setParams(param, value) {
    if (param === "kernelSize") {
      if (value % 2 === 0) {
        throw new Error("Kernel Size should be an odd number");
      }
      this.#kernalSize = value;
    }
  }

  /**
   *
   * @param {Mat} image
   * @returns
   *
   * This function processed the median blur
   * to the mat image
   */
  compute(image) {
    const dst = new this.cv2.Mat();
    this.cv2.medianBlur(image, dst, this.#kernalSize);
    return dst;
  }
}

module.exports = MedianBlur;

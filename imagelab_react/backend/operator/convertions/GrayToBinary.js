const OpenCvOperator = require("../OpenCvOperator");

class GrayToBinary extends OpenCvOperator {
  #thresholdValue = 0;
  #maxValue = 0;
  constructor(type, id) {
    super(type, id);
  }

  /**
   * This methods sets the values of the class
   * @param {String} type
   * @param {String} value
   */
  setParams(type, value) {
    if (type === "thresholdValue") {
      this.#thresholdValue = value;
    } else if (type === "maxValue") {
      this.#maxValue = value;
    }
  }

  /**
   *
   * @param {Mat} image
   * @returns
   * This function converts gray image to a binary one
   */
  compute(image) {
    let dst = new this.cv2.Mat();

    this.cv2.threshold(image, dst, this.#thresholdValue, this.#maxValue, this.cv2.THRESH_BINARY);
    
    return dst;
  }
}

module.exports = GrayToBinary;
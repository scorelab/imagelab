const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic
 * to add the average blur to an image
 */
class Blur extends OpenCvOperator {
  #height = 3;
  #width = 3;
  #pointX = -1;
  #pointY = -1;
  constructor(type) {
    super(type);
  }

  setParams(param, value) {
    if (param === "widthSize") {
      this.#width = value;
    } else if (param === "heightSize") {
      this.#height = value;
    } else if (param === "pointX") {
      this.#pointX = value;
    } else if (param === "pointY") {
      this.#pointY = value;
    }
  }

  compute(image) {
    const dst = new this.cv2.Mat();
    const ksize = new this.cv2.Size(this.#height, this.#width);
    const anchor = new this.cv2.Point(this.#pointX, this.#pointY);
    this.cv2.blur(image, dst, ksize, anchor, this.cv2.BORDER_DEFAULT);
    return dst;
  }
}

module.exports = Blur;

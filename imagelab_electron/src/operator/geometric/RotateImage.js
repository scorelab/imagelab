const OpenCvOperator = require("../OpenCvOperator");

class RotateImage extends OpenCvOperator {
  #angle = 90;
  #scale = 1;
  constructor(type, id) {
    super(type, id);
  }

  /**
   * This function sets the values for the rotate image
   * @param {String} type
   * @param {number} value
   */
  setParams(type, value) {
    if (type === "angle") {
      this.#angle = value;
    } else if (type === "scale") {
      this.#scale = value;
    }
  }

  /**
   * This function rotates and scales the input image according to the
   * inputs given by the user
   * @param {Mat image} image
   * @returns
   */
  compute(image) {
    let dst = new this.cv2.Mat();
    let dsize = new this.cv2.Size(image.rows, image.cols);
    let center = new this.cv2.Point(image.cols / 2, image.rows / 2);
    let M = this.cv2.getRotationMatrix2D(center, this.#angle, this.#scale);
    this.cv2.warpAffine(
      image,
      dst,
      M,
      dsize,
      this.cv2.INTER_LINEAR,
      this.cv2.BORDER_CONSTANT,
      new this.cv2.Scalar()
    );
    return dst;
  }
}

module.exports = RotateImage;

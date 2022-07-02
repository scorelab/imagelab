const OpenCvOperator = require("../OpenCvOperator");

class ScaleImage extends OpenCvOperator {
  #xaxis = 1;
  #yaxis = 1;
  constructor(type) {
    super(type);
  }

  /**
   * This methods sets the values of the class
   * @param {String} type
   * @param {String} value
   */
  setParams(type, value) {
    if (type === "fx") {
      this.#xaxis = value;
    } else if (type === "fy") {
      this.#yaxis = value;
    }
  }

  compute(image) {
    let dst = new this.cv2.Mat();
    let dsize = new this.cv2.Size(
      Math.round(image.rows * this.#xaxis),
      Math.round(image.cols * this.#yaxis)
    );
    this.cv2.resize(
      image,
      dst,
      dsize,
      this.#xaxis,
      this.#yaxis,
      this.cv2.INTER_AREA
    );
    return dst;
  }
}

module.exports = ScaleImage;

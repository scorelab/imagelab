const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic
 * of adding morphological filters to
 * an image
 */
class Morphological extends OpenCvOperator {
  #type = "TOPHAT";
  constructor(type, id) {
    super(type, id);
  }

  setParams(param, value) {
    if (param === "type") {
      this.#type = value;
    }
  }

  /**
   *
   * @param {Mat} image
   * @returns
   * Computes the Morphological filter to the processed
   * Mat image
   */
  compute(image) {
    let dst = new this.cv2.Mat();
    let M = this.cv2.Mat.ones(5, 5, this.cv2.CV_8U);
    let anchor = new this.cv2.Point(-1, -1);
    switch (this.#type) {
      case "OPEN":
        this.cv2.morphologyEx(
          image,
          dst,
          this.cv2.MORPH_OPEN,
          M,
          anchor,
          1,
          this.cv2.BORDER_CONSTANT,
          this.cv2.morphologyDefaultBorderValue()
        );
        break;
      case "CLOSE":
        this.cv2.morphologyEx(image, dst, this.cv2.MORPH_CLOSE, M);
        break;
      case "GRADIENT":
        this.cv2.cvtColor(image, image, this.cv2.COLOR_RGBA2RGB);
        this.cv2.morphologyEx(image, dst, this.cv2.MORPH_GRADIENT, M);
        break;
      case "TOPHAT":
        this.cv2.cvtColor(image, image, this.cv2.COLOR_RGBA2RGB);
        this.cv2.morphologyEx(image, dst, this.cv2.MORPH_TOPHAT, M);
        break;
      case "BLACKHAT":
        this.cv2.cvtColor(image, image, this.cv2.COLOR_RGBA2RGB);
        this.cv2.morphologyEx(image, dst, this.cv2.MORPH_BLACKHAT, M);
        break;
    }
    return dst;
  }
}

module.exports = Morphological;

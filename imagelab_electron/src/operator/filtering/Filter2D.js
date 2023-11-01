const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic to add Filter2D
 * to an image
 */

class Filter2D extends OpenCvOperator {
  #kernelSize = 2;
  #ddepth = -1;
  constructor(type, id) {
        super(type, id);
  }

  setParams(type, value) {
    if (type === "kernelSize") {
      this.#kernelSize = value;
    } else if (type === "ddepth") {
      this.#ddepth = value;
    } 
  }


  /**
   *
   * @param {Mat} image
   * @returns
   *
   * This function processes the filter2D
   * to the mat image
   */
  compute(image) {
    const dst = new this.cv2.Mat();
    let M = this.cv2.Mat.eye(this.#kernelSize, this.#kernelSize, this.cv2.CV_32FC1);
    let anchor = new this.cv2.Point(-1, -1);
    this.cv2.filter2D(
        image, 
        dst,
        this.#ddepth,
        M,
        anchor,
        0,
        this.cv2.BORDER_DEFAULT
        );
    return dst;
  }
}

module.exports = Filter2D;
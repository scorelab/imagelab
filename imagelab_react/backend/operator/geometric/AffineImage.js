const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic
 * of affinetransoforming the image
 */
class AffineImage extends OpenCvOperator {
  constructor(type, id) {
    super(type, id);
  }

  /**
   *
   * @param {Mat Image} image
   * @returns
   * Computes the AffineImage transformation
   * to the Processed Mat image
   */
  compute(image) {
    let dst = new this.cv2.Mat();
    let M = this.cv2.matFromArray(
      2,
      3,
      this.cv2.CV_64FC1,
      [1, 0, 50, 0, 1, 100]
    );
    let dsize = new this.cv2.Size(image.rows, image.cols);
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

module.exports = AffineImage;

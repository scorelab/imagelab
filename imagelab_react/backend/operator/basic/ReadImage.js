const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic to read the image
 */
class ReadImage extends OpenCvOperator {
  constructor(type, id) {
    super(type, id);
  }

  /**
   * This function reads the given image
   * @param {Mat} image
   * @returns processed image
   */
  compute(bitmap) {
    const mat = this.cv2.matFromImageData(bitmap);
    return mat;
  }
}

module.exports = ReadImage;

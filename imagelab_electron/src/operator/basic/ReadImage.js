const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic to read the image
 */
class ReadImage extends OpenCvOperator {
  constructor(type) {
    super(type);
    console.log(this.cv2);
  }

  /**
   * This function reads the given image
   * @param {Mat} image
   * @returns processed image
   */
  compute(image) {
    return this.cv2.imread(image);
  }
}

module.exports = ReadImage;

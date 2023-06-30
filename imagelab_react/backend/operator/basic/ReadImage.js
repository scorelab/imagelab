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
  compute(image) {
    return "hello";
    //return this.cv2.imread(image);
  }
}

module.exports = ReadImage;

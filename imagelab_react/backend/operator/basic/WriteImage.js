const Jimp = require("jimp");
const OpenCvOperator = require("../OpenCvOperator");

/**
 * Class which contains the functions to write the
 * processed image.
 */
class WriteImage extends OpenCvOperator {
  constructor(type, id) {
    super(type, id);
  }

  /**
   * This function writes a processed image to the path given
   * And save the image in the location that the user specified
   * cv2.imwrite is not avilable in JS therefore
   * pure js method is used to save the method
   * @param {Mat} processedImage
   */
  compute(processedImage) {
    return new Jimp({
      width: processedImage.cols,
      height: processedImage.rows,
      data: Buffer.from(processedImage.data)
      });
   }
}

module.exports = WriteImage;

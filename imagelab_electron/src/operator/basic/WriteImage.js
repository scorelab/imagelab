const OpenCvOperator = require("../OpenCvOperator");

/**
 * Class which contains the functions to write the
 * processed image.
 */
class WriteImage extends OpenCvOperator {
  constructor(type) {
    super(type);
  }

  /**
   * This function writes a processed image to the path given
   * And save the image in the location that the user specified
   * cv2.imwrite is not avilable in JS therefore
   * pure js method is used to save the method
   * @param {Mat} processedImage
   */
  compute(processedImage) {
    const preview = document.getElementById("image-preview");
    this.cv2.imshow(preview, processedImage);
    var link = document.createElement("a");
    link.download = "Processed_image.jpg";
    link.href = preview.toDataURL();
    link.click();
  }
}

module.exports = WriteImage;

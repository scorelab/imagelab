const OpenCvOperator = require("../OpenCvOperator");

/**
 * Class which contains the functions to write the
 * processed image.
 */
class WriteImage extends OpenCvOperator {
  #outImageUrl = __dirname + "/proccesedimage.jpg";

  constructor() {
    super();
  }

  /**
   * This function writes a processed image to the path given
   * And save the image in the location that the user specified
   * @param {Processed image to write} processedImage
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

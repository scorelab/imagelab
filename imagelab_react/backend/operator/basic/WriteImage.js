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
    // Store the selected image in local storage
    localStorage.setItem("processedImage", processedImage);
    // Send message to the parent window
    window.alert("Hello");
    window.postMessage({ type: 'imageProcessed', processedImage }, '*');
  }
}

module.exports = WriteImage;

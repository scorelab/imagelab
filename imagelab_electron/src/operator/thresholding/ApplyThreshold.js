const OpenCvOperator = require("../OpenCvOperator");

  /**
   * This class contains the main logic to apply simple threshold
   * to an image
   */

  class ApplyThreshold extends OpenCvOperator {
    #maxvalue = 0;
    #threshold = 0;
    constructor(type, id) {
          super(type, id);
    }

    setParams(type, value) { 
     if (type === "maxValue") {
        this.#maxvalue = value;
     } else if (type === "thresholdValue") {
        this.#threshold = value;
     } 
    }


    /**
     *
     * @param {Mat} image
     * @returns
     *
     * This function processes simple threshold
     * to the mat image
     */
    compute(image) {
      const dst = new this.cv2.Mat();
      this.cv2.threshold(image, dst, this.#threshold, this.#maxvalue, this.cv2.THRESH_BINARY);
      return dst;
    }
  }

  module.exports = ApplyThreshold;
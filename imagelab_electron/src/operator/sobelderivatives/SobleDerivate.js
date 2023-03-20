const OpenCvOperator = require("../OpenCvOperator");

  /**
   * This class contains the main logic to apply simple threshold
   * to an image
   */

  class SobleDerivate extends OpenCvOperator {
    #x = 0;
    #y = 1;
    #type = "HORIZONTAL"
    #ddepth = 0
    constructor(type, id) {
          super(type, id);
    }

    setParams(type, value) { 
     if (type === "type") {
        this.#type = value;
        if(value==="HORIZONTAL"){
            this.#x = 0;
            this.#y = 1;
        }
        else if(value==="VERTICAL"){
            this.#x = 1;
            this.#y = 0;
        }
     } else if (type === "ddepth") {
        this.#ddepth = value;
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
      this.cv2.Sobel(image, dst, this.#ddepth, this.#x, this.#y);
      return dst;
    }
  }

  module.exports = SobleDerivate;
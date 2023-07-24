const OpenCvOperator = require("../OpenCvOperator");

   /**
    * This class contains the main logic to apply adaptive threshold
    * to an image
    */

   class AdaptiveThreshold extends OpenCvOperator {
     #maxvalue = 0;
     constructor(type, id) {
           super(type, id);
     }

     setParams(type, value) { 
      if (type === "maxValue") {
         this.#maxvalue = value;
      } 
     }


     /**
      *
      * @param {Mat} image
      * @returns
      *
      * This function processes adaptive threshold
      * to the mat image
      */
     compute(image) {
       const dst = new this.cv2.Mat();
       this.cv2.cvtColor(image, image, this.cv2.COLOR_RGBA2GRAY, 0);
       this.cv2.adaptiveThreshold(image, dst, this.#maxvalue, this.cv2.ADAPTIVE_THRESH_GAUSSIAN_C, this.cv2.THRESH_BINARY, 3, 2);
       return dst;
     }
   }

   module.exports = AdaptiveThreshold;
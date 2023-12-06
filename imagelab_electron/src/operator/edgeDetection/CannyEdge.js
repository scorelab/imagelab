const OpenCvOperator = require("../OpenCvOperator");

 /**
  * This class contains the main logic to add Canny Edge
  * to an image
  */

 class CannyEdge extends OpenCvOperator {
   #aperture = 3;
   #minThreshold = 50;
   #maxThreshold = 100;
   constructor(type, id) {
         super(type, id);
   }

   setParams(type, value) { 
    if (type === "aperture") {
       this.#aperture = value;
    } else if (type === "minThreshold") {
       this.#minThreshold = value;
    } else if (type === "maxThreshold") {
       this.#maxThreshold = value;
    }
   }


   /**
    *
    * @param {Mat} image
    * @returns
    *
    * This function processes Canny Edge
    * to the mat image
    */
   compute(image) {
     const dst = new this.cv2.Mat();
     this.cv2.cvtColor(image, image, this.cv2.COLOR_RGB2GRAY, 0);
     this.cv2.Canny(image, dst, this.#minThreshold, this.#maxThreshold, this.#aperture, false);
     return dst;
   }
 }

 module.exports = CannyEdge;
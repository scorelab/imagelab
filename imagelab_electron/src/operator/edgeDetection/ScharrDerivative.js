const OpenCvOperator = require("../OpenCvOperator");

 /**
  * This class contains the main logic to add Scharr Derivative
  * to an image
  */

 class ScharrDerivative extends OpenCvOperator {
    #vertical = false;
   #ddepth = 0;
   constructor(type, id) {
         super(type, id);
   }

   setParams(type, value) {
     if (type === "type") {
        if(value === "VERTICAL") {
        this.#vertical=true;
       } else {
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
    * This function processes the Scharr Derivative
    * to the mat image
    */
   compute(image) {
     const dst = new this.cv2.Mat();
     this.cv2.cvtColor(image, image, this.cv2.COLOR_RGB2GRAY, 0);
     if(this.#vertical) {
        this.cv2.Scharr(image, dst, this.#ddepth, 0, 1, 1, 0, this.cv2.BORDER_DEFAULT);
     } else {
        this.cv2.Scharr(image, dst, this.#ddepth, 1, 0, 1, 0, this.cv2.BORDER_DEFAULT);
     }
     return dst;
   }
 }

 module.exports = ScharrDerivative;
const OpenCvOperator = require("../OpenCvOperator");

 /**
  * This class contains the main logic to add Soble Derivative
  * to an image
  */

 class SobleDerivative extends OpenCvOperator {
    #vertical = false;
    #horizontal = false;
   #ddepth = 0;
   constructor(type, id) {
         super(type, id);
   }

   setParams(type, value) {
     if (type === "type") {
       if(value === "HORIZONTAL") {
        this.#horizontal=true;
       } else if(value === "VERTICAL") {
        this.#vertical=true;
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
    * This function processes the Soble Derivative
    * to the mat image
    */
    
   compute(image) {
     const dst = new this.cv2.Mat();
     this.cv2.cvtColor(image, image, this.cv2.COLOR_RGB2GRAY, 0);
     if(this.#horizontal) {
        this.cv2.Sobel(image, dst, this.#ddepth, 1, 0, 3, 1, 0, this.cv2.BORDER_DEFAULT);
     } else if(this.#vertical) {
        this.cv2.Sobel(image, dst, this.#ddepth, 0, 1, 3, 1, 0, this.cv2.BORDER_DEFAULT);
     } else {
        this.cv2.Sobel(image, dst, this.#ddepth, 1, 0, 3, 1, 0, this.cv2.BORDER_DEFAULT);
        this.cv2.Sobel(image, dst, this.#ddepth, 0, 1, 3, 1, 0, this.cv2.BORDER_DEFAULT);
     }
     return dst;
   }
 }

 module.exports = SobleDerivative;
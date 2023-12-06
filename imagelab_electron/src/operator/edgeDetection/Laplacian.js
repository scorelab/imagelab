const OpenCvOperator = require("../OpenCvOperator");

 /**
  * This class contains the main logic to add Laplacian
  * to an image
  */

 class Laplacian extends OpenCvOperator {
   #ddepth = 0;
   constructor(type, id) {
         super(type, id);
   }

   setParams(type, value) { 
    if (type === "ddepth") {
       this.#ddepth = value;
     } 
   }


   /**
    *
    * @param {Mat} image
    * @returns
    *
    * This function processes Laplacian
    * to the mat image
    */
   compute(image) {
     const dst = new this.cv2.Mat();
     this.cv2.cvtColor(image, image, this.cv2.COLOR_RGB2GRAY, 0);
     this.cv2.Laplacian(image, dst, this.#ddepth, 3, 1, 0, this.cv2.BORDER_DEFAULT);
     return dst;
   }
 }

 module.exports = Laplacian;
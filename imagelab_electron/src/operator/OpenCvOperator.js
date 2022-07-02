const cv2 = require("../opencv");

/**
 * Super class for the opencv operators
 * This contains the opencv entry point
 */
class OpenCvOperator {
  type = "";
  constructor(type) {
    this.cv2 = cv2;
    this.type = type;
  }

  /**
   *
   * @param {Params needed to compute the output} params
   */
  compute(params) {
    throw Error("This method needs to be implemented in sub classes");
  }
}

module.exports = OpenCvOperator;

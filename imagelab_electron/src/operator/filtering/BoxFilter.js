const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main
 * logic of adding boxfilter to an image
 */
class BoxFilter extends OpenCvOperator {
  #depth = 5;
  #height = 50;
  #width = 50;
  #pointX = -1;
  #pointY = -1;
  constructor(type, id) {
    super(type, id);
  }

  setParams(param, value) {
    if (param === "width") {
      this.#width = value;
    } else if (param === "height") {
      this.#height = value;
    } else if (param === "depth") {
      this.#depth = value;
    } else if (param === "point_x") {
      this.#pointX = value;
    } else if (param === "point_y") {
      this.#pointY = value;
    }
  }

  compute(image) {
    let dst = new this.cv2.Mat();
    let point = new this.cv2.Point(this.#pointX, this.#pointY);
    let size = new this.cv2.Size(this.#height, this.#width);
    this.cv2.boxFilter(
      image,
      dst,
      this.#depth,
      size,
      point,
      true,
      this.cv2.BORDER_DEFAULT
    );
    return dst;
  }
}

module.exports = BoxFilter;

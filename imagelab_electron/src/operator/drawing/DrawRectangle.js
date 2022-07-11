const { hexToRgb } = require("../../helpers/convertColor");
const OpenCvOperator = require("../OpenCvOperator");

class DrawRectangle extends OpenCvOperator {
  #startPointX = 0;
  #startPointY = 0;
  #endPointX = 100;
  #endPointY = 100;
  #rectangleColor = { r: 40, g: 40, b: 240 };
  #thickness = 2;

  constructor(type) {
    super(type);
  }

  setParams(param, value) {
    if (param === "thickness") {
      this.#thickness = value;
    } else if (param === "rgbcolors_input") {
      this.#rectangleColor = hexToRgb(value);
    } else if (param === "starting_point_x") {
      this.#startPointX = value;
    } else if (param === "starting_point_y") {
      this.#startPointY = value;
    } else if (param === "ending_point_x") {
      this.#endPointX = value;
    } else if (param === "ending_point_y") {
      this.#endPointY = value;
    }
  }

  compute(image) {
    let p1 = new this.cv2.Point(this.#startPointX, this.#startPointY);
    let p2 = new this.cv2.Point(this.#endPointX, this.#endPointY);
    image = this.cv2.rectangle(
      image,
      p1,
      p2,
      [
        this.#rectangleColor.r,
        this.#rectangleColor.g,
        this.#rectangleColor.b,
        255,
      ],
      this.#thickness
    );
    return image;
  }
}

module.exports = DrawRectangle;

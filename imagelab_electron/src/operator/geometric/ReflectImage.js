const OpenCvOperator = require("../OpenCvOperator");

class ReflectImage extends OpenCvOperator {
  #direction = "X";
  constructor() {
    super();
  }

  setParams(type, value) {
    this.#direction = value;
  }

  compute(image) {
    // const dst = new this.cv2.Mat();
    // const mapX = new this.cv2.Mat(image.size(), this.cv2.CV_32F);
    // const mapY = new this.cv2.Mat(image.size(), this.cv2.CV_32F);
    // const bufferX = [int(mapX.total() * mapX.channels())];
    // mapX.get(0, 0, bufferX);
    // const bufferY = [int(mapY.total() * mapY.channels())];
    // mapY.get(0, 0, bufferY);
    // for (let i = 0; i < mapX.rows(); i++) {
    //   for (let j = 0; j < mapX.cols(); j++) {
    //     buffX[i * mapX.cols() + j] = j;
    //     buffY[i * mapY.cols() + j] = mapY.rows() - i;
    //   }
    // }
    // mapX.put(0, 0, buffX);
    // mapY.put(0, 0, buffY);
    return image;
  }
}

module.exports = ReflectImage;

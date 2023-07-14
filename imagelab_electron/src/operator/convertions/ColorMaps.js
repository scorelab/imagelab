const OpenCvOperator = require("../OpenCvOperator");

/**
 * This class contains the main logic to apply simple threshold
 * to an image
 */

class ColorMaps extends OpenCvOperator {
    #type = "HOT"
    constructor(type, id) {
        super(type, id);
    }

    setParams(type, value) {
        if (type === "type") {
            this.#type = value;
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
        switch (this.#type) {
            case "AUTUMN":
                this.cv2.applyColorMap(image, dst, this.cv2.COLORMAP_AUTUMN)
                break;
            case "HOT":
                this.cv2.applyColorMap(image, dst, this.cv2.COLORMAP_HOT);
                break;
            case "BONE":
                this.cv2.applyColorMap(image, dst, this.cv2.COLORMAP_BONE);
                break;
            case "COOL":
                this.cv2.applyColorMap(image, dst, this.cv2.COLORMAP_COOL);
                break;
            case "HSV":
                this.cv2.applyColorMap(image, dst, this.cv2.COLORMAP_HSV);
                break;
            case "JET":
                this.cv2.applyColorMap(image, dst, this.cv2.COLORMAP_JET);
                break;
            case "OCEAN":
                this.cv2.applyColorMap(image, dst, this.cv2.COLORMAP_OCEAN);
                break;
            case "PARULA":
                this.cv2.applyColorMap(image, dst, this.cv2.COLORMAP_PARULA);
                break;
            case "PINK":
                this.cv2.applyColorMap(image, dst, this.cv2.COLORMAP_PINK);
                break;
            case "RAINBOW":
                this.cv2.applyColorMap(image, dst, this.cv2.COLORMAP_RAINBOW);
                break;
        }
        return dst;
    }
}

module.exports = ColorMaps;
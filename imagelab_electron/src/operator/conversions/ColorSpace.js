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
            case "RGB2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_RGB2RGBA)
            break;
            case "BGRA2BGR":
                this.cv2.cvtColor(image,dst,COLOR_BGRA2BGR)
            break;
            case "RGBA2RGB":
                this.cv2.cvtColor(image,dst,COLOR_RGBA2RGB)
            break;
            case "BGR2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BGR2RGBA)
            break;
            case "RGB2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_RGB2BGRA)
            break;
            case "RGBA2BGR":
                this.cv2.cvtColor(image,dst,COLOR_RGBA2BGR)
            break;
            case "BGRA2RGB":
                this.cv2.cvtColor(image,dst,COLOR_BGRA2RGB)
            break;
            case "BGR2RGB":
                this.cv2.cvtColor(image,dst,COLOR_BGR2RGB)
            break;
            case "RGB2BGR":
                this.cv2.cvtColor(image,dst,COLOR_RGB2BGR)
            break;
            case "BGRA2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BGRA2RGBA)
            break;
            case "RGBA2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_RGBA2BGRA)
            break;
            case "BGR2GRAY":
                this.cv2.cvtColor(image,dst,COLOR_BGR2GRAY)
            break;
            case "RGB2GRAY":
                this.cv2.cvtColor(image,dst,COLOR_RGB2GRAY)
            break;
            case "GRAY2BGR":
                this.cv2.cvtColor(image,dst,COLOR_GRAY2BGR)
            break;
            case "GRAY2RGB":
                this.cv2.cvtColor(image,dst,COLOR_GRAY2RGB)
            break;
            case "GRAY2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_GRAY2BGRA)
            break;
            case "GRAY2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_GRAY2RGBA)
            break;
            case "BGRA2GRAY":
                this.cv2.cvtColor(image,dst,COLOR_BGRA2GRAY)
            break;
            case "RGBA2GRAY":
                this.cv2.cvtColor(image,dst,COLOR_RGBA2GRAY)
            break;
            case "BGR2BGR565":
                this.cv2.cvtColor(image,dst,COLOR_BGR2BGR565)
            break;
            case "RGB2BGR565":
                this.cv2.cvtColor(image,dst,COLOR_RGB2BGR565)
            break;
            case "BGR5652BGR":
                this.cv2.cvtColor(image,dst,COLOR_BGR5652BGR)
            break;
            case "BGR5652RGB":
                this.cv2.cvtColor(image,dst,COLOR_BGR5652RGB)
            break;
            case "BGRA2BGR565":
                this.cv2.cvtColor(image,dst,COLOR_BGRA2BGR565)
            break;
            case "RGBA2BGR565":
                this.cv2.cvtColor(image,dst,COLOR_RGBA2BGR565)
            break;
            case "BGR5652BGRA":
                this.cv2.cvtColor(image,dst,COLOR_BGR5652BGRA)
            break;
            case "BGR5652RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BGR5652RGBA)
            break;
            case "GRAY2BGR565":
                this.cv2.cvtColor(image,dst,COLOR_GRAY2BGR565)
            break;
            case "BGR5652GRAY":
                this.cv2.cvtColor(image,dst,COLOR_BGR5652GRAY)
            break;
            case "BGR2BGR555":
                this.cv2.cvtColor(image,dst,COLOR_BGR2BGR555)
            break;
            case "RGB2BGR555":
                this.cv2.cvtColor(image,dst,COLOR_RGB2BGR555)
            break;
            case "BGR5552BGR":
                this.cv2.cvtColor(image,dst,COLOR_BGR5552BGR)
            break;
            case "BGR5552RGB":
                this.cv2.cvtColor(image,dst,COLOR_BGR5552RGB)
            break;
            case "BGRA2BGR555":
                this.cv2.cvtColor(image,dst,COLOR_BGRA2BGR555)
            break;
            case "RGBA2BGR555":
                this.cv2.cvtColor(image,dst,COLOR_RGBA2BGR555)
            break;
            case "BGR5552BGRA":
                this.cv2.cvtColor(image,dst,COLOR_BGR5552BGRA)
            break;
            case "BGR5552RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BGR5552RGBA)
            break;
            case "GRAY2BGR555":
                this.cv2.cvtColor(image,dst,COLOR_GRAY2BGR555)
            break;
            case "BGR5552GRAY":
                this.cv2.cvtColor(image,dst,COLOR_BGR5552GRAY)
            break;
            case "BGR2XYZ":
                this.cv2.cvtColor(image,dst,COLOR_BGR2XYZ)
            break;
            case "RGB2XYZ":
                this.cv2.cvtColor(image,dst,COLOR_RGB2XYZ)
            break;
            case "XYZ2BGR":
                this.cv2.cvtColor(image,dst,COLOR_XYZ2BGR)
            break;
            case "XYZ2RGB":
                this.cv2.cvtColor(image,dst,COLOR_XYZ2RGB)
            break;
            case "BGR2YCrCb":
                this.cv2.cvtColor(image,dst,COLOR_BGR2YCrCb)
            break;
            case "RGB2YCrCb":
                this.cv2.cvtColor(image,dst,COLOR_RGB2YCrCb)
            break;
            case "YCrCb2BGR":
                this.cv2.cvtColor(image,dst,COLOR_YCrCb2BGR)
            break;
            case "YCrCb2RGB":
                this.cv2.cvtColor(image,dst,COLOR_YCrCb2RGB)
            break;
            case "BGR2HSV":
                this.cv2.cvtColor(image,dst,COLOR_BGR2HSV)
            break;
            case "RGB2HSV":
                this.cv2.cvtColor(image,dst,COLOR_RGB2HSV)
            break;
            case "BGR2Lab":
                this.cv2.cvtColor(image,dst,COLOR_BGR2Lab)
            break;
            case "RGB2Lab":
                this.cv2.cvtColor(image,dst,COLOR_RGB2Lab)
            break;
            case "BGR2Luv":
                this.cv2.cvtColor(image,dst,COLOR_BGR2Luv)
            break;
            case "RGB2Luv":
                this.cv2.cvtColor(image,dst,COLOR_RGB2Luv)
            break;
            case "BGR2HLS":
                this.cv2.cvtColor(image,dst,COLOR_BGR2HLS)
            break;
            case "RGB2HLS":
                this.cv2.cvtColor(image,dst,COLOR_RGB2HLS)
            break;
            case "HSV2BGR":
                this.cv2.cvtColor(image,dst,COLOR_HSV2BGR)
            break;
            case "HSV2RGB":
                this.cv2.cvtColor(image,dst,COLOR_HSV2RGB)
            break;
            case "Lab2BGR":
                this.cv2.cvtColor(image,dst,COLOR_Lab2BGR)
            break;
            case "Lab2RGB":
                this.cv2.cvtColor(image,dst,COLOR_Lab2RGB)
            break;
            case "Luv2BGR":
                this.cv2.cvtColor(image,dst,COLOR_Luv2BGR)
            break;
            case "Luv2RGB":
                this.cv2.cvtColor(image,dst,COLOR_Luv2RGB)
            break;
            case "HLS2BGR":
                this.cv2.cvtColor(image,dst,COLOR_HLS2BGR)
            break;
            case "HLS2RGB":
                this.cv2.cvtColor(image,dst,COLOR_HLS2RGB)
            break;
            case "BGR2HSV_FULL":
                this.cv2.cvtColor(image,dst,COLOR_BGR2HSV_FULL)
            break;
            case "RGB2HSV_FULL":
                this.cv2.cvtColor(image,dst,COLOR_RGB2HSV_FULL)
            break;
            case "BGR2HLS_FULL":
                this.cv2.cvtColor(image,dst,COLOR_BGR2HLS_FULL)
            break;
            case "RGB2HLS_FULL":
                this.cv2.cvtColor(image,dst,COLOR_RGB2HLS_FULL)
            break;
            case "HSV2BGR_FULL":
                this.cv2.cvtColor(image,dst,COLOR_HSV2BGR_FULL)
            break;
            case "HSV2RGB_FULL":
                this.cv2.cvtColor(image,dst,COLOR_HSV2RGB_FULL)
            break;
            case "HLS2BGR_FULL":
                this.cv2.cvtColor(image,dst,COLOR_HLS2BGR_FULL)
            break;
            case "HLS2RGB_FULL":
                this.cv2.cvtColor(image,dst,COLOR_HLS2RGB_FULL)
            break;
            case "LBGR2Lab":
                this.cv2.cvtColor(image,dst,COLOR_LBGR2Lab)
            break;
            case "LRGB2Lab":
                this.cv2.cvtColor(image,dst,COLOR_LRGB2Lab)
            break;
            case "LBGR2Luv":
                this.cv2.cvtColor(image,dst,COLOR_LBGR2Luv)
            break;
            case "LRGB2Luv":
                this.cv2.cvtColor(image,dst,COLOR_LRGB2Luv)
            break;
            case "Lab2LBGR":
                this.cv2.cvtColor(image,dst,COLOR_Lab2LBGR)
            break;
            case "Lab2LRGB":
                this.cv2.cvtColor(image,dst,COLOR_Lab2LRGB)
            break;
            case "Luv2LBGR":
                this.cv2.cvtColor(image,dst,COLOR_Luv2LBGR)
            break;
            case "Luv2LRGB":
                this.cv2.cvtColor(image,dst,COLOR_Luv2LRGB)
            break;
            case "BGR2YUV":
                this.cv2.cvtColor(image,dst,COLOR_BGR2YUV)
            break;
            case "RGB2YUV":
                this.cv2.cvtColor(image,dst,COLOR_RGB2YUV)
            break;
            case "YUV2BGR":
                this.cv2.cvtColor(image,dst,COLOR_YUV2BGR)
            break;
            case "YUV2RGB":
                this.cv2.cvtColor(image,dst,COLOR_YUV2RGB)
            break;
            case "YUV2RGB_NV12":
                this.cv2.cvtColor(image,dst,COLOR_YUV2RGB_NV12)
            break;
            case "YUV2BGR_NV12":
                this.cv2.cvtColor(image,dst,COLOR_YUV2BGR_NV12)
            break;
            case "YUV2RGB_NV21":
                this.cv2.cvtColor(image,dst,COLOR_YUV2RGB_NV21)
            break;
            case "YUV2BGR_NV21":
                this.cv2.cvtColor(image,dst,COLOR_YUV2BGR_NV21)
            break;
            case "YUV420sp2RGB":
                this.cv2.cvtColor(image,dst,COLOR_YUV420sp2RGB)
            break;
            case "YUV420sp2BGR":
                this.cv2.cvtColor(image,dst,COLOR_YUV420sp2BGR)
            break;
            case "YUV2RGBA_NV12":
                this.cv2.cvtColor(image,dst,COLOR_YUV2RGBA_NV12)
            break;
            case "YUV2BGRA_NV12":
                this.cv2.cvtColor(image,dst,COLOR_YUV2BGRA_NV12)
            break;
            case "YUV2RGBA_NV21":
                this.cv2.cvtColor(image,dst,COLOR_YUV2RGBA_NV21)
            break;
            case "YUV2BGRA_NV21":
                this.cv2.cvtColor(image,dst,COLOR_YUV2BGRA_NV21)
            break;
            case "YUV420sp2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_YUV420sp2RGBA)
            break;
            case "YUV420sp2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_YUV420sp2BGRA)
            break;
            case "YUV2RGB_YV12":
                this.cv2.cvtColor(image,dst,COLOR_YUV2RGB_YV12)
            break;
            case "YUV2BGR_YV12":
                this.cv2.cvtColor(image,dst,COLOR_YUV2BGR_YV12)
            break;
            case "YUV2RGB_IYUV":
                this.cv2.cvtColor(image,dst,COLOR_YUV2RGB_IYUV)
            break;
            case "YUV2BGR_IYUV":
                this.cv2.cvtColor(image,dst,COLOR_YUV2BGR_IYUV)
            break;
            case "YUV2RGB_I420":
                this.cv2.cvtColor(image,dst,COLOR_YUV2RGB_I420)
            break;
            case "YUV2BGR_I420":
                this.cv2.cvtColor(image,dst,COLOR_YUV2BGR_I420)
            break;
            case "YUV420p2RGB":
                this.cv2.cvtColor(image,dst,COLOR_YUV420p2RGB)
            break;
            case "YUV420p2BGR":
                this.cv2.cvtColor(image,dst,COLOR_YUV420p2BGR)
            break;
            case "RGBA2mRGBA":
                this.cv2.cvtColor(image,dst,COLOR_RGBA2mRGBA)
            break;
            case "mRGBA2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_mRGBA2RGBA)
            break;
            case "BayerBG2BGR":
                this.cv2.cvtColor(image,dst,COLOR_BayerBG2BGR)
            break;
            case "BayerGB2BGR":
                this.cv2.cvtColor(image,dst,COLOR_BayerGB2BGR)
            break;
            case "BayerRG2BGR":
                this.cv2.cvtColor(image,dst,COLOR_BayerRG2BGR)
            break;
            case "BayerGR2BGR":
                this.cv2.cvtColor(image,dst,COLOR_BayerGR2BGR)
            break;
            case "BayerRGGB2BGR":
                this.cv2.cvtColor(image,dst,COLOR_BayerRGGB2BGR)
            break;
            case "BayerGRBG2BGR":
                this.cv2.cvtColor(image,dst,COLOR_BayerGRBG2BGR)
            break;
            case "BayerBGGR2BGR":
                this.cv2.cvtColor(image,dst,COLOR_BayerBGGR2BGR)
            break;
            case "BayerGBRG2BGR":
                this.cv2.cvtColor(image,dst,COLOR_BayerGBRG2BGR)
            break;
            case "BayerRGGB2RGB":
                this.cv2.cvtColor(image,dst,COLOR_BayerRGGB2RGB)
            break;
            case "BayerGRBG2RGB":
                this.cv2.cvtColor(image,dst,COLOR_BayerGRBG2RGB)
            break;
            case "BayerBGGR2RGB":
                this.cv2.cvtColor(image,dst,COLOR_BayerBGGR2RGB)
            break;
            case "BayerGBRG2RGB":
                this.cv2.cvtColor(image,dst,COLOR_BayerGBRG2RGB)
            break;
            case "BayerBG2RGB":
                this.cv2.cvtColor(image,dst,COLOR_BayerBG2RGB)
            break;
            case "BayerGB2RGB":
                this.cv2.cvtColor(image,dst,COLOR_BayerGB2RGB)
            break;
            case "BayerGB2RGB_VNG":
                this.cv2.cvtColor(image,dst,COLOR_BayerGB2RGB_VNG)
            break;
            case "BayerRG2RGB_VNG":
                this.cv2.cvtColor(image,dst,COLOR_BayerRG2RGB_VNG)
            break;
            case "BayerGR2RGB_VNG":
                this.cv2.cvtColor(image,dst,COLOR_BayerGR2RGB_VNG)
            break;
            case "BayerBG2BGR_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerBG2BGR_EA)
            break;
            case "BayerGB2BGR_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGB2BGR_EA)
            break;
            case "BayerRG2BGR_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerRG2BGR_EA)
            break;
            case "BayerGR2BGR_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGR2BGR_EA)
            break;
            case "BayerRGGB2BGR_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerRGGB2BGR_EA)
            break;
            case "BayerGRBG2BGR_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGRBG2BGR_EA)
            break;
            case "BayerBGGR2BGR_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerBGGR2BGR_EA)
            break;
            case "BayerGBRG2BGR_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGBRG2BGR_EA)
            break;
            case "BayerRGGB2RGB_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerRGGB2RGB_EA)
            break;
            case "BayerGRBG2RGB_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGRBG2RGB_EA)
            break;
            case "BayerBGGR2RGB_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerBGGR2RGB_EA)
            break;
            case "BayerGBRG2RGB_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGBRG2RGB_EA)
            break;
            case "BayerBG2RGB_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerBG2RGB_EA)
            break;
            case "BayerGB2RGB_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGB2RGB_EA)
            break;
            case "BayerRG2RGB_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerRG2RGB_EA)
            break;
            case "BayerGR2RGB_EA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGR2RGB_EA)
            break;
            case "BayerBG2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_BayerBG2BGRA)
            break;
            case "BayerGB2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGB2BGRA)
            break;
            case "BayerRG2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_BayerRG2BGRA)
            break;
            case "BayerGR2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGR2BGRA)
            break;
            case "BayerRGGB2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_BayerRGGB2BGRA)
            break;
            case "BayerGRBG2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGRBG2BGRA)
            break;
            case "BayerBGGR2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_BayerBGGR2BGRA)
            break;
            case "BayerGBRG2BGRA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGBRG2BGRA)
            break;
            case "BayerRGGB2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BayerRGGB2RGBA)
            break;
            case "BayerGRBG2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGRBG2RGBA)
            break;
            case "BayerBGGR2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BayerBGGR2RGBA)
            break;
            case "BayerGBRG2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGBRG2RGBA)
            break;
            case "BayerBG2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BayerBG2RGBA)
            break;
            case "BayerGB2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGB2RGBA)
            break;
            case "BayerRG2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BayerRG2RGBA)
            break;
            case "BayerGR2RGBA":
                this.cv2.cvtColor(image,dst,COLOR_BayerGR2RGBA)
            break;
            case "COLOR_CVT_MAX":
                this.cv2.cvtColor(image,dst,COLOR_)
            break;
        }
        return dst;
    }
}

module.exports = ColorSpace;
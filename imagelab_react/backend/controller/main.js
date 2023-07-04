const PROCESS_OPERATIONS = require("../operations");
const ReadImage = require("../operator/basic/ReadImage");
const WriteImage = require("../operator/basic/WriteImage");
const GrayImage = require("../operator/convertions/GrayImage");
const GrayToBinary = require("../operator/convertions/GrayToBinary");
const Blur = require("../operator/blurring/Blur");
const GaussianBlur = require("../operator/blurring/GaussianBlur");
const MedianBlur = require("../operator/blurring/MedianBlur");
const DrawArrowLine = require("../operator/drawing/DrawArrowLine");
const DrawCircle = require("../operator/drawing/DrawCircle");
const DrawEllipse = require("../operator/drawing/DrawEllipse");
const DrawLine = require("../operator/drawing/DrawLine");
const DrawRectangle = require("../operator/drawing/DrawRectangle");
const DrawText = require("../operator/drawing/DrawText");
const BilateralFilter = require("../operator/filtering/BilateralFilter");
const BoxFilter = require("../operator/filtering/BoxFilter");
const Dilation = require("../operator/filtering/Dilation");
const Erosion = require("../operator/filtering/Erosion");
const Morphological = require("../operator/filtering/Morphological");
const PyramidDown = require("../operator/filtering/PyramidDown");
const PyramidUp = require("../operator/filtering/PyramidUp");
const AffineImage = require("../operator/geometric/AffineImage");
const ReflectImage = require("../operator/geometric/ReflectImage");
const RotateImage = require("../operator/geometric/RotateImage");
const ScaleImage = require("../operator/geometric/ScaleImage");
const Jimp = require('jimp');

class MainController {
  // This private field is used to store the applied operators in the workspace
  #appliedOperators;

  // This holds the original image added by the user
  #originalImage;

  //Instead of directly exporting the image, the processed image is stored
  #processedImage;

  constructor() {
    this.#appliedOperators = [];
    this.#originalImage = null;
    this.#processedImage = null;
  }

  /**
   * This method set the original image
   * @param {Mat Image} image
   */
  setOriginalImage(image) {
    this.#originalImage = image;
  }

  /**
   * This methods returns the original image
   * @returns Image
   */
  getOriginalImage() {
    return this.#originalImage;
  }

  /**
   * 
   */
  async getProcessedImage() {
    const base64Image = await this.#processedImage.getBase64Async(Jimp.MIME_PNG);
    return base64Image;
  }

  /**
   * This function generates the operator object accroding to the string passed
   * @param {String} operatorType
   * @returns
   */
  addOperators(pipeline) {
    this.#appliedOperators = [];
    pipeline.forEach((block) => {
      const operatorType = block.type;
      const id = block.id;
      switch (operatorType) {
        case PROCESS_OPERATIONS.READIMAGE:
          this.#appliedOperators.push(
            new ReadImage(PROCESS_OPERATIONS.READIMAGE, id)
          );
          break;
        case PROCESS_OPERATIONS.WRITEIMAGE:
          this.#appliedOperators.push(
            new WriteImage(PROCESS_OPERATIONS.WRITEIMAGE, id)
          );
          break;
        case PROCESS_OPERATIONS.GRAYIMAGE:
          this.#appliedOperators.push(
            new GrayImage(PROCESS_OPERATIONS.GRAYIMAGE, id)
          );
          break;
        case PROCESS_OPERATIONS.GRAYTOBINARY:
          this.#appliedOperators.push(
            new GrayToBinary(PROCESS_OPERATIONS.GRAYTOBINARY, id)
          );
          break;
        case PROCESS_OPERATIONS.REFLECTIMAGE:
          this.#appliedOperators.push(
            new ReflectImage(PROCESS_OPERATIONS.REFLECTIMAGE, id)
          );
          break;
        case PROCESS_OPERATIONS.ROTATEIMAGE:
          this.#appliedOperators.push(
            new RotateImage(PROCESS_OPERATIONS.ROTATEIMAGE, id)
          );
          break;
        case PROCESS_OPERATIONS.AFFINEIMAGE:
          this.#appliedOperators.push(
            new AffineImage(PROCESS_OPERATIONS.AFFINEIMAGE, id)
          );
          break;
        case PROCESS_OPERATIONS.SCALEIMAGE:
          this.#appliedOperators.push(
            new ScaleImage(PROCESS_OPERATIONS.SCALEIMAGE, id)
          );
          break;
        case PROCESS_OPERATIONS.DRAWLINE:
          this.#appliedOperators.push(
            new DrawLine(PROCESS_OPERATIONS.DRAWLINE, id)
          );
          break;
        case PROCESS_OPERATIONS.DRAWELLIPSE:
          this.#appliedOperators.push(
            new DrawEllipse(PROCESS_OPERATIONS.DRAWELLIPSE, id)
          );
          break;
        case PROCESS_OPERATIONS.DRAWARROWLINE:
          this.#appliedOperators.push(
            new DrawArrowLine(PROCESS_OPERATIONS.DRAWARROWLINE, id)
          );
          break;
        case PROCESS_OPERATIONS.DRAWTEXT:
          this.#appliedOperators.push(
            new DrawText(PROCESS_OPERATIONS.DRAWTEXT, id)
          );
          break;
        case PROCESS_OPERATIONS.DRAWCIRCLE:
          this.#appliedOperators.push(
            new DrawCircle(PROCESS_OPERATIONS.DRAWCIRCLE, id)
          );
          break;
        case PROCESS_OPERATIONS.DRAWRECTANGLE:
          this.#appliedOperators.push(
            new DrawRectangle(PROCESS_OPERATIONS.DRAWRECTANGLE, id)
          );
          break;
        case PROCESS_OPERATIONS.BLURIMAGE:
          this.#appliedOperators.push(new Blur(PROCESS_OPERATIONS.BLURIMAGE, id));
          break;
        case PROCESS_OPERATIONS.GAUSSIANBLUR:
          this.#appliedOperators.push(
            new GaussianBlur(PROCESS_OPERATIONS.GAUSSIANBLUR, id)
          );
          break;
        case PROCESS_OPERATIONS.MEDIANBLUR:
          this.#appliedOperators.push(
            new MedianBlur(PROCESS_OPERATIONS.MEDIANBLUR, id)
          );
          break;
        case PROCESS_OPERATIONS.BILATERALFILTER:
          this.#appliedOperators.push(
            new BilateralFilter(PROCESS_OPERATIONS.BILATERALFILTER, id)
          );
          break;
        case PROCESS_OPERATIONS.BOXFILTER:
          this.#appliedOperators.push(
            new BoxFilter(PROCESS_OPERATIONS.BOXFILTER, id)
          );
          break;
        case PROCESS_OPERATIONS.PYRAMIDUP:
          this.#appliedOperators.push(
            new PyramidUp(PROCESS_OPERATIONS.PYRAMIDUP, id)
          );
          break;
        case PROCESS_OPERATIONS.PYRAMIDDOWN:
          this.#appliedOperators.push(
            new PyramidDown(PROCESS_OPERATIONS.PYRAMIDDOWN, id)
          );
          break;
        case PROCESS_OPERATIONS.EROSION:
          this.#appliedOperators.push(
            new Erosion(PROCESS_OPERATIONS.EROSION, id)
          );
          break;
        case PROCESS_OPERATIONS.DILATION:
          this.#appliedOperators.push(
            new Dilation(PROCESS_OPERATIONS.DILATION, id)
          );
          break;
        case PROCESS_OPERATIONS.MORPHOLOGICAL:
          this.#appliedOperators.push(
            new Morphological(PROCESS_OPERATIONS.MORPHOLOGICAL, id)
          );
          break;
        default:
          break;
      }
      const operator = this.#appliedOperators[this.#appliedOperators.length - 1];
      block.params.forEach((param) => {
        if(param.type != undefined && operator.setParams) {
          operator.setParams(param.type, param.value);
        }
      })
    });
  }

  /**
   * This method compute and generate the output of the selected operators
   */
  async computeAll(buffer) {
    if (this.#appliedOperators.length === 0) {
      throw Error("No operators are added to the workspace");
    }
    if (this.#appliedOperators[0]?.type !== PROCESS_OPERATIONS.READIMAGE) {
      throw Error("Read Image block is not added");
    }
    const jimpSrc = await Jimp.read(buffer);
    var image = jimpSrc.bitmap;

    this.#appliedOperators.forEach((item) => {
      if (image) {
        image = item.compute(image);
        if(image) {
          this.#processedImage = image;
        }
      }
    });
  }
}

module.exports = MainController;

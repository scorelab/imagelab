const PROCESS_OPERATIONS = require("../../operations");
const ReadImage = require("../operator/basic/ReadImage");
const WriteImage = require("../operator/basic/WriteImage");
const AffineImage = require("../operator/geometric/AffineImage");
const ReflectImage = require("../operator/geometric/ReflectImage");
const RotateImage = require("../operator/geometric/RotateImage");
const ScaleImage = require("../operator/geometric/ScaleImage");

class MainController {
  // This private field is used to store the applied operators in the workspace
  #appliedOperators;

  // This holds the original image added by the user
  #originalImage;

  // This holds the proccessed image by the opencv operators
  #processedImage;

  constructor() {
    this.#appliedOperators = [];
    this.#originalImage = null;
    this.#processedImage = null;
  }

  /**
   * This function is responsible for making the blocks in order
   * according to the order in the workspace
   * @param {String} parent
   * @param {String} child
   * @returns none
   */
  arrangeBlocks(parent, child) {
    const parentIndex = this.#appliedOperators.findIndex(
      (item) => item.type === parent
    );
    const childIndex = this.#appliedOperators.findIndex(
      (item) => item.type === child
    );

    // If the parent is not found then the index will be -1
    // If the child is not found then the index will be -1
    if (parentIndex === -1 || childIndex === -1) {
      return;
    }

    // If the child is next to the parent then we do need to done anything
    if (parentIndex + 1 === childIndex) {
      return;
    }

    const childElement = this.#appliedOperators[childIndex];
    this.#appliedOperators.splice(childIndex, 1);
    this.#appliedOperators.splice(parentIndex + 1, 0, childElement);
  }

  /**
   * This method set the original image
   * @param {Image} image
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
   * This private method returns an object which consits of selected
   * opencv operator and its string type
   * @param {Object of selected operator} operator
   * @param {String type of the selected operator} type
   * @returns
   */
  #generateOperator(operator, type) {
    return {
      operator,
      type,
    };
  }

  /**
   * This function generates the operator object accroding to the string passed
   * @param {String name of the operator type} operatorType
   * @returns
   */
  addOperator(operatorType) {
    switch (operatorType) {
      case PROCESS_OPERATIONS.READIMAGE:
        this.#appliedOperators.push(
          this.#generateOperator(new ReadImage(), PROCESS_OPERATIONS.READIMAGE)
        );
        break;
      case PROCESS_OPERATIONS.WRITEIMAGE:
        this.#appliedOperators.push(
          this.#generateOperator(
            new WriteImage(),
            PROCESS_OPERATIONS.WRITEIMAGE
          )
        );
        break;
      case PROCESS_OPERATIONS.REFLECTIMAGE:
        this.#appliedOperators.push(
          this.#generateOperator(
            new ReflectImage(),
            PROCESS_OPERATIONS.REFLECTIMAGE
          )
        );
        break;
      case PROCESS_OPERATIONS.ROTATEIMAGE:
        this.#appliedOperators.push(
          this.#generateOperator(
            new RotateImage(),
            PROCESS_OPERATIONS.ROTATEIMAGE
          )
        );
        break;
      case PROCESS_OPERATIONS.AFFINEIMAGE:
        this.#appliedOperators.push(
          this.#generateOperator(
            new AffineImage(),
            PROCESS_OPERATIONS.AFFINEIMAGE
          )
        );
        break;
      case PROCESS_OPERATIONS.SCALEIMAGE:
        this.#appliedOperators.push(
          this.#generateOperator(
            new ScaleImage(),
            PROCESS_OPERATIONS.SCALEIMAGE
          )
        );
        break;
      default:
        break;
    }
  }

  /**
   * This method compute and generate the output of the selected operators
   */
  computeAll() {
    if (this.#appliedOperators.length === 0) {
      throw Error("No operators are added to the workspace");
    }

    if (this.#appliedOperators[0]?.type !== PROCESS_OPERATIONS.READIMAGE) {
      throw Error("Read Image block is not added");
    }

    if (this.#originalImage === null) {
      throw Error("Image is not set");
    }
    var image = this.#originalImage;
    this.#appliedOperators.forEach((item) => {
      if (image) {
        image = item.operator.compute(image);
        this.#processedImage = image;
      }
    });
  }

  changeValuesOfBlocks(blockType, paramType, value) {
    const block = this.#appliedOperators.find(
      (item) => item.type === blockType
    );
    if (block) {
      block.operator.setParams(paramType, value);
    }
  }
}

module.exports = MainController;

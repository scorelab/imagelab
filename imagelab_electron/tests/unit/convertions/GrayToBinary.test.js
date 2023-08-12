const GrayToBinary = require('../../../src/operator/convertions/GrayToBinary');
const opencvMock = require('../opencv-mocks/convertions.mocks');

describe('GrayToBinary Operator', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it('should process threshold function to convert gray image to binary', () => {
    const operator = new GrayToBinary('type', 'id');
    operator.cv2 = opencvMock.cv2; // Inject the cv2 mock

    // Set private variables using setParams
    operator.setParams('thresholdValue', 100);
    operator.setParams('maxValue', 255);

    const imageMock = 'mockImageData';

    operator.compute(imageMock);

    // Assertions
    expect(opencvMock.cv2.Mat).toHaveBeenCalledTimes(1);
    expect(opencvMock.cv2.threshold).toHaveBeenCalledWith(
      imageMock,
      {},
      100,
      255,
      'mockThreshBinary'
    );
  });
});

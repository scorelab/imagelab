const ApplyThreshold = require('../../../src/operator/thresholding/ApplyThreshold');
const opencvMock = require('../opencv-mocks/thresholding.mock');

describe('ApplyThreshold Operator', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it('should process threshold function with given parameters', () => {
    const operator = new ApplyThreshold('type', 'id');
    operator.cv2 = opencvMock.cv2;

    const imageMock = 'mockImageData';

    operator.setParams('maxValue', 255); // Set the max value for threshold
    operator.setParams('thresholdValue', 128); // Set the threshold value

    operator.compute(imageMock);

    expect(opencvMock.cv2.Mat).toHaveBeenCalledTimes(1);
    expect(opencvMock.cv2.threshold).toHaveBeenCalledWith(
      imageMock,
      {},
      128,
      255,
      opencvMock.cv2.THRESH_BINARY
    );
  });

  // Add more test cases as needed
});

const AdaptiveThreshold = require('../../../src/operator/thresholding/AdaptiveThresholding');
const opencvMock = require('../opencv-mocks/thresholding.mock');

describe('AdaptiveThreshold Operator', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it('should process adaptiveThreshold function with given parameters', () => {
    const operator = new AdaptiveThreshold('type', 'id');
    operator.cv2 = opencvMock.cv2;

    const imageMock = 'mockImageData';

    operator.setParams('maxValue', 255); // Set the max value for adaptive threshold

    operator.compute(imageMock);

    expect(opencvMock.cv2.Mat).toHaveBeenCalledTimes(1);
    expect(opencvMock.cv2.adaptiveThreshold).toHaveBeenCalledWith(
      imageMock,
      {},
      255,
      opencvMock.cv2.ADAPTIVE_THRESH_GAUSSIAN_C,
      opencvMock.cv2.THRESH_BINARY,
      3,
      2
    );
    expect(opencvMock.cv2.cvtColor).toHaveBeenCalledWith(
      imageMock,
      imageMock,
      opencvMock.cv2.COLOR_RGBA2GRAY,
      0
    );
  });
});

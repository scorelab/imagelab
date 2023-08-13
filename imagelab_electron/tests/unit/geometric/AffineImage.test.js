const AffineImage = require('../../../src/operator/geometric/AffineImage');
const opencvMock = require('../opencv-mocks/geometric.mock');

describe('AffineImage Operator', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it('should process warpAffine function with given parameters', () => {
    const operator = new AffineImage('type', 'id');
    operator.cv2 = opencvMock.cv2;

    // Mock behavior for cv2 functions
    opencvMock.cv2.matFromArray.mockReturnValue('mockMData');

    const imageMock = 'mockImageData';

    operator.compute(imageMock);

    expect(opencvMock.cv2.Mat).toHaveBeenCalledTimes(1);
    expect(opencvMock.cv2.matFromArray).toHaveBeenCalledWith(2, 3, opencvMock.cv2.CV_64FC1, [1, 0, 50, 0, 1, 100]);
    expect(opencvMock.cv2.warpAffine).toHaveBeenCalledWith(
      imageMock,
      {},
      'mockMData',
      {},
      opencvMock.cv2.INTER_LINEAR,
      opencvMock.cv2.BORDER_CONSTANT,
      {});
  });
});

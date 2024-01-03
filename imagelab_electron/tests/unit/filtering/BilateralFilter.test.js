const BilateralFilter = require('../../../src/operator/filtering/BilateralFilter')
const opencvMock = require('../opencv-mocks/filtering.mock');

describe('BilateralFilter Operator', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it('should apply bilateral filter with given parameters', () => {
    const operator = new BilateralFilter('type', 'id');
    operator.cv2 = opencvMock.cv2;

    const imageMock = 'mockImageData';

    operator.setParams('filterSize', 5); // Set filter size
    operator.setParams('sigmaColor', 75); // Set sigma color
    operator.setParams('sigmaSpace', 75); // Set sigma space

    operator.compute(imageMock);

    expect(opencvMock.cv2.bilateralFilter).toHaveBeenCalledWith(
      imageMock,
      new opencvMock.cv2.Mat(),
      5,
      75,
      75,
      opencvMock.cv2.BORDER_DEFAULT
    );
  });
});

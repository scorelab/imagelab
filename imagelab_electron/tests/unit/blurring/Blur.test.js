const Blur = require('../../../src/operator/blurring/Blur')
const opencvMock = require('../opencv-mocks/blurring.mock'); // Adjust the path


describe('Blur Operator', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it('should process blur function with given parameters', () => {
    const operator = new Blur('type', 'id');
    operator.cv2 = opencvMock.cv2; // Inject the cv2 mock

    operator.setParams('widthSize', 3);
    operator.setParams('heightSize', 3);
    operator.setParams('pointX', -1);
    operator.setParams('pointY', -1);

    operator.compute('mockImageData');

    // Assertions
    expect(opencvMock.cv2.Mat).toHaveBeenCalledTimes(1);
    expect(opencvMock.cv2.Size).toHaveBeenCalledWith(3, 3);
    expect(opencvMock.cv2.Point).toHaveBeenCalledWith(-1, -1);
    expect(opencvMock.cv2.blur).toHaveBeenCalledWith(
      'mockImageData',
      {},
      {
        "height": 3,
        "width": 3,
      },
      {
        "x": -1,
        "y": -1,
      },
      opencvMock.cv2.BORDER_DEFAULT
    );
  });

});
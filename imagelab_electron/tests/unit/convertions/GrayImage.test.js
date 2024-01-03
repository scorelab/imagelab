const GrayImage = require('../../../src/operator/convertions/GrayImage');
const opencvMock = require('../opencv-mocks/convertions.mocks');


describe('GrayImage Operator', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it('should process cvtColor function to gray the image', () => {
    const operator = new GrayImage('type', 'id');
    operator.cv2 = opencvMock.cv2; 

    const imageMock = 'mockImageData';

    operator.compute(imageMock);

    // Assertions
    expect(opencvMock.cv2.Mat).toHaveBeenCalledTimes(1);
    expect(opencvMock.cv2.cvtColor).toHaveBeenCalledWith(
      imageMock,
      {},
      'mockColorBGR2GRAY' 
    );
  });
});

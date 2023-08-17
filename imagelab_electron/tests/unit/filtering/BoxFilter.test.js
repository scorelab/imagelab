const BoxFilter = require('../../../src/operator/filtering/BoxFilter')
const opencvMock = require('../opencv-mocks/filtering.mock');

describe('BoxFilter Operator', () => {
    beforeEach(() => {
      jest.clearAllMocks();
    });

    it('should compute the box filter', () => {
      const operator = new BoxFilter('box_filter', 'id');

      operator.cv2 = opencvMock.cv2;

      operator.setParams('width', 50);
      operator.setParams('height', 50);
      operator.setParams('depth', 5);
      operator.setParams('point_x', -1);
      operator.setParams('point_y', -1);
  
      const inputImageMock = {}; // Mock input image
      const outputImageMock = {}; // Mock output image
  
      const computedImage = operator.compute(inputImageMock);
  
      expect(opencvMock.cv2.boxFilter).toHaveBeenCalledWith(
        inputImageMock,
        outputImageMock,
        5, // depth
        expect.any(opencvMock.cv2.Size),
        expect.any(opencvMock.cv2.Point),
        true,
        opencvMock.cv2.BORDER_DEFAULT
      );
  
      expect(computedImage).toEqual(outputImageMock);
    });
  });
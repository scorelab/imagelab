const MedianBlur = require('../../../src/operator/blurring/MedianBlur')
const opencvMock = require('../opencv-mocks/blurring.mock'); 

describe('MedianBlur Operator', () => {
    afterEach(() => {
      jest.clearAllMocks();
    });
  
    it('should process median blur function with given kernel size', () => {
      const operator = new MedianBlur('type', 'id');
      operator.cv2 = opencvMock.cv2; // Inject the cv2 mock
  
      // Set private variable using setParams
      operator.setParams('kernelSize', 5);
  
      const imageMock = 'mockImageData';
  
      operator.compute(imageMock);
  
      // Assertions
      expect(opencvMock.cv2.Mat).toHaveBeenCalledTimes(1);
      expect(opencvMock.cv2.medianBlur).toHaveBeenCalledWith(
        imageMock,
        {},
        5
      );
    });
  
    it('should throw an error if kernel size is even', () => {
      const operator = new MedianBlur('type', 'id');
      operator.cv2 = opencvMock.cv2;
  
      // Assertions
      expect(() => {
        operator.setParams('kernelSize', 4);
      }).toThrow('Kernel Size should be an odd number');
    });
  
  });
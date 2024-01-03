const GaussianBlur = require('../../../src/operator/blurring/GaussianBlur')
const opencvMock = require('../opencv-mocks/blurring.mock');

describe('GaussianBlur Operator', () => {
    afterEach(() => {
      jest.clearAllMocks();
    });
  
    it('should process Gaussian blur function with given parameters', () => {
        const operator = new GaussianBlur('type', 'id');
        operator.cv2 = opencvMock.cv2;
        
        // Set private variables using setParams
        operator.setParams('widthSize', 3);
        operator.setParams('heightSize', 3);

        const imageMock = 'mockImageData';

        // Mock behavior for cv2 functions
        opencvMock.cv2.Size.mockReturnValue({ width: 3, height: 3 });

        operator.compute(imageMock);

        // Assertions
        expect(opencvMock.cv2.Mat).toHaveBeenCalledTimes(1);
        expect(opencvMock.cv2.Size).toHaveBeenCalledWith(3, 3);
        expect(opencvMock.cv2.GaussianBlur).toHaveBeenCalledWith(
            imageMock,
            {},
            opencvMock.cv2.Size(),
            0,
            0,
            opencvMock.cv2.BORDER_DEFAULT
        );
    });
  
    it('should throw an error if the height is even', () => {
      const operator = new GaussianBlur('type', 'id');
      operator.cv2 = opencvMock.cv2; 
  
      // Set private variables using setParams
      operator.setParams('widthSize', 3);
      operator.setParams('heightSize', 2); 
  
      const imageMock = 'mockImageData';
  
      // Assertions
      expect(() => {
        operator.compute(imageMock);
      }).toThrow('Height should be an odd number!');
    });
  
    it('should throw an error if the width is even', () => {
      const operator = new GaussianBlur('type', 'id');
      operator.cv2 = opencvMock.cv2;
  
      // Set private variables using setParams
      operator.setParams('widthSize', 2);
      operator.setParams('heightSize', 3);
  
      const imageMock = 'mockImageData';
  
      // Assertions
      expect(() => {
        operator.compute(imageMock);
      }).toThrow('Width should be an odd number!');
    });
  });
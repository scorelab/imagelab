const RotateImage = require('../../../src/operator/geometric/RotateImage');
const opencvMock = require('../opencv-mocks/geometric.mock');

describe('RotateImage Operator', () => {
    afterEach(() => {
      jest.clearAllMocks();
    });
  
    it('should process getRotationMatrix2D and warpAffine functions with given parameters', () => {
      const operator = new RotateImage('type', 'id');
      operator.cv2 = opencvMock.cv2;
  
      // Mock behavior for cv2 function
      opencvMock.cv2.getRotationMatrix2D.mockReturnValue('mockMData');
  
      const imageMock = {
        rows: 10,
        cols: 10,
      };

      operator.setParams('angle', 45); // Set the angle
      operator.setParams('scale', 0.8); // Set the scale
  
      operator.compute(imageMock);
  
      expect(opencvMock.cv2.Mat).toHaveBeenCalledTimes(1);
      expect(opencvMock.cv2.Size).toHaveBeenCalledWith(imageMock.rows, imageMock.cols);
      expect(opencvMock.cv2.Point).toHaveBeenCalledWith(imageMock.cols / 2, imageMock.rows / 2);
      expect(opencvMock.cv2.getRotationMatrix2D).toHaveBeenCalledWith({}, 45, 0.8);
      expect(opencvMock.cv2.warpAffine).toHaveBeenCalledWith(
        imageMock,
        {},
        'mockMData',
        {},
        opencvMock.cv2.INTER_LINEAR,
        opencvMock.cv2.BORDER_CONSTANT,
        {}
      );
    });
  });

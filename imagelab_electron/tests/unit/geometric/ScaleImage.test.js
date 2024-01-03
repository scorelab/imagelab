const ScaleImage = require('../../../src/operator/geometric/ScaleImage');
const opencvMock = require('../opencv-mocks/geometric.mock');

describe('ScaleImage Operator', () => {
    afterEach(() => {
      jest.clearAllMocks();
    });
  
    it('should process resize function with given parameters', () => {
      const operator = new ScaleImage('type', 'id');
      operator.cv2 = opencvMock.cv2;
  
      // Mock behavior for cv2 functions
      const imageMock = {
        rows: 10,
        cols: 10,
      };
  
      operator.setParams('fx', 1.5); // Set the x-axis scale
      operator.setParams('fy', 0.8); // Set the y-axis scale
  
      operator.compute(imageMock);
  
      expect(opencvMock.cv2.Mat).toHaveBeenCalledTimes(1);
      expect(opencvMock.cv2.Size).toHaveBeenCalledWith(
        Math.round(imageMock.rows * 1.5),
        Math.round(imageMock.cols * 0.8)
      );
      expect(opencvMock.cv2.resize).toHaveBeenCalledWith(
        imageMock,
        {},
        {},
        1.5,
        0.8,
        opencvMock.cv2.INTER_AREA
      );
    });
  
    // Add more test cases as needed
  });
const DrawCircle = require('../../../src/operator/drawing/DrawCircle');
const opencvMock = require('../opencv-mocks/drawing.mock');

describe('DrawCircle Operator', () => {
    afterEach(() => {
      jest.clearAllMocks();
    });
  
    it('should draw a circle with given parameters', () => {
      const operator = new DrawCircle('type', 'id');
      operator.cv2 = opencvMock.cv2;

      const imageMock = 'mockImageData';
  
      operator.setParams('rgbcolors_input', '#FF0000'); // Set circle color
      operator.setParams('thickness', 3); // Set circle thickness
      operator.setParams('radius', 10); // Set circle radius
      operator.setParams('center_point_x', 50); // Set center X-coordinate
      operator.setParams('center_point_y', 50); // Set center Y-coordinate
  
      operator.compute(imageMock);
  
      expect(opencvMock.cv2.Point).toHaveBeenCalledTimes(1);
      expect(opencvMock.cv2.circle).toHaveBeenCalledWith(
        imageMock,
        {},
        10,
        [255, 0, 0, 255],
        3
      );
    });
  });
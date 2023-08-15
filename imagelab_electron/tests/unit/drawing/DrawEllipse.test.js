const DrawEllipse = require('../../../src/operator/drawing/DrawEllipse');
const opencvMock = require('../opencv-mocks/drawing.mock');

describe('DrawEllipse Operator', () => {
    afterEach(() => {
      jest.clearAllMocks();
    });
  
    it('should draw an ellipse with given parameters', () => {
      const operator = new DrawEllipse('type', 'id');
      operator.cv2 = opencvMock.cv2;

      const imageMock = 'mockImageData';
  
      operator.setParams('thickness', 3); // Set ellipse thickness
      operator.setParams('height', 20); // Set ellipse height
      operator.setParams('width', 30); // Set ellipse width
      operator.setParams('angle', 45); // Set ellipse angle
      operator.setParams('center_point_x', 50); // Set center X-coordinate
      operator.setParams('center_point_y', 50); // Set center Y-coordinate
      operator.setParams('rgbcolors_input', '#00FF00'); // Set ellipse color
  
      operator.compute(imageMock);
  
      expect(opencvMock.cv2.Point).toHaveBeenCalledTimes(1);
      expect(opencvMock.cv2.Size).toHaveBeenCalledTimes(1);
      expect(opencvMock.cv2.ellipse).toHaveBeenCalledWith(
        imageMock,
        {},
        {},
        45,
        0,
        360,
        [0, 255, 0, 255],
        3
      );
    });
  });
const DrawLine = require('../../../src/operator/drawing/DrawLine');
const opencvMock = require('../opencv-mocks/drawing.mock');

describe('DrawLine Operator', () => {
    afterEach(() => {
      jest.clearAllMocks();
    });
  
    it('should draw a line with given parameters', () => {
      const operator = new DrawLine('type', 'id');
      operator.cv2 = opencvMock.cv2;
  
      const imageMock = 'mockImageData';
  
      operator.setParams('thickness', 3); // Set line thickness
      operator.setParams('rgbcolors_input', '#00FF00'); // Set line color
      operator.setParams('starting_point_x1', 10); // Set starting point X-coordinate
      operator.setParams('starting_point_y1', 20); // Set starting point Y-coordinate
      operator.setParams('ending_point_x1', 100); // Set ending point X-coordinate
      operator.setParams('ending_point_y2', 200); // Set ending point Y-coordinate
  
      operator.compute(imageMock);
  
      expect(opencvMock.cv2.Point).toHaveBeenCalledTimes(2);
      expect(opencvMock.cv2.line).toHaveBeenCalledWith(
        imageMock,
        {},
        {},
        [0, 255, 0, 255],
        3
      );
    });
  });
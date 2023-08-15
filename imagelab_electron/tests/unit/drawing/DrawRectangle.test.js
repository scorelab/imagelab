const DrawRectangle = require('../../../src/operator/drawing/DrawRectangle');
const opencvMock = require('../opencv-mocks/drawing.mock');

describe('DrawRectangle Operator', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it('should draw a rectangle with given parameters', () => {
    const operator = new DrawRectangle('type', 'id');
    operator.cv2 = opencvMock.cv2;

    const imageMock = 'mockImageData';

    operator.setParams('thickness', 3); // Set rectangle thickness
    operator.setParams('rgbcolors_input', '#FF0000'); // Set rectangle color
    operator.setParams('starting_point_x', 10); // Set starting point X-coordinate
    operator.setParams('starting_point_y', 20); // Set starting point Y-coordinate
    operator.setParams('ending_point_x', 100); // Set ending point X-coordinate
    operator.setParams('ending_point_y', 200); // Set ending point Y-coordinate

    operator.compute(imageMock);

    expect(opencvMock.cv2.Point).toHaveBeenCalledTimes(2);
    expect(opencvMock.cv2.rectangle).toHaveBeenCalledWith(
      imageMock,
      {},
      {},
      [255, 0, 0, 255],
      3
    );
  });
});

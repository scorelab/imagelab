const DrawText = require('../../../src/operator/drawing/DrawText');
const opencvMock = require('../opencv-mocks/drawing.mock');

describe('DrawText Operator', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it('should draw text with given parameters', () => {
    const operator = new DrawText('type', 'id');
    operator.cv2 = opencvMock.cv2;

    const imageMock = 'mockImageData';

    operator.setParams('draw_text', 'Hello'); // Set text to be drawn
    operator.setParams('thickness', 3); // Set text thickness
    operator.setParams('scale', 2); // Set text scale
    operator.setParams('rgbcolors_input', '#00FF00'); // Set text color
    operator.setParams('starting_point_x', 50); // Set starting point X-coordinate
    operator.setParams('starting_point_y', 100); // Set starting point Y-coordinate

    operator.compute(imageMock);

    expect(opencvMock.cv2.Point).toHaveBeenCalledTimes(1);
    expect(opencvMock.cv2.putText).toHaveBeenCalledWith(
      imageMock,
      'Hello',
      {},
      opencvMock.cv2.FONT_HERSHEY_SIMPLEX,
      2,
      [0, 255, 0, 255],
      3,
      opencvMock.cv2.LINE_AA
    );
  });
});

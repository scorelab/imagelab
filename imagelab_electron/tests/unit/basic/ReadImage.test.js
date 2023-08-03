const opencvMock = require('../opencv-mocks/basic.mock'); // Adjust the path
const ReadImage = require('../../../src/operator/basic/ReadImage')

describe('ReadImage Operator', () => {
    afterEach(() => {
      jest.clearAllMocks();
    });

    it('should read the given image', () => {
      const operator = new ReadImage('type', 'id');
      operator.cv2 = opencvMock.cv2;

      // Mock behavior for cv2 functions
      const imageMock = opencvMock.cv2.Mat;
      opencvMock.cv2.imread.mockReturnValue(imageMock);

      const result = operator.compute('path/to/image.jpg');

      // Assertions
      expect(opencvMock.cv2.imread).toHaveBeenCalledWith('path/to/image.jpg');
      expect(result).toBe(imageMock);
    });

  });  
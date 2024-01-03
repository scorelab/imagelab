module.exports = {
    cv2: {
        Mat: jest.fn(),
        Size: jest.fn((width, height) => ({ width, height })),
        Point: jest.fn((x, y) => ({ x, y })), 
        blur: jest.fn(),
        GaussianBlur: jest.fn(),
        medianBlur: jest.fn(),
    },
  };
  
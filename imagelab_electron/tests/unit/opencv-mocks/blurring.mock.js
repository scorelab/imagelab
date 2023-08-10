module.exports = {
    cv2: {
        Mat: jest.fn(),
        Size: jest.fn((width, height) => ({ width, height })), // Mock Size with a function that returns an object
        Point: jest.fn((x, y) => ({ x, y })), // Mock Point with a function that returns an object
        blur: jest.fn(),
    },
  };
  
const opencvMock = {
    cv2: {
      Mat: jest.fn(),
      bilateralFilter: jest.fn(),
      cvtColor: jest.fn(),
      Mat: jest.fn(),
      boxFilter: jest.fn(),
      Size: jest.fn(),
      Point: jest.fn(),
    },
  }
  module.exports = opencvMock;
  
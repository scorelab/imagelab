module.exports = {
    cv2: {
      Mat: jest.fn(),
      getRotationMatrix2D: jest.fn(),
      warpAffine: jest.fn(),
      resize: jest.fn(),
      matFromArray: jest.fn(),
      Size: jest.fn(),
      Scalar: jest.fn(),
      Point: jest.fn(),
    },
};
  
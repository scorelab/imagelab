module.exports = {
    cv2: {
      Mat: jest.fn(),
      cvtColor: jest.fn(),
      COLOR_BGR2GRAY: 'mockColorBGR2GRAY',
      threshold: jest.fn(),
      THRESH_BINARY: 'mockThreshBinary',
    },
  };
  
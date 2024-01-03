const opencvMock = {
    cv2: {
      Mat: class MatMock {
        constructor(rows, cols) {
          this.rows = rows || 0;
          this.cols = cols || 0;
        }
  
        // Mock implementation of the ones method
        static ones(rows, cols, type) {
          return new MatMock(rows, cols);
        }
      },
      bilateralFilter: jest.fn(),
      cvtColor: jest.fn(),
      boxFilter: jest.fn(),
      Size: jest.fn(),
      Point: jest.fn(),
      dilate: jest.fn(),
      BORDER_CONSTANT: 1,
      morphologyDefaultBorderValue: jest.fn(),
    },
  }
  module.exports = opencvMock;
  
module.exports = {
    testMatch: [
      '<rootDir>/tests/unit/**/*.test.js', // Adjust the path to match your unit tests
    ],
    moduleNameMapper: {
      '^@/(.*)$': '<rootDir>/src/$1',
    },
    setupFiles: [
      '<rootDir>/tests/unit/opencv-mocks/basic.mock.js', // Basic operators mock
    ],
  };
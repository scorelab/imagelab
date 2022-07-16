/**
 * This function is responsible for generating r,g,b values
 * for a hexadecimal color string
 * @param {string} hex
 * @returns object
 */
function hexToRgb(hex) {
  var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
  return result
    ? {
        r: parseInt(result[1], 16),
        g: parseInt(result[2], 16),
        b: parseInt(result[3], 16),
      }
    : null;
}

module.exports = { hexToRgb };

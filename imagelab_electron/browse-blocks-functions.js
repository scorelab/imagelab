const ReadImage = require("./src/operator/basic/ReadImage");

/*This function is responible for opening file selector window to choose the picture you will do operqations on 
it works with (read image) block */
Blockly.Extensions.register("file_button", function () {
  // (file_button) is the extension name given to the (file_browse) block in JSON block set.
  this.getField("file_browse").clickHandler_ = () => {
    // (file_browse) is the name of block in JSON block set.
    var input = document.getElementById("inputImage"); // inputImage is the html element of button that opens the file explorer and it is hidden in that case.
    input.click();
  };
});

/*This function is responible for opening folder selector window to choose the directory you will save your work to 
it works with (write image) block */
Blockly.Extensions.register("folder_button", function () {
  // (folder_button) is the extension name given to the (folder_browse) block in JSON block set.
  this.getField("folder_browse").clickHandler_ = () => {
    // (folder_browse) is the name of block in JSON block set.
    var output = document.getElementById("outputDirectory"); // outputDirectory is the html element of button that opens the file explorer and it is hidden in that case.
    output.click();
  };
});

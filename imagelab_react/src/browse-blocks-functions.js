import Blockly from "blockly";
/*This function is responible for opening file selector window to choose the picture you will do operqations on 
it works with (read image) block */
const handleFileSelection = () => {
  // Open file selector
  const input = document.createElement("input");
  input.type = "file";
  input.accept = "image/*";
  input.onchange = (event) => {
    const file = event.target.files[0];
    if (file) {
      const imageUrl = URL.createObjectURL(file);
      
      // Store the selected image in local storage
      localStorage.setItem("selectedImage", imageUrl);
      // Send message to the parent window
      window.postMessage({ type: 'imageSelected', imageUrl }, '*');
    }
    
  };
  input.click();
};

Blockly.Extensions.register("file_button", function () {
  // (file_button) is the extension name given to the (file_browse) block in JSON block set.
  this.getField("file_browse").clickHandler_ = () => {
      handleFileSelection();
  };
});
  
  /*This function is responible for opening folder selector window to choose the directory you will save your work to 
  it works with (write image) block */
  Blockly.Extensions.register("folder_button", function () {
    // (folder_button) is the extension name given to the (folder_browse) block in JSON block set.
    this.getField("folder_browse").clickHandler_ = () => {
        console.log("Folder browse");
    };
  });
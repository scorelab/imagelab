import Blockly from "blockly";
const electron = window.require('electron');
const ipcRenderer  = electron.ipcRenderer;

/*This function is responible for opening file selector window to choose the picture you will do operqations on 
it works with (read image) block */
const handleFileSelection = () => {
  // Open file selector
  const input = document.createElement("input");
  input.type = "file";
  input.accept = "image/*";
  input.onchange = async (event) => {
    const file = event.target.files[0];
    if (file) {
      const imageUrl = URL.createObjectURL(file);
      
      // Store the selected image in local storage
      localStorage.setItem("selectedImage", imageUrl);

      //Set Original Image
      const img = new Image();
      img.onload = async function() {
        const canvas = document.createElement('canvas');
        const ctx = canvas.getContext('2d');
        canvas.width = this.width;
        canvas.height = this.height;
        ctx.drawImage(this, 0, 0, this.width, this.height);

        const dataUrl = canvas.toDataURL('image/png');

        // Extract base64 data
        const base64Image = dataUrl.replace(/^data:image\/\w+;base64,/, "");
        try {
          // Store the selected image in local storage
          localStorage.setItem("base64Image", base64Image);
          try {
            await ipcRenderer.invoke('setOriginalImage', base64Image);
          } catch (error) {
              throw new Error(error);
          }
          console.log("Image set");
        } catch (error) {
          console.error('Failed to load image:', error);
        }
      }
      img.src = imageUrl;


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
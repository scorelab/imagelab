import Blockly from "blockly";
const ipcRenderer = window.ipcRenderer;

function processBlock(block, pipeline) {
    const blockParams = block.inputList.reduce((params, input) => {
        const fieldRow = input.fieldRow;
        fieldRow.forEach(field => {
          params.push({
            type: field.name,
            value: field.value_
          });
        });
        return params;
    }, []);
    console.log(blockParams);
    pipeline.push({
        type: block.type, 
        id: block.id,
        params: blockParams
    });
    const childBlocks = block.getChildren();
    childBlocks.forEach((childBlock) => {
        processBlock(childBlock, pipeline);
    });
}

export async function run(block) {
    const isImageSelected = localStorage.getItem("selectedImage");
    console.log(isImageSelected);
    const pipeline = [];
    processBlock(block, pipeline);
    try {
        await ipcRenderer.invoke('addOperators', pipeline);
    } catch (error) {
        throw new Error(error);
    }
    try {
        await ipcRenderer.invoke('computeAll');
    } catch (error) {
        console.error('Failed to compute:', error);
    }
    try {
        const processedImageString = await ipcRenderer.invoke('getProcessedImage');
        createAndStoreImageFromBase64(processedImageString)
    } catch (error) {
        console.error('Failed to compute:', error);
    }
}

function createAndStoreImageFromBase64(base64Image) {
    const image = new Image();
  
    image.onload = function() {
      const canvas = document.createElement('canvas');
      const context = canvas.getContext('2d');
      canvas.width = image.width;
      canvas.height = image.height;
  
      // Draw the image onto the canvas
      context.drawImage(image, 0, 0);
  
      // Obtain the canvas image data
      const canvasImageData = canvas.toDataURL('image/png');
  
      // Store the canvas image data in localStorage
      localStorage.setItem('storedImage', canvasImageData);
      // Send message to the parent window
      window.postMessage({ type: 'imageProcessed', canvasImageData }, '*');
  
      console.log('Image stored in localStorage');
    };
  
    image.src = base64Image;
  }

export function undo() {
    Blockly.getMainWorkspace().undo(false);
}

export function redo() {
    Blockly.getMainWorkspace().undo(true);
}

export function reset() {
    const shouldReset = window.confirm('Are you sure you want to reset the workspace?');
    if (shouldReset) {
      Blockly.mainWorkspace.clear();
    }
}
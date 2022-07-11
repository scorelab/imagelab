const PROCESS_OPERATIONS = require("./operations");
const MainController = require("./src/controller/main");

var blocklyDiv = document.getElementById("blocklyDiv");
var toolbox = document.getElementById("toolbox");

const mainController = new MainController();

const { dialog } = require("electron").remote;

// workspace configuration
var workspace = Blockly.inject(blocklyDiv, {
  toolbox: toolbox,
  media: "./node_modules/blockly/media/",
  scrollbars: true,
  trashcan: true,
  sounds: true,
  oneBasedIndex: true,
  zoom: {
    controls: true,
    wheel: false,
    startScale: 0.6,
    maxScale: 2,
    minScale: 0.4,
    scaleSpeed: 1.2,
  },
  renderer: "zelos",
});

// enable searching on workspace by using ctrl +f
const workspaceSearch = new WorkspaceSearch(workspace);
workspaceSearch.init();

/**
 * @override
 * responsible for fixing flyout scale even when you zoom the workspace
 */
Blockly.VerticalFlyout.prototype.getFlyoutScale = function () {
  return 0.6;
};

// Coloring the information-pane when you select a block.
workspace.addChangeListener(function (event) {
  if (event.type === Blockly.Events.BLOCK_CREATE) {
    mainController.addOperator(workspace.getBlockById(event.blockId).type);
  } else if (
    event.type === Blockly.Events.BLOCK_DRAG ||
    event.type === Blockly.Events.BLOCK_MOVE
  ) {
    if (event?.newParentId && event?.blockId) {
      mainController.arrangeBlocks(
        workspace.getBlockById(event?.newParentId).type,
        workspace.getBlockById(event?.blockId).type
      );
    }
  } else if (event.type === Blockly.Events.BLOCK_CHANGE) {
    const blockType = workspace.getBlockById(event.blockId).type;
    const paramType = event.name;
    const value = event.newValue;
    mainController.changeValuesOfBlocks(blockType, paramType, value);
  }
  if (event.type === Blockly.Events.SELECTED) {
    if (Blockly.selected === null) {
      document.getElementById("information-pane").style.backgroundColor =
        "#ccc";
      document.getElementById("information-pane").style.border =
        "3px solid transparent";
    } else {
      document.getElementById("information-pane").style.backgroundColor =
        Blockly.selected.getColour();
      document.getElementById("information-pane").style.border =
        "3px solid yellow";
    }
  }
});

/**
 *
 * @param {String} title
 * @param {String} message
 * @param {String} type
 *
 * This method generates an output dialog according to the params passed
 */
function showDialog(title, message, type) {
  dialog.showMessageBox(null, {
    title: title,

    buttons: ["Dismiss"],
    type: type,
    message: message,
  });
}

// zoom in function used in preview pane by the zooming in icon
function zoomin() {
  var myImg = document.getElementById("image-preview");

  var currWidth = myImg.clientWidth;
  if (currWidth == 2500) return false;
  else {
    myImg.style.width = currWidth + 100 + "px";
  }
}

// zoom out function used in preview pane by the zooming out icon
function zoomout() {
  var myImg = document.getElementById("image-preview");
  var currWidth = myImg.clientWidth;
  if (currWidth == 100) return false;
  else {
    myImg.style.width = currWidth - 100 + "px";
  }
}

/**
 * This function computes the image processing
 * which are selected by the user
 */
function executeProcess() {
  const preview = document.getElementById("image-preview");
  try {
    mainController.computeAll(preview);
  } catch (error) {
    console.log(error);
    showDialog("Error Occured", error.message, "error");
  }
}

/**
 * This function is responsible for setting the location of the output image
 */
function setDirectory() {
  const location = document.getElementById("outputDirectory");
  console.log("Function called");
  location.addEventListener("load", (e) => {
    console.log("Output location is: ", e);
  });
}

/**
 * This function loads the selected image and
 * set the image in the main controller
 */
function loadFile() {
  const preview = document.getElementById("input-image"); // image-preview is the element of image will displayed on the preview pane.
  const file = document.querySelector("input[type=file]").files[0];
  const reader = new FileReader();
  var url = "";

  reader.addEventListener(
    "load",
    function () {
      // convert image file to base64 string
      url = URL.createObjectURL(file);

      preview.src = url;
    },
    false
  );

  preview.onload = () => {
    // Here preview is the main image
    mainController.setOriginalImage(preview);
  };

  if (file) {
    reader.readAsDataURL(file);
  }
}

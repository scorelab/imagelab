var blocklyDiv = document.getElementById("blocklyDiv");
var toolbox = document.getElementById("toolbox");

// workspace configuration
var workspace = Blockly.inject(blocklyDiv, {
  toolbox: toolbox,
  media: './node_modules/blockly/media/',
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
    scaleSpeed: 1.2
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
  if (event.type == Blockly.Events.SELECTED) {
    if (Blockly.selected == null) {
      document.getElementById('information-pane').style.backgroundColor = '#ccc';
      document.getElementById('information-pane').style.border = "3px solid transparent";

    } else {
      document.getElementById('information-pane').style.backgroundColor = Blockly.selected.getColour();
      document.getElementById('information-pane').style.border = "3px solid yellow";
    }
  }
});

// zoom in function used in preview pane by the zooming in icon
function zoomin() {
  var myImg = document.getElementById("image-preview");
  var currWidth = myImg.clientWidth;
  if (currWidth == 2500) return false;
  else {
    myImg.style.width = (currWidth + 100) + "px";
  }
}

// zoom out function used in preview pane by the zooming out icon
function zoomout() {
  var myImg = document.getElementById("image-preview");
  var currWidth = myImg.clientWidth;
  if (currWidth == 100) return false;
  else {
    myImg.style.width = (currWidth - 100) + "px";
  }
}
import Blockly from "blockly";
const electron = window.require('electron');
const ipcRenderer  = electron.ipcRenderer;

function processBlock(block, pipeline) {
    pipeline.push(block);
    const childBlocks = block.getChildren();
    childBlocks.forEach((childBlock) => {
        processBlock(childBlock, pipeline);
    });
    console.log()
}

export async function run(block) {
    const pipeline = [];
    processBlock(block, pipeline)
    pipeline.forEach(async (block) => {
        try {
            await ipcRenderer.invoke('addOperator', block.type, block.id);
            console.log('Operator added successfully');
        } catch (error) {
            console.error('Failed to add operator:', error);
        }
    })
    try {
        await ipcRenderer.invoke('computeAll');
        console.log("Computation successful");
    } catch (error) {
        console.error('Failed to compute:', error);
    }
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
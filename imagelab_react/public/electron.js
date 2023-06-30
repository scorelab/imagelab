const path = require('path');
const { app, BrowserWindow, ipcMain } = require('electron');
const isDev = require('electron-is-dev');
const MainController = require('../backend/controller/main');

function createWindow() {
  // Create the browser window.
  const win = new BrowserWindow({
    height: 800,
    width: 1500,
    minWidth: 1100,
    minHeight: 800,
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
    },
  });

  // and load the index.html of the app.
  win.loadURL(
    isDev
      ? 'http://localhost:3000'
      : `file://${path.join(__dirname, '../build/index.html')}`
  );

  // Open the DevTools.
  if (isDev) {
    win.webContents.openDevTools({ mode: 'detach' });
  }
}

// This method will be called when Electron has finished
// initialization and is ready to create browser windows.
// Some APIs can only be used after this event occurs.
app.whenReady().then(() => {
  createWindow();

  // Create an instance of the MainController
  const mainController = new MainController();

  // Handle the 'addOperator' request from the renderer process
  ipcMain.handle('addOperator', (event, operatorType, id) => {
    try {
      mainController.addOperator(operatorType, id);
      return true;
    } catch (error) {
      throw new Error(`Failed to add operator: ${error.message}`);
    }
  });

  // Handle the 'computeAll' request from the renderer process
  ipcMain.handle('computeAll', async () => {
    try {
      await mainController.computeAll();
      return true;
    } catch (error) {
      throw new Error(`Failed to compute: ${error.message}`);
    }
  });

  // Handle the 'setOriginalImage' request from the renderer process
  ipcMain.handle('setOriginalImage', async (event, base64Image) => {
    try {
      // Convert base64 string to buffer
      let imageBuffer = Buffer.from(base64Image, 'base64');
      mainController.setOriginalImage(imageBuffer);
    } catch (error) {
      throw new Error(`Failed to set image: ${error.message}`);
    }
  });

});

// Quit when all windows are closed, except on macOS.
// There, it's common for applications and their menu bars
// to stay active until the user quits explicitly with Cmd + Q.
app.on('window-all-closed', () => {
  if (process.platform !== 'darwin') {
    app.quit();
  }
});

app.on('activate', () => {
  if (BrowserWindow.getAllWindows().length === 0) {
    createWindow();
  }
});

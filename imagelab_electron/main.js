"use strict";

console.log("main process working");

const electron = require("electron");
const path = require("path");

const remoteMain = require('@electron/remote/main');
remoteMain.initialize();

const { app, BrowserWindow, Menu, shell } = electron;

let splash;

require("electron-reload")(__dirname, {
  electron: path.join(__dirname, "node_modules", ".bin", "electron"),
  hardResetMethod: "exit",
});

app.on("ready", () => {
  // Main window properties
  let mainWindow = new BrowserWindow({
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
      enableRemoteModule: true,
    },
    height: 800,
    width: 1500,
    minWidth: 1100,
    minHeight: 800,
    show: false,
    icon: __dirname + "/assets/logos/Image Lab Icon.png",
    frame: false,
    titleBarStyle: "hidden",
  });

  // Splash window properties
  splash = new BrowserWindow({
    width: 600,
    height: 400,
    transparent: true,
    frame: false,
    alwaysOnTop: true,
    icon: __dirname + "/assets/logos/Image Lab Icon.png",
  });
  splash.loadURL(`file://${__dirname}/splash.html`);
  mainWindow.loadURL(`file://${__dirname}/index.html`);

  // This line needs to removed after the development
  mainWindow.webContents.openDevTools();

  // when main window is loaded and ready to be displayed, splash will end and main winndow appears
  mainWindow.once("ready-to-show", () => {
    setTimeout(function () {
      splash.destroy();
      mainWindow.show();
    }, 3000);
  });

  mainWindow.on("closed", function () {
    mainWindow = null;
  });

  // Saving window opens when user try to exit from application to warn him if he wants to save/don't save his work
  mainWindow.on("close", function (e) {
    const choice = require("electron").dialog.showMessageBoxSync(this, {
      type: "question",
      buttons: ["Save", "Don't save", "Cancel"],
      title: "Image Lab",
      message: "Do you want to save changes to ........ ?",
    });
    if (choice == 2) {
      e.preventDefault();
    }
  });
});

// The new menu configuration

const isMac = process.platform === "darwin";

const template = [
  // { role: 'appMenu' }
  ...(isMac
    ? [
        {
          label: app.name,
          submenu: [
            { role: "about" },
            { type: "separator" },
            { role: "services" },
            { type: "separator" },
            { role: "hide" },
            { role: "hideothers" },
            { role: "unhide" },
            { type: "separator" },
            { role: "quit" },
          ],
        },
      ]
    : []),
  // { role: 'fileMenu' }
  {
    label: "File",
    submenu: [
      { label: "New File" },
      { label: "Open File" },
      { label: "Save" },
      isMac ? { role: "close" } : { role: "quit" },
    ],
  },
  // { role: 'viewMenu' }
  {
    label: "View",
    submenu: [
      { role: "reload" },
      { role: "forceReload" },
      { role: "toggleDevTools" },
      { label: "Zoom in" },
      { label: "Zoom out" },
      { label: "Center blocks" },
    ],
  },
  {
    role: "help",
    submenu: [
      { label: "Tutorials" },
      {
        label: "About",
        click() {
          aboutWindowPreview();
        },
      },
      {
        label: "Learn More",
        click: async () => {
          const { shell } = require("electron");
          await shell.openExternal("https://github.com/scorelab/imagelab");
        },
      },
    ],
  },
];

const menu = Menu.buildFromTemplate(template);
Menu.setApplicationMenu(menu);

// function called when we need to show about window
function aboutWindowPreview() {
  // About-window properties
  let aboutWindow = new BrowserWindow({
    height: 520,
    width: 600,
    title: "About",
    resizable: false,
    minimizable: false,
    fullscreenable: false,
    show: false,
    autoHideMenuBar: true,
    icon: __dirname + "/assets/logos/Image Lab Icon.png",
  });
  aboutWindow.loadURL(`file://${__dirname}/about.html`);
  aboutWindow.show();

  aboutWindow.on("closed", function () {
    aboutWindow = null;
  });
  // this part solves the problem of opening links in about window in the same window
  // so when you click a link in about menu, it opens in an external user default browser
  aboutWindow.webContents.on("new-window", function (e, url) {
    // make sure local urls stay in electron perimeter
    if ("file://" === url.substr(0, "file://".length)) {
      return;
    }
    // and open every other protocols on the browser
    e.preventDefault();
    shell.openExternal(url);
  });
}

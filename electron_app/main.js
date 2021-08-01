<<<<<<< HEAD
<<<<<<< HEAD
"use strict";
=======
'use strict';
>>>>>>> add first stagge of electron app
=======
"use strict";
>>>>>>> light mode - dark mode - splash screen

console.log("main process working");

const electron = require("electron");
const { app, BrowserWindow } = electron;

<<<<<<< HEAD
<<<<<<< HEAD
let splash;

app.on("ready", () => {
  let mainWindow = new BrowserWindow({
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
    },
    height: 800,
    width: 1600,
    minWidth: 1100,
    minHeight: 800,
    show: false,
    icon: __dirname + '/assets/logos/Image Lab.png',
  });

  splash = new BrowserWindow({
    width: 600,
    height: 400,
    transparent: true,
    frame: false,
    alwaysOnTop: true,
  });
  splash.loadURL(`file://${__dirname}/splash.html`);
  mainWindow.loadURL(`file://${__dirname}/index.html`);

  mainWindow.once("ready-to-show", () => {
    setTimeout(function () {
      splash.destroy();
      mainWindow.show();
    }, 3000);
  });

  mainWindow.on("closed", function () {
    mainWindow = null;
  });
=======
=======
let splash;

>>>>>>> light mode - dark mode - splash screen
app.on("ready", () => {
  let mainWindow = new BrowserWindow({
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
    },
    height: 800,
    width: 1600,
    minWidth: 1100,
    minHeight: 800,
    show: false,
    icon: __dirname + '/assets/logos/Image Lab.png',
  });

  splash = new BrowserWindow({
    width: 600,
    height: 400,
    transparent: true,
    frame: false,
    alwaysOnTop: true,
  });
  splash.loadURL(`file://${__dirname}/splash.html`);
  mainWindow.loadURL(`file://${__dirname}/index.html`);

  mainWindow.once("ready-to-show", () => {
    setTimeout(function () {
      splash.destroy();
      mainWindow.show();
    }, 3000);
  });

<<<<<<< HEAD
        mainWindow = null;
    })
>>>>>>> add first stagge of electron app
=======
  mainWindow.on("closed", function () {
    mainWindow = null;
  });
>>>>>>> light mode - dark mode - splash screen
});

<<<<<<< HEAD
"use strict";
=======
'use strict';
>>>>>>> add first stagge of electron app

console.log("main process working");

const electron = require("electron");
const { app, BrowserWindow } = electron;

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
app.on("ready", () => {
    let mainWindow = new BrowserWindow({
        webPreferences: {
            nodeIntegration: true,
            contextIsolation: false,
        }, height: 700, width: 1500, show: false
    });
    mainWindow.loadURL(`file://${__dirname}/index.html`);
    mainWindow.once("ready-to-show", () => {
        mainWindow.show();
    });

    mainWindow.on('closed', function () {

        mainWindow = null;
    })
>>>>>>> add first stagge of electron app
});

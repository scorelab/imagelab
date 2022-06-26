const customTitlebar = require('custom-electron-titlebar');
// title bar / menu bar configuration of the custom-electron-titlebar library
let newTitlebar = new customTitlebar.Titlebar({
  icon: './assets/logos/Image Lab Icon.png',
  menuPosition: 'bottom',
  titleHorizontalAlignment: 'left',
  title: 'Image Lab',
});
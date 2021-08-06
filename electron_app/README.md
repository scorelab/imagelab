# New UI implementation for Image Lab

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Usage](#usage)
- [Built Using](#built_using)

## 🧐 About <a name = "about"></a>

Here, you can find a new style of ImageLab by using Blockly library and other different technologies.

https://user-images.githubusercontent.com/43797542/128559673-b3e976f9-8c6a-4441-9b0b-4df5b3eec49d.mp4

## 🏁 Getting Started <a name = "getting_started"></a>

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- you will need to clone `Image Lab` project:

```
git clone https://github.com/scorelab/ImageLab.git
```

ImageLab uses ElectronJS so we do some steps to get it compatible with our project:

- To use Electron, you need to install Node.js from [here](https://nodejs.org/en/download/). (We recommend that you use the latest LTS version available.)

To check that Node.js was installed correctly, type the following commands in your terminal client:

```
node -v
npm -v
```

The commands should print the versions of Node.js and npm accordingly.

\*Note: Since Electron embeds Node.js into its binary, the version of Node.js running your code is unrelated to the version running on your system.

Then you open your terminal and refer to the directory of [`/imagelab/electron_app`](https://github.com/scorelab/imagelab/tree/master/electron_app) on your machine using `cd` command.

then we will initialize an npm package:

```
npm init
```

### Installing

then, you start installing packages used in the project:

```
npm install blockly
npm install intro.js --save
npm install @mdi/font
npm install @blockly/plugin-workspace-search --save
```

## 🎈 Usage <a name="usage"></a>

to start opening the application and using it you can run this command:

```
npm run start
```

## ⛏️ Built Using <a name = "built_using"></a>

- [<img align="left" alt="linked-in" src="https://img.shields.io/badge/Electron-191970?style=for-the-badge&logo=Electron&logoColor=white" />](https://www.electronjs.org/)
- [<img align="left" alt="linked-in" src="https://img.shields.io/badge/NPM-%23000000.svg?style=for-the-badge&logo=npm&logoColor=white" />](https://www.npmjs.com/)
- [<img align="left" alt="linked-in" src="https://developers.google.com/blockly/images/logos/logo_standard.svg" height= "30" />](https://developers.google.com/blockly)

# New UI implementation for Image Lab

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Usage](#usage)
- [Contributing](#contributing)
- [Built Using](#built_using)

## 🧐 About <a name = "about"></a>

Here, you can see the new design of ImageLab by using Blockly library and other different technologies.

https://user-images.githubusercontent.com/43797542/130302770-b43a8ee4-fb59-4af2-b804-20e1847866f4.mp4

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

Then you open your terminal and refer to the directory of [`/imagelab/imagelab_electron`](https://github.com/kaveeshadinamidu/imagelab/tree/master/imagelab_electron) on your machine using `cd` command.

```
cd imagelab_electron/
```

### Installing

then, you start installing packages used in the project:

You can install all the npm packages once by running

```
npm install
```

## 🎈 Usage <a name="usage"></a>

to start opening the application and using it you can run this command:

```
npm start
```

After starting the application you can implement any combinations of image processing and
test them. But to execute correctly you need to set the first operator as "read_image" and
the last operator as "write_image" in the operations stack.

Following are the implemented functions that working currently,

- Basic functions
- Geometric functions (Except Image Reflect)
- Drawing functions (Except Draw Arrow)
- Blurring functions
- Filtering functions

\*Note - When starting the application two windows will be open. Main application window and the developer console. If you want to remove the developer console window remove the following line in the /main.js file.

```
 mainWindow.webContents.openDevTools();
```

### Debugging

When installing packages and running the application few issues can be arised. Following are the few steps that you can fix those isses.

- Check you node and npm versions. Make sure that they are updated to latest versions
- There may be npm libraries that have outdated. Try to fix those depedency issues by reffering [npmjs](https://www.npmjs.com)

## 💻 Contributing <a name = "contributing"></a>

If you need to contribute to this project, we are happy to hear that. Before starting any contributions please read our developer guidelines and then proceed. Following are the steps that you need to follow before implementing coding.

- Fork our repository and clone the individual repository and setup the development environment
- If you want to start implementing a new function type which not been implemented yet such as
  "Thresholding" then create a folder inside src/operator directory.
  Ex: If you need to implement the Thresholding functions create a folder name "thresholding" inside src/operator directory.
- Then create a javascript file with the name of the operator and implement the code.
  Ex: If you need to implement the Apply Border operator create a file named "applyborder.js".
- When implementing the functions use classes as below,

```
class YourOperator extends OpenCvOperator {

    // This is the main contructor of the function
    constructor(type,id){
        super(type,id);
    }

    // This function set the parameters which are related with the class
    setParams(type, value) {
    }

    // This is the method which does the image processing work.
    compute(image){
      return image;
    }

}

```

Before running the implemented function you need to setup few other things as well,

- In /operations.js file define your opeation with the matching type selected from the /imagelab-blocks.js file.
  Ex:

```
ADD_BORDER:"add_border"
```

- Modify the addOperator function inside the /src/controller/main.js file.

```
case ADD_BORDER:
  this.#appliedOperators.push(
          new ApplyBorder(PROCESS_OPERATIONS.ADD_BORDER, id)
        );
  break;
```

After procceding above steps you can execute the implemented functions in the application.

## ⛏️ Built Using <a name = "built_using"></a>

- [<img align="left" alt="linked-in" src="https://img.shields.io/badge/Electron-191970?style=for-the-badge&logo=Electron&logoColor=white" />](https://www.electronjs.org/)
- [<img align="left" alt="linked-in" src="https://img.shields.io/badge/NPM-%23000000.svg?style=for-the-badge&logo=npm&logoColor=white" />](https://www.npmjs.com/)
- [<img align="left" alt="linked-in" src="https://developers.google.com/blockly/images/logos/logo_standard.svg" height= "30" />](https://developers.google.com/blockly)

# New UI implementation for Image Lab

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Usage](#usage)
- [Contributing](#contributing)
- [Architecture](#architecture)
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

Then you open your terminal and refer to the directory of [`/imagelab/imagelab_react`](https://github.com/scorelab/imagelab/tree/master/imagelab_react) on your machine using `cd` command.

```
cd imagelab_react/
```

### Installing

then, you start installing packages used in the project:

You can install all the yarn packages once by running

```
yarn install
```

## 🎈 Usage <a name="usage"></a>

to start opening the application and using it you can run this command:

```
yarn start
```
or 
```
yarn dev
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
- Convertion functions
- Thresholding functions

\*Note - When starting the application two windows will be open. Main application window and the developer console. If you want to remove the developer console window remove the following line in the public/electron.js file.

```
 mainWindow.webContents.openDevTools();
```

### Debugging

When installing packages and running the application few issues can be arised. Following are the few steps that you can fix those isses.

- Check you node and npm versions. Make sure that they are updated to latest versions
- There may be libraries that have outdated. Try to fix those depedency issues by reffering to their documentation

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

- Modify the addOperator function inside the /backend/controller/main.js file.

```
case ADD_BORDER:
  this.#appliedOperators.push(
          new ApplyBorder(PROCESS_OPERATIONS.ADD_BORDER, id)
        );
  break;
```

After procceding above steps you can execute the implemented functions in the application.

## 🏛️ Architecture <a name="architecture"></a>

The new UI implementation of Image Lab is built using Electron, and follows a client-server architecture. Electron allows building cross-platform desktop applications using web technologies.

### Client Side:
The Renderer Process of the Image Lab application plays a crucial role in providing a user-friendly and interactive interface for image processing tasks. It incorporates the following technologies to enhance the user experience:

**React**: Image Lab utilizes React, a powerful JavaScript library, to build its user interface. React's component-based architecture allows for the creation of modular and reusable UI components. This enables the development team to efficiently manage the complex UI requirements of an image processing application.

**Blueprint.js**: To maintain consistency, accessibility, and performance in the user interface, Image Lab leverages Blueprint.js, a UI toolkit designed for web applications. Blueprint.js offers a set of pre-designed UI components adhering to Material Design principles. By integrating Blueprint.js components into the application, Image Lab ensures a visually appealing and cohesive user interface. This helps users navigate the application with ease and provides a familiar environment for interacting with various image processing functionalities.

**React-Blockly**: For intuitive image processing workflow creation, Image Lab incorporates React-Blockly, a custom implementation of Google's Blockly library for React. This integration allows users to visually construct image processing pipelines by assembling blocks representing different operations. React-Blockly's drag-and-drop interface simplifies the process of creating intricate image processing workflows. 

#### IPC (Inter-Process Communication)
* Sending the image to be processed: The client sends the image to be processed to the main process (backend) in the form of a base64 encoded image.
* Receiving the processed image: The main process returns the processed image to the client in the form of a base64 encoded image.

### Server Side:
#### Main Process (Node.js)
The server side of the application runs as the main process in Electron and handles the image processing using OpenCv.js.

#### OpenCv.js Backend
**Image Processing**: The main process performs various image processing operations on the input image using OpenCv.js functions and algorithms.

**Interacting with React**: The main process receives the image from the client (renderer process), processes it, and sends the processed image back to the client using IPC.

### Application Flow:
1. The user interacts with the user interface (built with React) in the Electron app (renderer process).
2. The user selects an image and specifies the image processing operations to be applied.
3. The client (renderer process) sends the selected image to the main process (Node.js backend) using IPC, encoding it as a base64 image.
4. The main process (Node.js backend) receives the image and processes it using OpenCv.js functions based on the specified operations.
5. After processing, the main process sends the processed image back to the client (renderer process) in the form of a base64 image using IPC.
6. The client (renderer process) receives the processed image and updates the user interface to display the result.

## ⛏️ Built Using <a name = "built_using"></a>

- [<img align="left" alt="linked-in" src="https://img.shields.io/badge/Electron-191970?style=for-the-badge&logo=Electron&logoColor=white" />](https://www.electronjs.org/)
- [<img align="left" alt="linked-in" src="https://img.shields.io/badge/-ReactJs-61DAFB?logo=react&logoColor=white&style=for-the-badge" />](https://react.dev)
- [<img align="left" alt="linked-in" src="https://img.shields.io/badge/yarn-%232C8EBB.svg?style=for-the-badge&logo=yarn&logoColor=white" />](https://yarnpkg.com)
- [<img align="left" alt="linked-in" src="https://img.shields.io/badge/Blueprint.js-676d75" />](https://blueprintjs.com)
- [<img align="left" alt="linked-in" src="https://developers.google.com/blockly/images/logos/logo_standard.svg" height= "30" />](https://developers.google.com/blockly)

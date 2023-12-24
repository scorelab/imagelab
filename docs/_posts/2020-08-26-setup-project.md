---
layout: post
title: ImageLab Documentation
---

<br>Documentation contains steps to setup your environment and get started with contributions.
Please make sure, you have joined the project's official gitter channel for further discussions
related to the project.

[![Gitter](https://badges.gitter.im/scorelab/ImageLab.svg)](https://gitter.im/scorelab/ImageLab?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
<br>

## 📝 Table of Contents

1. [Java Project Docs](#java_docs)
2. [Elctron Project Docs](#elctron_docs)
3. [React Project Docs](#react_docs)
4. [Updating Docs](#updating_docs)

<br>

# <center>Java Project Documentation <a name="java_docs"></a></center>

<br>

## Outline

1. [Setting up the environment.](#java_enviroment_setup)
2. [Setting up the project.](#java_project_setup)
3. [Starting Contribution.](#java_start_contribution)
4. [Adding new OpenCV operations.](#java_adding_opencv_operator)


<br>

## 1. Setting up the environment <a name="java_enviroment_setup"></a>

This section describes how to setup your environment in order to get started contributions to
ImageLab.

### 1.1 Setup Java on your machine

Java is the primary language that has been used to develop ImageLab. Specifically, we have used java 
1.8.0 since it ships with JavaFX. Moreover, JavaFX has been used to develop the GUI of the ImageLab.

<br>

Run the following commands to verify java version and the runtime.

```
java -version
```

To verify java compilers.

```
javac -version
```

If you're getting an output like below, you can skip this part and continue with maven setup.

![verify_java](assets/ss_verify_java.png)

<br>

If you haven't installed java previously, you need to have **java 1.8.0** in your local machine to run **ImageLab**.

Download java 1.8.0 JDK from [here](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).

<br>
Follow the instruction given below based on your OS.

- [Instruction to setup Java on Windows OS](https://happycoding.io/tutorials/java/setup)

- [Instruction to setup Java on macOS](https://mkyong.com/java/how-to-install-java-on-mac-osx)

- [Instruction to setup Java on windows OS](https://opensource.com/article/19/11/install-java-linux)

<br>

### 1.2 Setting up maven

Maven has been used as the build automation and dependency management tool for ImageLab. 
In order to build and run ImageLab you need to have maven installed on your local machine.


Run following commands to verify that you have installed maven on your machine.

```
mvn -v
```

<br>

 
If you haven't installed maven you need to download maven zip file from
 [here](https://maven.apache.org/download.cgi).
 
**Prerequisites for maven**
- You need to have java installed on your machine.
- Ensure ```JAVA_HOME``` environment variable is set and points to your JDK installation.

**How to setup**

Extract distribution archive in any directory using an archive extraction tool or
running following commands.
```
unzip apache-maven-3.6.3-bin.zip
```

or 

```
tar xzvf apache-maven-3.6.3-bin.tar.gz
```

Add the ```bin``` directory of the created directory
```apache-maven-3.6.3``` to the ```PATH``` environment variable.
 
Confirm with ```mvn -v``` in a new shell. The result should look similar
to the following result.

![verify_java](assets/ss_verify_maven.png)

<br>

**Useful links**

- [Maven installation guidelines](https://maven.apache.org/install.html)
- [IDE configurations for maven](https://maven.apache.org/ide.html)
- [Maven on windows](https://maven.apache.org/guides/getting-started/windows-prerequisites.html)

<br> <br>

## 2. Setting up the project <a name="java_project_setup"></a>
<br>

Cone the repository by pasting following command in your terminal.

```
git clone https://github.com/scorelab/ImageLab.git
```

Open the project in your preferred IDE. It will take a couple of minutes
to sync with the project related maven dependencies.

Then navigate to the project directory in terminal and type following command
to build the project.

```
mvn clean install
```

To run tests

```
mvn clean test
```

To skip tests and run the project.

```
mvn install -Dmaven.test.skip=true
```

Once the project build is successful, in order to execute the project run 
following command in the terminal.

```
mvn exec:java
``` 

<br>

## 3. Starting Contribution <a name="java_start_contribution"></a>

This section contains the information of project structure and its usage. including the contributing guidelines
and good practises related to the project.

Following illustration shows the project folder structure.

![verify_java](assets/ss_project_folder_structure.png)

- ```docs``` - this directory contains the documentation related jekyll site.
- ```src``` - contains the app related java classes.
    - ```main/java``` - contains the application classes.
    - ```main/resources``` - resource files.
 
In the ```main/java/com/imagelab``` we have 
- ```components``` - which contains all the UI elements related classes.
- ```operators``` - openCV operators related classes.
- ```utills``` - utility classes which has been reused in the other classes.
- ```views``` - application views related to the app.
- ```views.forms``` - application views related to properties pane of a particular operator

and 

```App.java```  - contains the main method and other methods to load the FXML resource files related to the 
application GUI. Also, this class contains javaFX related GUI loading functionalities as well.

```DashboardController.java``` - which works as the controller for all the views and it contains the GUI related
functionalities as well.

<br>

## 4. Adding new OpenCV operations <a name="java_adding_opencv_operator"></a>

This section contains the steps to add new openCV operations to the project. Developer has to follow four step procedure 
in order to add a new operator to the appliation.

### 4.1 Add operation to ```imagelab/operators/``` as a java class.

Make sure that your OpenCV operator has clear boundaries and has clear usecases.Decide how the operator should integrate with the pipeline and required opencv packages are included in the dependencies. For more information refer the official OpenCV documentation [OpenCV operations](https://docs.opencv.org/4.5.2/d7/da8/tutorial_table_of_content_imgproc.html).

### 4.2 Extend ```OpenCVOperator``` abstract class. 

In this step you need to implement the methods from the super class which gives you access to
validate --> allowed operators --> compute the logic.

Following is a code snippet which shoes how the demo operator look like.

```
public class OperatorName extends OpenCVOperator{
  
    //To have the logic realted to prevoious operator validation.
     @Override
        public boolean validate(OpenCVOperator previous) {
            return false;
     }

    //To have the openCV processing logic. 
     @Override
         public Mat compute(Mat image) {
             return null;
     }
    
    //To have the allowed operators for this operator.
    @Override
        public Set<Class<?>> allowedOperators() {
            return null;
    }
}
```

In addition to above this operator can hold anything related to the openCV operator
such as information related to the operation or any additional logic.

### 4.3 Add a breif description about the operator to the public enum```Information ```

Use the public enum Information has a ```OPERATOR_INFO``` variable to add the operator desctiption.It will automatically loaded to the information pane when the operator dropped to the pipeline.

Following code snippet code shows the information enum where you need to add the operator description.

```
public enum Information{
	OPERATOR_INFO{
		public String toString() {
			return "Color Maps\n\n" 
                +" Colormaps can apply different color maps to an image using this method.OpenCV caters various other types of colormaps methods where you can find in the properties pane.All these types are represents by predefined static fields(fixed values).";
						
		}
	}
}
```

Now the final code will look like this,

```
public class OperatorName extends OpenCVOperator{
  
    //To have the logic realted to prevoious operator validation.
     @Override
        public boolean validate(OpenCVOperator previous) {
            return false;
     }

    //To have the openCV processing logic. 
     @Override
         public Mat compute(Mat image) {
             return null;
     }
    
    //To have the allowed operators for this operator.
    @Override
        public Set<Class<?>> allowedOperators() {
            return null;
    }

    //Operator description to be display at the information pane
    public enum Information{
        OPERATOR_INFO{
            public String toString() {
                return "Operator desciption";
                            
            }
        }
    }
}

```

### 4.4 Add your operator properties to a separate view form to display at ``PropertiesPane``

In this step, you can define the required properties in order to calibrate your operator. The more properties you provide, it will beneficial for the end user to use the operator in a robust manner. Most importantly, implement the properties with preserving UI/UX aspects. 

As the first step create a java class inside the ``com.imagelab.view.forms`` with a meaningful name and extend that class with ``AbstractPropertiesForm``.

Then include your properties using javafx scene elements and return all the scene elements to the anchorpane using a return function.
To safguard the code quality make sure to comment all your workings.

### 4.5 Add your implemented operator to the controller class

After implementing your OpenCV operation it needs to include to the relevant controller class in order to proceed for the next steps.
When adding to the controllers make sure that to include it for the most suitable operator class. You can investigate the image lab dashboard side bar and decide to which operation category and for what you should insert your newly developed operation.  As an example ```DrawCircle.java``` operator to the ```DrawingOperatorController.java```. 

These are already provided controller classes in the application.

![controller_classes](assets/controllers.png)

If your operator doesn't align with the above controller classes, You can create a new controller class.

Inside a particular controller, create a new function with a proper and meaningful name to register your operator under the desired
controller class.

Following is sample code snippet related to operator registration.

```
//newOperatorName UI element function.
public static OperatorUIElement operatorElementName() {
OperatorUIElement newOperatorName = new OperatorUIElement() {

    @Override
    public AbstractInformationUI buildInformationUI() {
    // return the information pane.
        return null;
    }

    @Override
    public AbstractPropertiesFormUI buildPropertiesFormUI() {
    // return the properties pane.
        return null;
    }
    };
newOperatorName.operator = new OperatorName();
newOperatorName.operatorId = OperatorName.class.getCanonicalName();
newOperatorName.operatorName = "OPERATOR-NAME";
newOperatorName.elementStyleId = "newOperatorName";
newOperatorName.buildElement();
}
// ... other controller functions
}
```

below code snippet despite a usecase of how ```DrawCircle``` OpenCV operator has been added to ```DrawingOperatorController```controller class.

```
public class DrawingOperatorController {
    // controller function for DrawCircle operator
	public static OperatorUIElement drawCircleEffectElement() {
		//drawCircle UI element.
        OperatorUIElement drawCircleEffect = new OperatorUIElement() {
            @Override
            public AbstractInformationUI buildInformationUI() {
                return new InformationContainerView(DrawCircle
                        .Information.OPERATOR_INFO.toString());
            }

            @Override
            public AbstractPropertiesForm buildPropertiesFormUI() {
                return new DrawCirclePropertiesForm((DrawCircle) this.operator);
            }
        };
        drawCircleEffect.operator = new DrawCircle();
        drawCircleEffect.operatorId = DrawCircle.class.getCanonicalName();
        drawCircleEffect.operatorName = "DRAW-CIRCLE";
        drawCircleEffect.elementStyleId = "drawCircle";
        drawCircleEffect.buildElement();
        return drawCircleEffect;
	}
    // other functions

}
```

### 4.6 Register your newly developed operator.

For this you need to navigation to ```imagelab/DashboardController.java``` and register your
newly developed operator under the relevant controller initialize method.

![controller_dashboard_include](assets/controller_dashboard_include.png)

So at the runtime, it will populate at the dashboard side bar under desired operation category.Based on that create a FXML binding in the```DashboardController.java``` and insert the operator to that container to populate it in the dashboard.


### 4.7 Add styles to operator.

Navigate to the ```resources/styles.css``` and add styles with the style ID you assigned when you register
the operator.

### 4.8 Run and play with the newly created operator

Run the ```App.java``` file and see whether your newly created operator is working as expected.

<br>
--------------------------------------------------------------------------------------------------------------------
<br>

# <center>Elctron Project Documentation <a name="elctron_docs"></a></center>

<br>

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

```javascript
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

```javascript
ADD_BORDER:"add_border"
```

- Modify the addOperator function inside the /src/controller/main.js file.

```javascript
case ADD_BORDER:
  this.#appliedOperators.push(
          new ApplyBorder(PROCESS_OPERATIONS.ADD_BORDER, id)
        );
  break;
```

After procceding above steps you can execute the implemented functions in the application.

## Adding Unit Tests

Unit tests are an essential part of ensuring the correctness and reliability of your image processing operators. This section provides a guide on how to add unit tests to the project.

### Prerequisites

1. **Install Dependencies:** If you haven't already, install the necessary dependencies by running the following command in your project's root directory:

   ```sh
   npm install --save-dev jest
   ```

### Getting Started

1. **Create Mocks:** To test image processing operators, create mock implementations for the OpenCv.js dependencies they use. Mock files should be placed in the `tests/unit/opencv-mocks/` directory. For each type of operator, create a mock file following this structure:
```bash
    tests/
    |-- unit/
    |   |-- opencv-mocks/
    |       |-- basic.mock.js
    |       |-- blurring.mock.js
    |       |-- conversions.mock.js
    |       |-- drawing.mock.js
    |       |-- filtering.mock.js
    |       |-- geometric.mock.js
    |       |-- thresholding.mock.js
```
2. **Write Unit Tests:** In the `tests/unit/ directory`, create test files for each operator. Name your test files using the format `<OperatorName>.test.js`. Here's an example of a generic unit test file:
    ```javascript

    //tests/unit/ExampleOperator.test.js
    const ExampleOperator = require('../../src/operators/ExampleOperator');
    const opencvMock = require('./opencv-mocks/example.mock'); // Adjust the path

    describe('ExampleOperator', () => {
      afterEach(() => {
        jest.clearAllMocks();
      });

      it('should apply example operator', () => {
        // Your code goes here
      });
      // Add more test cases as needed
    });
    ```

4. **Run Unit Tests:** Execute your unit tests using the following command:
    ```bash
    npm test -- --config=jest.config.js
    ```


## ⛏️ Built Using <a name = "built_using"></a>

- [<img align="left" alt="linked-in" src="https://img.shields.io/badge/Electron-191970?style=for-the-badge&logo=Electron&logoColor=white" />](https://www.electronjs.org/)
- [<img align="left" alt="linked-in" src="https://img.shields.io/badge/NPM-%23000000.svg?style=for-the-badge&logo=npm&logoColor=white" />](https://www.npmjs.com/)
- [<img align="left" alt="linked-in" src="https://developers.google.com/blockly/images/logos/logo_standard.svg" height= "30" />](https://developers.google.com/blockly)

<br>
--------------------------------------------------------------------------------------------------------------------
<br>

# <center>React Project Documentation <a name="react_docs"></a></center>

<br>

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

<br>
--------------------------------------------------------------------------------------------------------------------
<br>

# <center>Updating Docs <a name="updating_docs"></a></center>

This section contains the steps to update documentation related to this project.

###  Prerequisites for the docs site.

You need to install following technologies in order to run the docs site locally.

- Ruby 2.7
    - [Setup Ruby on macOS](https://gorails.com/setup/osx/10.15-catalina)
    - [Setup Ruby on Windows](https://gorails.com/setup/windows/10)
    - [Setup Ruby on Linux/Ubuntu](https://gorails.com/setup/ubuntu/20.04)
- Jekyll 4.1
    - [Setup Jekyll on macOS](https://jekyllrb.com/docs/installation/macos)
    - [Setup Jekyll on Windows](https://jekyllrb.com/docs/installation/windows)
    - [Setup Jekyll on Linux/Ubuntu](https://jekyllrb.com/docs/installation/ubuntu)
    
###  Run Documentation offline.

To install relevant dependencies run the following command.
```
bundle install
```

```
bundle update
```

To run the documentation jekyll website, run following command.
```--livereload``` flag will enable you to populate your changes realtime on your browser.

```
bundle exec jekyll serve --livereload
```

This site will run on your browser at ```localhost:4000```

<br>
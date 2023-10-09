<p align="center">
  <img src="./ImageLab.png" alt="ImageLab source" width="250px" height="250px"/>
</p>

# ImageLab

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Gitter](https://badges.gitter.im/scorelab/ImageLab.svg)](https://gitter.im/scorelab/ImageLab?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
[![GitHub issues by-label][hacktoberfest-badge]][hacktoberfest-link]
  

### Introduction to the project:

ImageLab is a standalone tool which supports anyone to get started with image processing related concepts and techniques in an interactive, less logical way. So, this tool enables and also motivates the fresh users to understand how image processing concepts work by interacting with ImageLab. Moreover, for the users who are already comfortable with image processing tasks ImageLab offers a test environment before they move ahead with actual implementation or development.

### Preview - Java App

![demo](docs/assets/Demov2.gif)

### Preview - Electron App

Here, you can see the new design of ImageLab by using Blockly and ElectronJS.

<video src="https://user-images.githubusercontent.com/43797542/130302770-b43a8ee4-fb59-4af2-b804-20e1847866f4.mp4" controls="controls" style="max-width: 730px;"></video>

#### Apache 2.0 Licence

See the [LICENSE](https://github.com/scorelab) file for details.

## Supported Image Processing Operations

- Basic Read/Write operation
- Image Conversion
- Image Smoothing
- Geometric Transformation operation
- Drawing operation
- Filtering operation
- Thresholding operation
- Transformation operations
- Contour operation
- Miscellaneous operation
- Histogram operation

## Project Documentation

Complete setup guidelines and other details can be found in the **[project documentation](https://scorelab.org/imagelab/)**.

### Technologies

You need to setup following technologies in order to run this project and start contribution.

| Technology   | Version              |
|--------------|----------------------|
|              |                      |
| Java         | 1.8                  |
| JavaFX       | 1.8 JDK (inbuilt)    |
| OpenCV       | 3.2.0                |
| Apache Maven | 3.6.3                |
| Ruby         | 3.6.3                |
| Jekyll       | 4.1.1                |
| Electron     | 13.1.6               |
| Blockly      | 6.20                 |

### Setup Guidelines - Java App

Clone the repository by pasting following command in your terminal.

```
git clone https://github.com/scorelab/ImageLab.git
```

Open the project in your preferred IDE. It will take a couple of minutes
to sync with the project related maven dependencies.

Then navigate to the project directory ( imagelab_java ) in terminal and type following command
to build the project.

```
mvn clean install 
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

In case of "Failed during checkstyle execution" after firing mvm clean install
Follow :

Modify pom.xml 

```
mvn clean install --% -Dcheckstyle.skip

```
and then 

```
mvn exec:java

```


Check the **[project documentation](https://scorelab.org/imagelab/)** for more instructions.

### Setup Guidelines - Electron App

Clone the repository by pasting following command in your terminal.

```
git clone https://github.com/scorelab/ImageLab.git
```

ImageLab uses ElectronJS. so we do some additional steps to get it compatible with our project:

To use Electron, you need to install Node.js from [here](https://nodejs.org/en/download/). (We recommend that you use the latest LTS version available.)

To check that Node.js was installed correctly, type the following commands in your terminal client:

```
node -v
npm -v
```

Above commands should print the versions of Node.js and npm accordingly.

\*Note: Since Electron embeds Node.js into its binary, the version of Node.js running your code is unrelated to the version running on your system.

Then you open your terminal and refer to the directory of [`/imagelab/imagelab_electron`](https://github.com/kaveeshadinamidu/imagelab/tree/master/imagelab_electron) on your machine using `cd` command.

```
cd imagelab_electron/
```

Then, you start installing packages used in the project:

You can install all the npm packages once by running

```
npm install
```

Check the **[project documentation](https://scorelab.org/imagelab/)** for more instructions.


[<--# Generic Links -->]: #
[hacktoberfest-link]: https://github.com/scorelab/ImageLab/issues?q=is%3Aissue+is%3Aopen+label%3Ahacktoberfest
[hacktoberfest-badge]: https://img.shields.io/github/issues-raw/scorelab/ImageLab/hacktoberfest.svg?label=Hacktoberfest&color=purple

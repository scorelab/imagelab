# ImageLab

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Gitter](https://badges.gitter.im/scorelab/ImageLab.svg)](https://gitter.im/scorelab/ImageLab?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

  

### Introduction to the project:

ImageLab is a standalone tool which supports anyone to get started with image processing related concepts and techniques in an interactive, less logical way. So, this tool enables and also motivates the fresh users to understand how image processing concepts work by interacting with ImageLab. Moreover, for the users who are already comfortable with image processing tasks ImageLab offers a test environment before they move ahead with actual implementation or development.

#### Apache 2.0 Licence

See the [LICENSE](https://github.com/scorelab) file for details.

## User Guide

You need to setup following technologies in order to run this project and start contribution.

| Technology   | Version |
|--------------|---------|
| Java         | 11      |
| JavaFX       | 13      |
| OpenCV       | 3.2.0   |
| Apache Maven | 3.6.3   |


#### How to Setup

Setup `$JAVA_HOME` in your *.**zshrc*** or *.**bash_profile**:* 

check whether you have installed and setup path properly by running
`java --version` and `javac --version`

make sure you have setup Apache Maven by runing `mvn -v`. If not follow [this](https://maven.apache.org/install.html) and install maven.

Clone the repository.
`git clone https://github.com/scorelab/ImageLab`

in the project directory, run following commands to build and run the project.

`mvn run` or `mvn package`

`mvn compile`

`mvn clean javafx:run`


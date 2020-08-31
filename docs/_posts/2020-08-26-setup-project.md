---
layout: post
title: ImageLab Documentation
---

<br>Documentation contains steps to setup your environment and get started with contributions.
Please make sure, you have joined the project's official gitter channel for further discussions
related to the project.

[![Gitter](https://badges.gitter.im/scorelab/ImageLab.svg)](https://gitter.im/scorelab/ImageLab?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
<br>


1. Setting up the environment.
2. Setting up the project.
3. Starting Contribution.
4. Adding new OpenCV operations.
5. Updating Docs.

<br>

## 1. Setting up the environment

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

## 2. Setting up the project 
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

## 3. Starting Contribution

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

and 

```App.java```  - contains the main method and other methods to load the FXML resource files related to the 
application GUI. Also, this class contains javaFX related GUI loading functionalities as well.

```DashboardController.java``` - which works as the controller for all the views and it contains the GUI related
functionalities as well.

<br>

## 4. Adding new OpenCV operations

This section contains the steps to add new openCV operations to the project.

### 4.1 Add operation to ```imagelab/operators/``` as a java class.

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

### 4.3 Register your newly developed operator.

For this you need to navigation to ```imagelab/DashboardController.java``` and register your
newly developed operator in the initialize method.

Following is sample code snippet related to operator registration.

```
//newOperatorName UI element.
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
```

### 4.4 Add it to the relevant UI container.

In this step you can investigate the image lab dashboard side bar and decide to which operation category
you should insert your newly developed operation. Based on that create a FXML binding in the
 ```DashboardController.java``` and insert the operator to that container to populate it in the dashboard.

### 4.5 Add styles to operator.

Navigate to the ```resources/styles.css``` and add styles with the style ID you assigned when you register
the operator.


<br>
<br>

## 5. Updating Docs

This section contains the steps to update documentation related to this project.

### 5.1 Prerequisites for the docs site.

You need to install following technologies in order to run the docs site locally.

- Ruby 2.7
    - [Setup Ruby on macOS](https://gorails.com/setup/osx/10.15-catalina)
    - [Setup Ruby on Windows](https://gorails.com/setup/windows/10)
    - [Setup Ruby on Linux/Ubuntu](https://gorails.com/setup/ubuntu/20.04)
- Jekyll 4.1
    - [Setup Jekyll on macOS](https://jekyllrb.com/docs/installation/macos)
    - [Setup Jekyll on Windows](https://jekyllrb.com/docs/installation/windows)
    - [Setup Jekyll on Linux/Ubuntu](https://jekyllrb.com/docs/installation/ubuntu)
    
### 5.2 Run Documentation offline.

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



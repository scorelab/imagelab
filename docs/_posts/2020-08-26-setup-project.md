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

<br>

## 3. Starting Contribution

<br>

## 4. Adding new OpenCV operations

<br>

## 5. Updating Docs

<br>



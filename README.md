<p float="left">
  <img src="https://i.imgur.com/SPWjabr.png" width="500" height="250" title="Code_School_Logo">
</p>

## BrowserStack TestNG Web Project

### Introduction

This code is an example of the Page Object Model principle applied to our tests written thus far.

### Necessary Tools

There are a few things that you will need before you can get started.

* Maven - use [this](https://maven.apache.org/install.html) guide for both Windows and Mac. For anyone having difficulty, [this](https://www.baeldung.com/install-maven-on-windows-linux-mac) is a more detailed breakdown of the steps.
* Git for pulling down the code - follow [this](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) guide for installing Git on all platforms. There are other useful guides on the website mentioned previously. Start [here](https://github.com/git-guides) anad follow through to the various links to learn more about Git. It will be very useful on your automation journey. If you have any issues with tokens or user credentials, let me know as this can trip a lot of people up.
* The path branches here. There are 2 options:
  * IntelliJ - You can download IntelliJ for free from [here](https://www.jetbrains.com/idea/download/#section=mac).
  * Eclipse - You can download Eclipse for free from [here](https://www.eclipse.org/downloads/).
  * They will both be able to run the code we will create in these sessions. I will be using IntelliJ but I will also try to reference Eclipse where possible.
* Java JDK - You can download the JDK directly from the Oracle website [here](https://www.oracle.com/java/technologies/downloads/). This will allow you to run Java applications on your machine.
* ChromeDriver - this is the web driver that will be used to open Chrome and do the test locally. You can download it from [here](https://chromedriver.chromium.org/downloads). Remember to grab the version that matches your installed browser.

### Installation

To get the project ready to run on your machine, follow the steps below:

* Open a terminal. (Terminal on Mac, Command Prompt on Windows)
* Go to the directory where you want to place the code using [cd](https://docs.microsoft.com/en-us/windows-server/administration/windows-commands/cd) for Windows, and it functions mostly the same for Mac. You just use "cd" but the folder structure on Mac is different (/Users/username/Documents instead of C:/Users/username/Documents)
* Copy the following command into the terminal, (remember, you must have [Git](https://git-scm.com/downloads) installed)

```sh
git clone https://github.com/Framework-Demos/testng-web-project.git
```
* Move into the directory that you just cloned by typing
```sh
cd testng-web-project
```
* To run your test, you can use the Run button in your IDE of choice or right click anywhere in your file and click Run.
* Alternatively, you can run the tests from the command line using Maven. To do this, type the following command in your terminal:

```sh
mvn clean test -P sample-test
```

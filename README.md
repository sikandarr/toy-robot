# Toy Robot Simulator
The solution in this repository is an implementation of the **Toy Robot** programming exercise from the **REA Group.** For a more detailed description of the problem see PROBLEM.md

## Getting Started

### Pre-requisites
- JDK 8 is required to run the program.
- You must ensure that JAVA_HOME path is setup correctly to locate your JDK installation.

> The program uses gradle build tool and comes pre-installed with the gradle-wrapper and hence does not require an installation of Gradle.

### Running the application

1. Download the latest release.

2. To run the tests and build the application issue the following commands from the root of the project's folder:

> ```gradlew build```

This will create a runnable JAR file in the ``PROJECT_ROOT/build/lib``

3. You can then run the JAR using the following command to run the application in interactive mode:

>  ```java -jar :path-to-jarfile```

4. More Usage Options:

The application can also be run with the following options:

```-f :path-to-inputfile``` Instructs the program to read the commands from user provided inputfile.

```-l :path-to-folder``` Creates a file with the log output in the specified folder (the folder must exist).

Example:

> ```java -jar :path-to-jarfile -f C:\input.txt -l C:\Log\```

## External Libraries

The project liberally uses the fantastic [Project Lombok](https://projectlombok.org)  java library which helps in significantly reducing the amount of boiler-plate code required by adding methods for getters, setters, equals and hash, constructors, and even builders etc. and hence allowing for improved readability and better management of the code and generally clean code. 

## Design & Architecture

The application is designed using the Model-View-Controller architecture pattern where the components of the system are layered using the semantics of MVC to allow division between the presentation layer and the domain model for better management of codebase and furture extensions. The program has also made use of builder, factory, observer, and strategy design patterns (see DESIGN.md for further notes).

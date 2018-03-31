# Toy Robot Simulator
The solution in this repository is an implementation of the **Toy Robot** programming exercise from the **REA Group.** For a more detailed description of the problem see PROBLEM.md

## Getting Started

### Pre-requisites
- JDK 1.8 is required to run the program.
- You must ensure that JAVA_HOME path is setup correctly to locate your JDK installation.

> The program uses gradle build tool and comes pre-installed with the gradle-wrapper and hence does not require an installation of Gradle.

### Running the application

1. Download the latest release.

2. To run the tests and build the application issue the following commands from the root of the project's folder:

> ```gradlew build```

This will create a runnable JAR file in the ``PROJECT_ROOT/build/lib``

3. You can then run the JAR using the following command:

>  ```java -jar :path-to-jarfile```

The above will run the application in interactive mode where you can issue the program's commands on the console; you can provide the name of the file containing a list of commands as input to the program with the following command:

> ``` java -jar :path-to-jarfile :path-to-inputfile```

## Design & Architecture

The application is designed using the Model-View-Controller architecture pattern where the components of the system are layered using the semantics of MVC to allow loose coupling of these components for better management and furture extensions. The program has also made use of builder, factory, observer, and strategy design patterns.

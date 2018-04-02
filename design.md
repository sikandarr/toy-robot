## Design & Architecture ##

### A Note ###
The purpose of any software architecture is to make the program flexible enough to respond to changes by enabling it to accommodate changes; what separates a good design from a bad one is that it is responsive to change without it breaking the entire codebase. But despite the academic rigor involved in the study of software engineering as a discipline design decisions are not an exact science and require envisaging future changes on part of the developer; and in a problem as abstract as our current case some conjecture – for example, could this simple exercise evolve into a game where multiple robots combat each other? But conjecture aside, there are generally agreed upon design principles in an object oriented software design that allow for better organization of the code and future extensions: separation of concerns, loose coupling, SOLID principles, favoring abstraction over implementation etc. 

### The Model ###
This system is designed using the principles of Model-View Controller to separate the concerns of presentation and the domain model. Although the comments in the source code provide useful briefs on the fundamental aspects of the View, the Controller, and the Models it’s useful to view the domain model in its entirety to get a holistic picture and hence introduced here the Models of the system.

* ##### Surface ####
A surface represents a map in our domain on which the objects are placed. It is an abstraction of the table from the problem description. Surface is an interface that requires implementing classes to provide logic to check whether a given position falls within its area. This allows surfaces of varying shapes to be used in the application.


* #### Surface Object ###
A surface object is any object placed on the surface. It’s a partial abstraction of the toy robot from the problem description. A surface object can perform actions such as move on the coordinates and rotate.

* #### Direction ###
Direction is an enumeration of cardinal directions of North, South, East, and West. The surface objects when placed on the surface are always facing in one of these directions.

* #### Position ###
Position is the precise location of surface object which includes the x, y coordinates and one of the cardinal directions.

### A Note on Simulation Package ###
The classes and interface of the primary model form the ‘core-library’ of our application and have been packaged as model. The simulation package provides concrete implementations and uses the services of the core models. It also contains interfaces and classes that govern the physical laws and movements in the system using the Action and ValidationService interfaces.

### Flow of the program: ###
* An input is entered by the user.
* The view receives the input and sends it to the controller.
* The controller sends the input to the command interpreter.
* The command interpreter:
  * Injects the action and the robot into the command and returns it to the controller.
  * Registers the required validation service as observers for the action.
* The controller executes the command by calling it’s execute method.
* The execute method of the command calls the robot’s perform action method and passes the action as a parameter.
* The robot checks if it can perform the specified action and calls the Action’s perform method.
* The perform method calls on the services of the registered validations to validate the actions and updates the state of the robot.
* The control now returns to the controller which checks if a response needs to be updated and calls the view’s update method.
* The control now returns to the view which will read the next command.

### What Changes? ###

The application can easily accommodate the following changes:
* A table of varying shapes and sizes; 3D objects will require further deliberation.
* Multiple objects on the table; with the ability to perform or not perform some actions.
* New actions, for example moving in reverse.
* New commands with some commands that combine multiple actions without a change in the source code of actions; for example, a knight-like chess move.
* New validations that can be called using the observer pattern, for example collision detection.

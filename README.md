Cs2140
======

This will be the repo to hold the code for the prototype for CS2140

Below is an excerpt from the Design document outline some of the classes to be implemented 

3.2 Class Library

3.2.1 Employee

Identification	LVC.interfaces.Employee

Type	Interface
Purpose	Supertype for Managers and Developers: both categorized by employee status at JK System Solutions.
Function	Simply a Java interface that provides a contract for action items and sub-projects.  Allows the GUI to categorize both as sub-tasks of a project.
Subordinates	Manager, Developer
Dependencies	The GUI will make use of this interface while interacting with employees assigned to work or manage a project.
Interfaces	Classes that implement Employee will have methods and fields for getting and setting the name and ID.
Resources	None.
Processing	None.
Data	N/A

3.2.2 Manager

Identification	LVC.classes.Manager
Type	Class
Purpose	Represents a manager and encapsulates all necessary data for a manager.
Function	A manager has the following data items. The field will be accessed and mutated via JavaBean-like get and set methods. There will also be a predicate method for verification.
•	manager_code
Subordinates	N/a
Dependencies	Relies on the Employee class to provide it’s ID
Interfaces	Employee
Resources	None.
Processing	None.
Data	N/A

3.2.3 Developer

Identification	LVC.classes.Developer
Type	Class
Purpose	Represents a developer and encapsulates all necessary data for a developer.
Function	A developer has the following data items. The field will be accessed and mutated via JavaBean-like get and set methods. There will also be a predicate method for verification.
•	developer_code
Subordinates	N/a
Dependencies	Relies on the Employee class to provide it’s ID
Interfaces	Employee
Resources	None.
Processing	None.
Data	N/A


3.2.4 Project

Identification	LVC.classes.Project
Type	Class
Purpose	Represents a project and encapsulates all necessary data for a project.
Function	A project has the following data items. The field will be accessed and mutated via JavaBean-like get and set methods. There will also be predicate methods for verification.
•	project_code
•	title 
•	code_list
•	developers
•	tasks
•	manager
Subordinates	N/a
Dependencies	Relies on the Task class to provide various subtasks to developers. Also relies on the manager and the developer class to identify employees assigned to the project.
Interfaces	Server
Resources	None.
Processing	None.
Data	N/A


3.2.5 Task

Identification	LVC.classes.Task
Type	Class
Purpose	Represents a task and encapsulates all necessary data for a task.
Function	A task has the following data items. The field will be accessed and mutated via JavaBean-like get and set methods. There will also be predicate methods for verification.
•	title
•	developer_list
•	content
Subordinates	N/a
Dependencies	Relies on the Developer class.
Interfaces	Employee
Resources	None.
Processing	None.
Data	N/A

3.2.6 Report

Identification	LVC.classes.Report
Type	Class
Purpose	Represents a report and encapsulates all necessary data for a report.
Function	A developer has the following data items. The field will be accessed and mutated via JavaBean-like get and set methods. There will also be a predicate method for verification.
developer_code
Subordinates	N/a
Dependencies	Relies on the Project class.
Interfaces	Employee
Resources	None.
Processing	None.
Data	N/A


3.2.6 Server

Identification	LVC.interfaces.Server
Type	Class
Purpose	To control communication with the server application.
Function	The class will contain CRUD methods to send commands to the server application. These methods will be implemented in subclass. 

Subordinates	Project
Dependencies	N/a
Interfaces	N/a
Resources	None.
Processing	None.
Data	N/A


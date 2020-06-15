# JSP-Servlets-JSTL-Project

This is a personal project to practice with JSP/Servlets/JSTL in a web-app application using Tomcat. This is the main focus so no fancy HTML or CSS is attempted.

It´s a simple CRM tool for a car garage to manage cars, owners and services performed to the cars.
The entities classes are: Car, Owner and Services.
Servlets classes: LoginServlet(/login), Dashboard(/dashboard), OwnersServlet(/owners), CarsServlet(/cars), ServicesServlet(/services), LogOutServlet(/logout).

The database used is MySQL, with DataSource and connection pooling, set with context.xml file and with a DatabaseUtil class. DataSource instance is created once the first time one user logs in and is passed from one servlet to the other as a session attribute. 
There are three tables: owner, car, service. Car has a foreign key to owner, while service has to car.
At this level, all CRUD operations can be performed with owners entities. Deleting an owner implies deleting all records in "service" and "car" table that depend on it. 
With car and service entities, at this level, are available Create, Read and Delete operations. Further steps would develop Update operation for cars and services, with a different view page for this purpose.
Planned further steps include storing all deleted records in "recovery database", 

I´ve implemented a "from scratch" login and security logic, so no access to any of the resources can be achieved without a validated logged in status. At this level the username and password are hardcoded in the LoginServlet, but further steps should implement  storing the usernames and passwords in the database, as well as functionalities to create new user profiles, maybe from the administrator profile, which should have more privileges than other users. 

Basic front end JS validation for some of the forms is already being used, and some server side error handling when introduced values are not the correct data type, but further steps should improve both front and back end. 

# Music 🎶 streaming service API :-
* Swagger
- http://3306:8080/swagger-ui.html#/
## Frameworks and language used:
-  Java
-  Spring Boot
-  SQL database
-  Postman
-  Swagger
## Data Flow


* **Model** :
  There are Four Models class in this application.
    * Users Model Class.
    * Status Model Class.
    * Role Model Class.
    * Songs Model Class.


* **Controller** :

  There are Five Controller classse in this application.

    * AdminController Class.
    * UsersController Class.
    * StatusController Class.
    * SongsController class.
    * RoleController class. 


* **Interfaces** :

  There are Four Interfaces in this application.
    * IUsersInterface Interface.
    * IStatusInterface Interface.
    * IRoleInterface Interface.
    * ISongInterface


* **Service** :

  There are Frou Service class in this application.

    * UsersService Class.
    * StatusService Class.
    * RoleService Class.
    * SongsService Class
  


* **Repository** :

  There are Four Repository Interfaces in this application.

    * IUsersRepository Interface.
    * IStatusRepository Interface.
    * ISongsRepository Interface.
    * IRoleRepository Interface


* **Util/Validation** :
    * In this application I'm using annotations based validation with manual validations for more safety and to keep continuty in data .



* **GlobalExceptionHandler class** :
  * In this class i have handled the exceptions that generates in project.



* **Database**

    * I have used SQL Database to store the data.
    * I have deployed this project on AWS EC2 machine.

## Project Summary

This project is a music streaming service API that allows two types of users: Normal and Admin users. Admin users have the authority to perform CRUD (Create, Read, Update, and Delete) operations on songs, while normal users can only add songs to their playlists and perform CRUD operations on their playlists.

The API is built using MySQL database to store songs and user playlists, and its IP address of the deployment link must be static to ensure its availability. Additionally, the API uses annotation-based validation to ensure that all user inputs are valid before being processed.

The project structure includes a controller service and a repository, providing a clear separation of concerns and making the code more modular. Furthermore.

To ensure data security and user data privacy, normal users cannot create or do CRUD operations on songs, and only Admin users have the necessary permissions to perform these actions. This ensures that the API is both secure and user-friendly.

Overall, this project provides a scalable and secure API for music streaming services that allows users to manage their playlists effectively while ensuring the safety of their data.




  













  

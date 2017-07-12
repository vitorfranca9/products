## README ##

#### How to run? ####

> - You need your environment variables already configured (JAVA_HOME, MAVEN_HOME) 
> - Open command shell
> - Go to your application root directory(e.g.): 

    cd C:\Users\Vitor\git\products

> - Execute the following command:

    mvn spring-boot:run

#### Testing ####
> - Open command shell
> - Go to your application root directory(e.g.): 

    cd C:\Users\Vitor\git\products

> - Execute the following command:

    mvn test

#### API Documentation ####

> With your application running, you can also access the api docs and run the services using the following link:

>> [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

>More information at: [https://swagger.io/docs/](https://swagger.io/docs/)

#### H2 Database ####

> With your application started, you can access your database using the following link:

>> [http://localhost:8080/h2-console](http://localhost:8080/h2-console) 

> To connect, use the following parameters:

>> Saved Settings: `Generic H2 (Embedded)`

>> Setting Name: `Generic H2 (embedded)`	

>> Driver Class: `org.h2.Driver`

>> JDBC URL: `jdbc:h2:mem:productsdb`

>> User Name: `sa`

>> Password:

#### Who do I talk to? ####
vitorfranca9@gmail.com
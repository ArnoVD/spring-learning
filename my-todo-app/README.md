# To start the project using the H2 database:
1. Uncomment the following line in application.properties:```spring.datasource.url=jdbc:h2:mem:testdb```
2. Comment these lines:
```spring.datasource.url=jdbc:mysql://localhost:3306/task
   spring.datasource.username=arno
   spring.datasource.password=root
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   spring.jpa.hibernate.ddl-auto=update
```
3. Run the project
4. Go to http://localhost:8080/h2-console
5. Make sure the url is: ```jdbc:h2:mem:testdb```
5. Login with sa and no password and click connect
6. The data.sql and schema.sql should make the table 'task' and insert a few rows

# To start the project using the MySQL database:
1. Comment the following line in application.properties:```spring.datasource.url=jdbc:h2:mem:testdb```
2. Uncomment these lines:
```spring.datasource.url=jdbc:mysql://localhost:3306/task
   spring.datasource.username=arno
   spring.datasource.password=root
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   spring.jpa.hibernate.ddl-auto=update
```
3. Run the project
4. Make sure the docker container is running with the MySQL database by running ```docker container ls```
5. If its not running check the commented code in application.properties and make sure the username and password are correct 
6. Open terminal
7. Run ```mysqlsh```
8. Run ```\connect arno@localhost:3306```
9. Run ```\use task```
10. Run ```\sql```
11. Run ```select * from task;```

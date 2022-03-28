# Migros Case Project

## Database Configuration
The project using the H2 database. The db name is migrosdb and it is working with default configurations.
For help on other issues related to the H2 database, you can go to the relevant link:
https://www.baeldung.com/spring-boot-h2-database


## Application Configuration
The project is developed with Spring Boot. If you start the project on your localhost, 
you can access on the 8080 port. 

## Endpoints:

### Save Store:
````
POST /api/store HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 91

{
    "name": "Capacity MMM Migros",
    "lat": "47.6651566",
    "lng": "26.1655118"
}
````

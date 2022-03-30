# Migros Case Project

## Database Configuration
The project using the H2 database. The db name is migrosdb and it is working with default configurations.
For help on other issues related to the H2 database, you can go to the relevant link:
https://www.baeldung.com/spring-boot-h2-database


## Application Configuration
The project is developed with Spring Boot. If you start the project on your localhost, 
you can access on the 8080 port. 

## Endpoints:

###Store Services;

#### Save Store:
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

#### Get All Stores:
````
GET /api/store HTTP/1.1
Host: localhost:8080
````


###Courier Services;

#### Save Courier:
````
POST /api/courier HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 166

{
    "time": "2022-01-01T22:45:59",
    "geolocation": {        
        "lat": 40.986116,
        "lng": 29.1161294
    },
    "courier": "Courier Rıdvan2"
}
````

#### Get All Couriers:
````
GET /api/courier HTTP/1.1
Host: localhost:8080
````

#### Get Courier Total Distance:
````
GET /api/courier/distance/Courier Rıdvan2 HTTP/1.1
Host: localhost:8080
````


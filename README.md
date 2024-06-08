# CSV-Reader

## Overview

Welcome to **CSV-Reader**! This application provides four APIs designed to perform specific tasks. The application is built using Spring Boot and can be run using Maven.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Installation

1. **Clone the repository**

   ```sh
   git clone https://github.com/masoud-shayan/csv-reader.git
   cd csv-reader
   ```


2. **Run the application** 

Use the following command to run the application:

   ```sh
   mvn spring-boot:run
   ```

This command will start the Spring Boot application on your local machine.

## API Documentation
To explore the available APIs and see how to interact with them, please refer to the Swagger documentation:

[Swagger UI](http://localhost:9090/swagger-ui/index.html)

The Swagger UI provides a user-friendly interface to test and understand the APIs.

### Available APIs
Here is a brief overview of the four APIs provided by this application:

1. **API 1**

   ##### Endpoint: /api/v1/csv
   ##### Method: GET
   ##### Description: fetch all uploaded csv files data

2. **API 2**

   ##### Endpoint: /api/v1/csv/{code}
   ##### Method: GET
   ##### Description: fetch cvs row by its code

3. **API 3**

   ##### Endpoint: /api/v1/csv
   ##### Method: POST
   ##### Description: upload a cvs file to persist the data

4. **API 4**

   ##### Endpoint: /api/v1/csv
   ##### Method: DELETE
   ##### Description: delete all the inserted data
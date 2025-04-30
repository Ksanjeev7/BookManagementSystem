# BookManagementSystem Using SpringBoot
  A RESTful API service for managing books built with Spring Boot.

## Features

- CRUD Operations for Books
- Partial Updates using PATCH
- Error Handling with Custom Exceptions
- Timestamp Management for Created and Updated times
- Validation for Book entities


## Tech Stack

- Java 8+
- Spring Boot
- Spring Data JPA
- MySQL Database
- Maven
- Hibernate

## API Endpoints


| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /api/books | Get all books |
| GET    | /api/books/{id} | Get book by ID |
| POST   | /api/books | Create new book |
| PUT    | /api/books/{id} | Update book (full update) |
| PATCH  | /api/books/{id} | Update book (partial update) |
| DELETE | /api/books/{id} | Delete book |


## Project Structure
```
src/
├── main/
│ ├── java/
│ │    └── com/sanju/main/
│ │       ├── controller/
│ │       ├── service/
│ │       ├── repository/
│ │       ├── entity/
│ │       ├── exceptions/
│ │   └── BookManagementSystemApplication.java
│ └── resources/
│ └── application.properties

```
## Setup and Installation

1. Clone the repository
```bash
git clone https://github.com/Ksanjeev7/BookManagementSystem
```
2.Configure MySQL database in application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```
3. Build Project
```
mvn clean install
```

4. mvn clean install
```
mvn spring-boot:run
```

## API Example for Add

```
POST /api/books
{
    "title": "Sample Book",
    "author": "John Doe",
    "genre": "Fiction",
}

```
### Error Handling

  The APIs includes comprehensive error handling for with status codes:

- Book not found

- Validation errors

- Server errors





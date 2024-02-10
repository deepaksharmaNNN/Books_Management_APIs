
# Book Management APIs


This project is a simple Spring Boot application for managing books. It provides APIs for creating, updating, retrieving, and deleting books. The application uses Spring Web, JPA, H2 database, and Lombok.



## Features

- Create, update, retrieve, and delete books.
- Uses H2 database for easy setup.
- Follows best practices for Spring Boot development.
- Utilizes Lombok for reducing boilerplate code.


## Usage/Examples
The application can be run by executing the main method in the BooksManagementApisApplication class:

```java
@SpringBootApplication
public class BooksManagementApisApplication {

  public static void main(String[] args) {
    SpringApplication.run(BooksManagementApisApplication.class, args);
  }
}
```
The server will start on port 8080 by default. The port can be configured in application.properties.


## API Endpoints
Create or Update a Book:

- PUT /newBook

    Example Request Body:

```
{
    "isbn": "123456",
    "author": "John Doe",
    "title": "Spring Boot Essentials"
}
```
Find a Book by ISBN:

- GET /findBook?isbn=123456

Get All Books:

- GET /books
Delete a Book by ISBN:

- DELETE /deleteBook?isbn=123456
## Use it
Clone the project

```bash
  git clone https://github.com/deepaksharmaNNN/Books_Management_APIs.git
```

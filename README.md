Book Management APIs
This is a book management REST API built with Spring Boot and uses a H2 in-memory database.

Features
CRUD APIs for books
Automatically creates schema and populates some test data
In-memory H2 database is used
Project Lombok for minimal boilerplate code
Usage
Running the application
You can run the application by executing the main method in the BooksManagementApisApplication class from your IDE.

The server will start on port 8080 by default. You can configure the port in application.properties.

APIs
The API endpoints are:

POST /books - Create a new book
GET /books - Get all books
GET /books/{isbn} - Get a book by ISBN
PUT /books - Update an existing book
DELETE /books/{isbn} - Delete a book by ISBN
The Book model has isbn, title and author attributes.

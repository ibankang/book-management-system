# Book Management System API

The **Book Management System** is a RESTful web application designed for managing books in a library system. It allows users to perform basic CRUD (Create, Read, Update, Delete) operations on book data, along with search, pagination, and sorting functionalities. The API is designed to be scalable, handling large datasets effectively with pagination and offering a smooth experience for users interacting with the system.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [API Endpoints](#api-endpoints)
- [Pagination and Sorting](#pagination-and-sorting)
- [Setting Up the Project](#setting-up-the-project)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

The Book Management System provides a set of functionalities to manage books in a library. Users can add, update, delete, and retrieve books. The system is built to support large libraries through the use of pagination and sorting, which enables users to filter and organize book data as per their requirements.

The system also allows searching for books by keyword, making it easier to find specific books in a large dataset.

### Features

- **Add a Book**: Allows users to add new books to the system by providing the book's details.
- **Get All Books**: Retrieves a list of books from the system with options for pagination and sorting.
- **Search Books**: Allows users to search for books by a given keyword (e.g., title, author, etc.).
- **Get Book by ID**: Fetches a specific book based on its unique identifier.
- **Update a Book**: Updates the details of an existing book.
- **Delete a Book**: Deletes a book from the system by its unique identifier.

## Technologies Used

- **Java 23**: Programming language used for building the backend application.
- **Spring Boot**: A framework for building RESTful applications, which simplifies the development process.
- **Spring Data JPA**: Used for interacting with the database through repositories.
- **Spring Web**: Provides support for creating RESTful web services.
- **H2 Database**: A lightweight, in-memory database used for development.
- **JUnit 4**: A framework for writing and running unit tests.
- **Mockito**: A mocking framework for unit tests.
- **Maven**: A build tool used for dependency management and building the project.

## API Endpoints

### 1. Add a New Book
This endpoint allows the creation of a new book record in the system. It requires the user to provide details like the book's title, author, and price.

### 2. Get All Books
This endpoint retrieves a list of all books stored in the system. It supports pagination, allowing users to get a specific number of books at a time. Additionally, it supports sorting the books based on specific fields such as title or price.

### 3. Get Book by ID
This endpoint retrieves a specific book by its unique identifier (ID). If the book exists, its details will be returned. If the book is not found, an error response will be returned.

### 4. Update a Book
This endpoint allows the user to update the details of an existing book. The user must specify the book's ID and provide the new information.

### 5. Delete a Book
This endpoint allows the deletion of a book from the system. The user must specify the book's ID, and upon successful deletion, a confirmation message will be returned.

### 6. Search Books by Keyword
This endpoint allows the user to search for books based on a keyword. The search can be performed on various attributes such as the book's title or author.

## Pagination and Sorting

**Pagination**: This functionality is implemented to allow users to fetch books in smaller chunks rather than retrieving the entire list at once. Users can specify which page of books they want to retrieve and how many books should appear per page.

**Sorting**: Sorting enables users to organize the books by a particular field, such as title or price. Sorting can be done in ascending or descending order, and multiple fields can be used to sort the results.

**Example Usage**:
- Retrieve the first page of books with 10 books per page, sorted by price in descending order.
- Retrieve all books sorted by their title in ascending order.

## Setting Up the Project

### Prerequisites

To set up this project locally, ensure the following tools are installed:
- **Java 23**
- **Maven**: For building the project and managing dependencies.
- **Postman** or any other API testing tool for making requests.

### Steps to Set Up

1. Clone the repository to your local machine:
   - Use Git to clone the project.
2. Install project dependencies using Maven:
   - Run the appropriate command in your terminal or command prompt to install the necessary libraries and dependencies.
3. Run the application:
   - Start the application with Maven's spring-boot plugin or use an IDE like IntelliJ IDEA or Eclipse.

Once the application is running, you can test the API by sending requests to `http://localhost:8080`.

## Running the Application

After setting up the application, you can start it by running the application in your preferred IDE or using the terminal. The application will be available at `http://localhost:8080` by default.

With the application running, you can use an API testing tool like **Postman** to make requests to the endpoints. The API supports standard HTTP methods (GET, POST, PUT, DELETE) and can be used to manage books in the system.

## Testing

The application includes unit tests to ensure that the core functionalities work as expected. Unit tests are written using **JUnit 5** and **Mockito**.

These tests verify the following:
- Book creation and retrieval.
- Correctness of pagination and sorting.
- Proper handling of errors (e.g., when a book is not found).

To run the tests, simply execute the unit tests with Maven or your preferred IDE.

## Contributing

We welcome contributions to this project! If you want to contribute, follow these steps:
1. Fork the repository.
2. Create a new branch for your changes.
3. Implement the changes.
4. Test the changes.
5. Submit a pull request to the main repository.

Feel free to improve the code, add new features, or help with documentation.

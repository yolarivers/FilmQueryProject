# FilmQueryApp

## Introduction
Welcome to the FilmQueryApp project! This command-line application allows users to query a database of films, providing detailed information about each film. The application is menu-based, enabling users to easily navigate and perform various actions.

## How to Use
1. **Search by Film ID:**
    * Enter a film ID to retrieve detailed information about the film.
2. **Search by Keyword:**
    * Enter a keyword to find films with matching titles or descriptions.

## Languages and Concepts Used in FilmQueryApp

### 1. Java Programming Language
Java is a high-level, class-based, object-oriented programming language widely used for building robust, scalable applications.

### 2. JDBC (Java Database Connectivity)
JDBC is an API that enables Java applications to interact with databases. Key tasks include:
* Establishing a connection to the MySQL database.
* Executing SQL queries to retrieve film data.
* Handling results using `ResultSet`.

### 3. SQL (Structured Query Language)
SQL is a standard language for managing and manipulating databases. Key tasks include:
* Querying the film table to retrieve film information.
* Joining tables to get related data such as actors and film language.

### 4. Object-Oriented Programming (OOP)
OOP is a programming paradigm based on the concept of objects. Key concepts include:
* Creating classes like `Film`, `Actor`, and `DatabaseAccessorObject`.
* Using encapsulation to protect data within these classes.
* Implementing polymorphism through interfaces and method overriding.

### 5. Design Patterns
Design patterns are typical solutions to common problems in software design. Key patterns used include:
* **DAO (Data Access Object):** Used for database interactions via `DatabaseAccessorObject`.

### 6. Exception Handling
Exception handling in Java involves managing runtime errors to ensure the application runs smoothly. Key tasks include:
* Handling SQL exceptions and input/output exceptions.

### 7. Unit Testing
Unit testing involves testing individual components of a software. Key tasks include:
* Writing JUnit tests for methods in `DatabaseAccessorObject` to ensure they function correctly.

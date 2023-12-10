# Student Management System

This is a web-based application built with Spring Boot and Thymeleaf for managing student records. It provides features like user registration, student creation, updating, and deletion. Users can log in to the system securely and perform various operations related to student management. Additionally, I created tests for the student controller and student service

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Features](#features)
- [Usage](#usage)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 17 or higher installed
- PostgreSQL database server installed and running
- Maven build tool installed


## Getting Started

To get started with the project, follow these steps:

1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd student-managment-system
   ```

2. Set up the database:
    - Create a PostgreSQL database named `sms`.
    - Update the database configuration in `src/main/resources/application.properties` with your PostgreSQL username and password.

3. Build and run the application:

   ```bash
   mvn spring-boot:run
   ```

   The application will be accessible at `http://localhost:8080`.

## Features

- User registration and authentication
- View a list of students
- Add new students
- Edit existing student records
- Delete student records
- Tests for Student Service and Student Controller

## Usage

1. **User Registration:**
    - Access the registration page at `http://localhost:8080/registration`.
    - Provide your first name, last name, email, and password to create a new account.

2. **Login:**
    - Access the login page at `http://localhost:8080/login`.
    - Log in using your registered email and password.

3. **View Students:**
    - Upon logging in, you can view the list of students at `http://localhost:8080/students`.

4. **Add New Student:**
    - Click on the "New Student" button to add a new student record.
    - Fill in the student's first name, last name, and email, then click "Save" to add the student.

5. **Edit Student:**
    - Click on the "Edit" button next to a student's record to edit their information.
    - Modify the student's details and click "Save" to update the record.

6. **Delete Student:**
    - Click on the "Delete" button next to a student's record to delete the student from the system.


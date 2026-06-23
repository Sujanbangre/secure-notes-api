# Secure Notes API

A secure RESTful Notes Management API built using Java Spring Boot, PostgreSQL, Spring Security, and JWT Authentication.

## Features

### Authentication

* User Signup
* User Login
* BCrypt Password Hashing
* JWT Token Generation

### Authorization

* USER Role Access
* ADMIN Role Access
* Role-Based Security

### Notes Management

* Create Notes
* View Own Notes

### Admin Features

* View All Users
* View Notes Of Specific Users

## Tech Stack

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* PostgreSQL
* JWT
* Maven
* Postman

## API Endpoints

### Authentication

POST /auth/signup

POST /auth/login

### User

POST /user/notes

GET /user/notes

### Admin

GET /admin/users

GET /admin/users/{id}/notes

## Security

* BCrypt password encryption
* JWT authentication
* Role-based access control
* Protected API endpoints

## Project Structure

Controller → Service → Repository → PostgreSQL

## Future Improvements

* Swagger Documentation
* Docker Support
* Cloud Deployment

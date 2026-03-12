# 🏋️ FitTrack – Gym Membership Management REST API

FitTrack is a **Spring Boot RESTful backend application** designed to manage gym operations such as **members, trainers, subscriptions, and attendance**.
The project follows a **layered architecture (Controller → Service → Repository → Database)** and demonstrates clean backend development practices.

This system allows administrators to manage gym members, assign trainers, track subscriptions, and record attendance through REST APIs.

---

# 🚀 Features

* Member Management (Create, Update, Delete, View)
* Trainer Management
* Assign Trainer to Member
* Subscription Management
* Attendance Tracking
* Global Exception Handling
* RESTful API Design
* MySQL Database Integration
* Layered Architecture

---

# 🛠️ Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate

### Database

* MySQL

### Tools

* Maven
* Postman (API Testing)
* Git & GitHub

---

# 🏗️ Project Architecture

Controller Layer
Handles HTTP requests and responses.

Service Layer
Contains business logic.

Repository Layer
Communicates with the database using Spring Data JPA.

Entity Layer
Represents database tables.

Exception Layer
Handles global exceptions.

---

# 📂 Project Structure

```
src/main/java/com/example/demo

├── controller
│   ├── MemberController
│   ├── TrainerController
│   ├── SubscriptionController
│   └── AttendanceController
│
├── service
│   ├── MemberService
│   ├── MemberServiceImpl
│   ├── TrainerService
│   ├── TrainerServiceImpl
│   ├── SubscriptionService
│   └── SubscriptionServiceImpl
│
├── repository
│   ├── MemberRepository
│   ├── TrainerRepository
│   ├── SubscriptionRepository
│   └── AttendanceRepository
│
├── entity
│   ├── Member
│   ├── Trainer
│   ├── Subscription
│   └── Attendance
│
├── exception
│   ├── ResourceNotFoundException
│   └── GlobalExceptionHandler
```

---

# 🌐 API Endpoints

## Member APIs

Create Member

POST /api/members

Get All Members

GET /api/members

Get Member by ID

GET /api/members/{id}

Update Member

PUT /api/members/{id}

Delete Member

DELETE /api/members/{id}

---

## Trainer APIs

Create Trainer

POST /api/trainers

Get All Trainers

GET /api/trainers

Get Trainer by ID

GET /api/trainers/{id}

Delete Trainer

DELETE /api/trainers/{id}

---

## Subscription APIs

Assign Subscription to Member

POST /api/subscriptions/{memberId}

Get Subscription by Member

GET /api/subscriptions/member/{memberId}

---

## Attendance APIs

Mark Attendance

POST /api/attendance/{memberId}

Get Attendance by Member

GET /api/attendance/member/{memberId}

---

# ⚙️ Setup Instructions

### 1️⃣ Clone the repository

git clone https://github.com/yourusername/fittrack-api.git

### 2️⃣ Navigate into project

cd fittrack-api

### 3️⃣ Create MySQL database

CREATE DATABASE fittrack_db;

### 4️⃣ Configure application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/fittrack_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update

### 5️⃣ Run the application

Run the Spring Boot application using your IDE or:

mvn spring-boot:run

### 6️⃣ Test APIs

Use Postman to test endpoints.

---

# 📊 Example JSON Request

Create Member

```
POST /api/members
```

```
{
  "name": "Rahul Sharma",
  "email": "rahul@gmail.com",
  "phone": "9876543210"
}
```

---

# ⚠️ Error Handling

The project implements **Global Exception Handling** using:

* `@ControllerAdvice`
* Custom `ResourceNotFoundException`
Example error response:

{
  "timestamp": "2026-03-01T12:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Member not found with id: 10"
}
🔮 Future Improvements

JWT Authentication

Role-based Access Control

React Frontend Dashboard

API Documentation (Swagger)

Docker Deployment

👨‍💻 Author

Dhanush

Java Backend Developer | Spring Boot | REST APIs


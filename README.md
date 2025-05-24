# 📘 Quiz Application

A simple **Spring Boot-based Quiz Management System** with RESTful APIs to manage Students, Subjects, Questions, and Tests.

---

## 📌 Features

- 📋 **Student Registration & Management**  
- 📚 **Subject and Question Management**  
- 🧠 **Test Creation & Retrieval**  
- 🌐 **RESTful API using Spring Data REST & JPA**  
- 🗄️ **MySQL Database Integration**

---

## 🛠️ Technologies Used

- **Java 8+**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Data REST**
- **MySQL**
- **Hibernate**
- **Postman / cURL** for API testing
- **Maven**

---

## 📂 Project Structure

```
QuizApplication/
├── src/
│   ├── main/
│   │   ├── java/com/cg/entities/    # JPA Entity Classes (Student, Subject, Question, Test)
│   │   ├── java/com/cg/repositories/ # Spring Data Repositories
│   │   └── java/com/cg/              # Main Application Class
│   └── resources/
│       ├── application.properties    # DB config and server settings
├── pom.xml                           # Maven build file
└── README.md                         # This file
```

---

## ⚙️ Setup Instructions

### ✅ Prerequisites

- JDK 8 or above
- Maven
- MySQL
- Git

### 🚀 Steps to Run

1. **Clone the repo:**
```bash
git clone https://github.com/<your-username>/QuizApplication.git
cd QuizApplication
```

2. **Create MySQL DB:**
```sql
CREATE DATABASE quizapp;
```

3. **Update `application.properties`:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quizapp
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
spring.jpa.hibernate.ddl-auto=update
server.port=9998
```

4. **Run the application:**
```bash
mvn spring-boot:run
```

5. **Visit the base URL:**
```
http://localhost:9998/
```

---

## 🧪 Example API Endpoints

| Resource    | Endpoint                         | Method |
|-------------|----------------------------------|--------|
| Students    | `/students`                      | GET, POST |
| Subjects    | `/subjects`                      | GET, POST |
| Questions   | `/questionses`                   | GET, POST |
| Tests       | `/tests`                         | GET, POST |

Example `POST` via `curl`:
```bash
curl -X POST http://localhost:9998/students \
-H 'Content-Type: application/json' \
-d '{"studId": 1, "studName": "John", "studEmail": "john@example.com", "studMobNo": 9876543210, "studPassword": "test123"}'
```

---

## 🧠 Future Enhancements

- JWT-based Authentication
- Test Scoring Logic
- Frontend using React or Angular
- Dockerization & CI/CD pipeline
- Question randomization per test

---

# CareSync - Healthcare Management System

CareSync is a RESTful API built with Spring Boot for managing patient healthcare records and insurance information. The application provides endpoints for patient management, insurance tracking, and healthcare data analysis.

## 🚀 Features

- **Patient Management**
  - CRUD operations for patient records
  - Search patients by various criteria (name, birth date, email)
  - Pagination and sorting support
  - Blood group tracking and analytics

- **Insurance Management**
  - Track patient insurance policies
  - Policy validation and expiration tracking
  - Provider information management

- **Data Analytics**
  - Blood group distribution statistics
  - Patient demographic reports
  - Insurance coverage analytics

## 🛠️ Tech Stack

- **Backend**: Spring Boot 3.5.4
- **Database**: PostgreSQL
- **ORM**: Hibernate/JPA
- **Build Tool**: Maven
- **Java Version**: 17+

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher
- PostgreSQL 12+

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/nitinkumarpals/careSync
   cd careSync
   ```

2. Configure the database in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/caresync
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will be available at `http://localhost:8080/api`

## 📚 API Documentation

API documentation is available using Swagger UI at:
```
http://localhost:8080/api/swagger-ui.html
```

## 🧪 Running Tests

To run the test suite:
```bash
mvn test
```

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 📧 Contact

For any questions or feedback, please reach out to [Your Email]

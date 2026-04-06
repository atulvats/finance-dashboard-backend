## Finance Dashboard Backend (Spring Boot)
- A secure and scalable REST API for managing financial records, users, and dashboard analytics with JWT authentication, role-based access control, and Swagger documentation.

## Features
- JWT Authentication (Login API)
- Role-Based Access Control (ADMIN / ANALYST / VIEWER)
- Dashboard Summary (Income, Expense, Balance)
- Financial Records Management (CRUD)
- User Management (Admin only)
- Swagger API Documentation
- DTO Validation (Jakarta Validation)
- Global Exception Handling
- MySQL Database Integration

## Tech Stack
- Backend: Spring Boot 3
- Security: Spring Security + JWT
- Database: MySQL
- ORM: Spring Data JPA (Hibernate)
- Validation: Jakarta Validation
- Docs: Springdoc OpenAPI (Swagger)
- Build Tool: Maven

## Project Structure
src/main/java/com/example/finance_dashboard
│
├── config/          # Security & Swagger Config
├── controller/      # REST Controllers
├── dto/             # Data Transfer Objects
├── exception/       # Custom & Global Exception Handling
├── model/           # Entity Classes
├── repository/      # JPA Repositories
├── security/        # JWT + Filter
├── service/         # Business Logic
└── util/            # Constants

## Authentication & Roles
- ADMIN: Full access (Users, Records, Dashboard)
- ANALYST: Records + Dashboard
- VIEWER: Dashboard only

## API Endpoints
# Auth
- POST: http://localhost:8080/auth/login
# Request:
-JSON Body:
{
  "username": "admin",
  "password": "admin123"
}

## Response:
{
  "token": "JWT_TOKEN"
}

## Users (ADMIN only)
POST   /users
GET    /users
GET    /users/{id}
PUT    /users/{id}
DELETE /users/{id}

## Records
POST   /records
GET    /records
GET    /records/{id}
PUT    /records/{id}
DELETE /records/{id}

## Dashboard
- GET /dashboard/summary

## API Testing (Swagger)
-- After running the app:
- http://localhost:8080/swagger-ui/index.html
-- Click Authorize
-- Enter: Bearer YOUR_TOKEN

## Environment Variables
DB_URL=jdbc:mysql://localhost:3306/finance_db
DB_USERNAME=root
DB_PASSWORD=your_password
PORT=8080

## Setup & Run Locally
-- Clone Repository
git clone https://github.com/your-username/finance-dashboard.git
cd finance-dashboard

## Set Environment Variables (PowerShell)
- $env:DB_URL="jdbc:mysql://localhost:3306/finance_db"
- $env:DB_USERNAME="root"
- $env:DB_PASSWORD="your_password"

## Run Application
- mvn spring-boot:run

## Deployment
- Backend deployed on Render

## Security Implementation
- JWT Token-based Authentication
- Role-based Authorization using Spring Security
- Password validation & secure endpoints
- Protected routes with filters

## API Behavior
- `/auth/login` → Generates JWT token
- `/users` → Admin-only user management
- `/records` → Financial record CRUD operations
- `/dashboard/summary` → Aggregated financial insights

All secured endpoints require:
Authorization: Bearer <token>

## Assumptions
- Users are predefined (admin, analyst, viewer) for simplicity.
- Authentication is handled using JWT without database persistence.
- Financial records are not linked to specific users (single-tenant system).
- Dates are handled in `yyyy-MM-dd` format.

## Trade-offs
- Used in-memory authentication instead of database for faster implementation.
- Roles are embedded in JWT instead of dynamic DB lookup.
- No pagination implemented to keep APIs simple.
- No refresh token mechanism added to reduce complexity.

## Additional Improvements
- DTO pattern used to separate API layer from entity layer
- Centralized constants for clean code
- Swagger integration for easy API testing
- Environment-based configuration for secure deployment
- Clean layered architecture (Controller → Service → Repository)

## Author
- Atul Vats
- Backend Developer | Spring Boot | Java

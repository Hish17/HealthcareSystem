# 🏥 Healthcare System

A Spring Boot REST API for managing patients and facilities, enhanced with an AI-powered query system using OpenAI GPT. The backend is containerized with Docker and communicates with a PostgreSQL database.

---

## ✅ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/Hish17/HealthcareSystem.git
cd HealthcareSystem
```

### 2. Configure Environment Variables

Create a `.env` file in the project root:

```
OPENAI_API_KEY=your-openai-api-key
```

> **Warning:** Never commit this file. It’s ignored in `.gitignore`.

### 3. Run the Application with Docker Compose

```bash
docker compose up --build
```

- Backend: [http://localhost:8080]
- PostgreSQL: Accessible on port `5432`  

If you are not using Docker, you can run it locally with:

```bash
./mvnw spring-boot:run
```

---

## 📑 API Documentation

### 🧍 Patients

| Method | Endpoint             | Description         |
|--------|----------------------|---------------------|
| GET    | `/api/patients`      | List all patients   |
| GET    | `/api/patients/{id}` | Get patient by ID   |
| POST   | `/api/patients`      | Create a patient    |
| PUT    | `/api/patients/{id}` | Update a patient    |
| DELETE | `/api/patients/{id}` | Delete a patient    |

---

### 🏥 Facilities

| Method | Endpoint               | Description          |
|--------|------------------------|----------------------|
| GET    | `/api/facilities`      | List all facilities  |
| GET    | `/api/facilities/{id}` | Get facility by ID   |
| POST   | `/api/facilities`      | Create a facility    |
| PUT    | `/api/facilities/{id}` | Update a facility    |
| DELETE | `/api/facilities/{id}` | Delete a facility    |

---

### 🤖 AI Query Endpoint

| Method | Endpoint     | Description                                       |
|--------|--------------|---------------------------------------------------|
| POST   | `/api/chat`  | Accepts natural language query and returns result |


## 🧱 Architecture Decisions

### 1. **Backend Framework: Spring Boot**
- Lightweight and fast to develop REST APIs
- Integrated support for JPA, dependency injection, and testing

### 2. **Database: PostgreSQL**
- Chosen for its reliability and Docker compatibility

### 3. **AI Integration: OpenAI GPT (via API)**
- Easily enables natural language processing without needing a local model
- `OpenAIServiceImpl` calls the GPT-3.5-turbo endpoint
- Queries are dynamically interpreted and mapped to actual service logic

### 4. **Modular Design**
- Separation of concerns:
  - `Controller`: REST endpoints
  - `Service`: Business logic
  - `Repository`: Database access
- AI logic is isolated in its own service (`OpenAIService`)

### 5. **Containerization: Docker + Docker Compose**
- Enables seamless environment setup for:
  - PostgreSQL DB
- Easier local testing and CI/CD integration

---

## 📁 Project Structure

```
HealthcareSystem/
├── src/
│   ├── main/java/com/example/Healthcare/
│   │   ├── controller/         # REST endpoints
│   │   ├── model/              # JPA entities
│   │   ├── repository/         # Spring Data JPA
│   │   ├── service/            # Interfaces
│   │   └── service/implementation/  # Business logic + AI
│   └── resources/
│       └── application.properties
├── Dockerfile
├── docker-compose.yml
└── README.md
```


## 🧪 Testing

You can test APIs using **Postman** or `curl`. For example:


## 👨‍💻 Author

**Hisham Gaber**  
GitHub: [Hish17](https://github.com/Hish17)

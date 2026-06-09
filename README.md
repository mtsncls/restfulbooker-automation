# Restful-Booker Automation Framework

[![CI](https://github.com/mtsncls/restfulbooker-automation/actions/workflows/ci.yml/badge.svg)](https://github.com/mtsncls/restfulbooker-automation/actions/workflows/ci.yml)
[![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)](https://openjdk.org/)
[![RestAssured](https://img.shields.io/badge/RestAssured-5.x-green)](https://rest-assured.io/)
[![Selenium](https://img.shields.io/badge/Selenium-4.x-43B02A?logo=selenium)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-red)](https://testng.org/)

A professional-grade hybrid automation framework for end-to-end testing of the [Restful-Booker](https://restful-booker.herokuapp.com/) ecosystem. Combines robust API testing with reliable UI automation using modern design patterns and best practices.

---

## Tech Stack

| Tool | Purpose |
|---|---|
| Java 17 | Language |
| Maven | Build tool |
| [RestAssured](https://rest-assured.io/) | API test client |
| [Selenium WebDriver](https://www.selenium.dev/) | UI automation |
| TestNG | Test runner |
| [Allure Report](https://allurereport.org/) | Reporting |
| [JavaFaker](https://github.com/DiUS/java-faker) | Test data generation |
| [AssertJ](https://assertj.github.io/doc/) | Fluent assertions |
| [Snyk](https://snyk.io/) | Dependency & SAST scanning |
| JSON Schema Validator | Contract testing |

---

## Features

- **Decoupled architecture** — clean separation between Core config, API clients, and UI Page Objects
- **Contract testing** — JSON Schema validation to ensure API response consistency
- **Fluent assertions** — high-readability tests using AssertJ
- **Dual test suites** — independent TestNG XML configs for API and E2E runs
- **Dynamic test data** — JavaFaker-driven data generation to avoid static data collision
- **Rich reporting** — Allure reports with step-by-step logs and execution metadata
- **Security by default** — Snyk dependency scanning and SAST integrated into the workflow
- **CI/CD** — GitHub Actions + CircleCI pipelines

---

## Project Structure

```
restfulbooker-automation/
├── .circleci/                  # CircleCI pipeline config
├── .github/workflows/          # GitHub Actions pipeline config
├── src/
│   ├── main/java/
│   │   ├── api/client/         # API Request specs & clients
│   │   ├── core/config/        # Driver managers & framework config
│   │   └── ui/pages/           # Page Object Models
│   └── test/java/
│       ├── api/                # API & contract test suites
│       ├── ui/                 # Selenium E2E tests
│       ├── data/               # Test data providers & models
│       └── runners/            # Base test classes & setup logic
├── testng-api.xml              # TestNG suite for API tests
├── testng-e2e.xml              # TestNG suite for E2E UI tests
└── pom.xml
```

---

## Getting Started

### Prerequisites

- Java JDK 17+
- Maven 3.9+
- Allure CLI (optional, for local report serving)

### Run tests

```bash
# API & Contract tests
mvn test -DsuiteXmlFile=testng-api.xml

# UI End-to-End tests
mvn test -DsuiteXmlFile=testng-e2e.xml
```

### View Allure report

```bash
# Generate
mvn allure:report

# Serve locally
mvn allure:serve
```

---

## Design Patterns

- **Client/Controller pattern** — endpoints and specs abstracted into dedicated client classes (`BookingClient`, `AuthClient`)
- **Page Object Model** — UI interactions encapsulated per page
- **Builder pattern** — POJO instantiation via Lombok `@Builder`
- **Data-driven testing** — parameterized tests with dynamic data providers
- **SOLID & DRY** — shared specs in `BaseSpec`, shared setup in `BaseTest`

---

## Security

This project follows **Snyk's Security At Inception** principles:

- Regular dependency scanning to mitigate supply chain risks
- SAST integrated into the development workflow
- Pinned stable versions of critical libraries (`jackson-databind`, `snakeyaml`)

---

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add your feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

---

*Built with ❤️ for quality assurance excellence.*

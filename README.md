# 🚀 Restful-Booker Automation Framework

A professional-grade automation framework designed for end-to-end testing of the **Restful-Booker** ecosystem. This project combines robust API testing with reliable UI automation using modern design patterns and best practices.

---

## 🛠 Tech Stack

- **Language:** Java 17
- **Build Tool:** Maven
- **API Testing:** [RestAssured](https://rest-assured.io/)
- **UI Testing:** [Selenium WebDriver](https://www.selenium.dev/)
- **Test Runner:** TestNG
- **Reporting:** [Allure Report](https://allurereport.org/)
- **Data Generation:** [JavaFaker](https://github.com/DiUS/java-faker)
- **Security:** [Snyk](https://snyk.io/) (for dependency & code scanning)
- **Validation:** JSON Schema Validator

---

## ✨ Features

- **Decoupled Architecture:** Clean separation between Core configuration, API clients, and UI Page Objects.
- **Contract Testing:** Comprehensive JSON Schema validation to ensure API consistency.
- **Fluent Assertions:** High-readability tests using [AssertJ](https://assertj.github.io/doc/).
- **Dynamic Configuration:** Supports multiple test suites (API, E2E) via TestNG XML files.
- **Premium Reporting:** Rich Allure reports with step-by-step logs and execution metadata.
- **Security Inception:** Built-in vulnerability scanning to maintain a secure supply chain.

---

## 📂 Project Structure

```text
restfulbooker-automation
├── src
│   ├── main/java
│   │   ├── api/client      # API Request Specifications & Clients
│   │   ├── core/config     # Driver Managers & Framework Configurations
│   │   └── ui/pages        # Page Object Models for UI Interaction
│   └── test/java
│       ├── api             # API & Contract Test Suites
│       ├── ui              # Selenium E2E Tests
│       ├── data            # Test Data Providers & Models
│       └── runners         # Base Test Classes & Setup logic
├── testng-api.xml          # TestNG Suite for API tests
├── testng-e2e.xml          # TestNG Suite for E2E UI tests
└── pom.xml                 # Maven configuration & dependencies
```

---

## 🚀 Getting Started

### Prerequisites

- **Java JDK 17** or higher.
- **Maven 3.9+** installed and configured in your PAT.
- **Allure CLI** (optional, for viewing reports locally).

### Running Tests

Execute the full test suite or specific layers using the following commands:

#### 1. API & Contract Tests
```bash
mvn test -DsuiteXmlFile=testng-api.xml
```

#### 2. UI End-to-End Tests
```bash
mvn test -DsuiteXmlFile=testng-e2e.xml
```

---

## 📊 Reporting

We use **Allure Report** for visualizing test execution.

1. **Run tests** (results will be generated in `allure-results/`).
2. **Serve the report** locally:
   ```bash
   allure serve allure-results
   ```

---

## 🔒 Security Best Practices

This project adheres to **Snyk's Security At Inception** principles:
- Regular dependency scanning to mitigate supply chain risks.
- SAST (Static Application Security Testing) integrated into the development workflow.
- Standardized use of the latest stable versions for critical libraries like `jackson-databind` and `snakeyaml`.

---

## 🤝 Contributing

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

---

*Built with ❤️ for quality assurance excellence.*

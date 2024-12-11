# CSK Selenium Project

This project is a web UI automation testing framework built using modern technologies to ensure robust and efficient test coverage.

## Technologies Used

- **Java**: Programming language for the test logic and framework.
- **Selenium WebDriver**: For interacting with web elements in UI automation.
- **Cucumber**: Behavior-driven development (BDD) framework for writing test cases in Gherkin language.
- **TestNG**: Testing framework for executing and managing test cases.
- **WebDriverManager**: For managing browser drivers automatically.
- **Allure Report**: For generating detailed and interactive test execution reports.
- **Log4j**: For logging test execution details.

---

## Project Structure

```
src
├── main
│   ├── java
│   │   ├── base            # Base classes for common functionality
│   │   ├── configuration   # Configuration-related classes
│   │   ├── page            # Page Object Model (POM) classes
│   │   └── utils           # Utility classes
│   └── resources           # Configuration files
└── test
    ├── java
    │   ├── base            # Base test classes
    │   ├── steps           # Step definition classes for Cucumber
    │   └── test            # Test runner classes
    └── resources
        ├── Feature         # Cucumber feature files
        ├── allure.properties
        ├── cucumber.properties
        ├── log4j2.xml
        └── testng.xml      # TestNG configuration file
```

---

## How to Run the Tests

### Prerequisites

- Ensure **Java** (version 8 or higher) is installed on your system.
- Install **Maven** for dependency management.
- Set the `JAVA_HOME` and `MAVEN_HOME` environment variables correctly.

### Step-by-Step Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd csk-selenium
   ```

2. **Install Dependencies**
   Use Maven to download and install all dependencies:
   ```bash
   mvn clean install
   ```

3. **Run Tests**
   Execute the TestNG suite using Maven:
   ```bash
   mvn test -DsuiteXmlFile=src/test/resources/regresion.xml
   ```

4. **View Allure Report**
   Open the generated Allure report in your browser:
   ```bash
   mvn allure:serve
   ```

---
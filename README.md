# Mini Message Board - Spring Boot Project

This project is a simple message board application built using **Spring Boot**, **Thymeleaf**, **PostgreSQL**, and **JPA** for data persistence. Users can view and submit messages, which are stored in a PostgreSQL database.

## Features

- Display a list of messages with user names and timestamps.
- Form to submit new messages.
- Messages are stored persistently in a PostgreSQL database.
- Spring Boot framework with Thymeleaf for rendering the front-end.

## Technologies Used

- Java 17
- Spring Boot 3.3.x
- Thymeleaf
- PostgreSQL
- Hibernate (JPA)
- Gradle (build tool)

## Getting Started

### Prerequisites

- Java 17 or higher
- PostgreSQL
- Gradle

### Setting Up the Project

1. Clone the repository:

    ```bash
    git clone <your-repo-url>
    cd <your-project-directory>
    ```

2. Set up PostgreSQL:

    - Create a PostgreSQL database:

      ```sql
      CREATE DATABASE messageboard;
      ```

    - Create a `messages` table:

      ```sql
      CREATE TABLE messages (
          id SERIAL PRIMARY KEY,
          message VARCHAR(255) NOT NULL,
          name VARCHAR(100) NOT NULL,
          date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
      );
      ```

3. Configure your database connection:

    - Open `src/main/resources/application.properties` and update the database connection information:

      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/messageboard
      spring.datasource.username=yourusername
      spring.datasource.password=yourpassword
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
      ```

4. Run the application:

    ```bash
    ./gradlew bootRun
    ```

5. Open your browser and go to `http://localhost:8080/` to view the message board.

### Using the Application

- **Home Page (`/`)**: Displays all messages stored in the database.
- **New Message (`/new`)**: Allows users to add new messages.


## Testing

You can run the tests using the following command:

```bash
./gradlew test
```
## Deployment

To deploy this project to a cloud platform, make sure your PostgreSQL instance is accessible to the application and adjust the application.properties file accordingly.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.
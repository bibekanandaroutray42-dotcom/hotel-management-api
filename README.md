# Hotel Management REST API

A modular, 3-tier RESTful backend service designed to manage hotel inventory, facilities, and dynamic pricing. This project demonstrates enterprise-level API design, asynchronous third-party data integration, and complex relational database mapping.

## 🚀 Tech Stack

*   **Language:** Java 21
*   **Framework:** Spring Boot 3
*   **Database Integration:** Spring Data JPA, Hibernate ORM
*   **Database:** Oracle Database (Relational)
*   **API Client:** Spring WebFlux (`WebClient`)
*   **Build Tool:** Maven
*   **Testing:** Postman

## ✨ Key Features

*   **Asynchronous API Integration:** Utilizes Spring WebFlux's non-blocking `WebClient` to fetch and parse external JSON payloads from a third-party mock provider into native Java DTOs.
*   **Relational Data Modeling:** Implements robust `@OneToOne` and `@OneToMany` entity relationships using Hibernate, ensuring strict data integrity across parent (Hotel) and child (Rooms, Images, Contacts, Facilities) tables.
*   **Global Exception Handling:** Employs `@ControllerAdvice` to intercept missing resources (e.g., querying a non-existent Hotel ID) and return structured, professional JSON `404 Not Found` error payloads instead of generic server traces.
*   **Custom Business Logic:** Includes programmatic sorting algorithms at the Service/Controller layer to sort nested collections (e.g., ordering hotel rooms dynamically by price).

## 🗄️ Database Schema

The persistence layer is mapped to an Oracle Database with the following entities:
*   `HOTEL_INFO` (Parent)
*   `HOTEL_CONTACT_INFO` (One-to-One)
*   `HOTEL_ROOM_INFO` (One-to-Many)
*   `HOTEL_IMAGES` (One-to-Many)
*   `HOTEL_FACILITIES` (One-to-Many)

## 📡 API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/import/hotels` | Triggers the `WebClient` to fetch third-party hotel data and saves it to the local Oracle database. |
| `GET` | `/hotels/rooms/sorted` | Retrieves all hotels and automatically sorts their available rooms by lowest price. |
| `GET` | `/hotels/{hotelId}/images` | Retrieves the image gallery list for a specific hotel ID. |
| `GET` | `/hotels/{hotelId}/facilities` | Retrieves the list of available facilities for a specific hotel ID. |
| `GET` | `/hotels/{hotelId}/contact` | Retrieves the precise contact and address information for a specific hotel ID. |

## 🛠️ Local Setup Instructions

1. Ensure Java 21 and Maven are installed.
2. Clone the repository to your local machine.
3. Configure your Oracle Database credentials in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
   spring.datasource.username=scott
   spring.datasource.password=tiger
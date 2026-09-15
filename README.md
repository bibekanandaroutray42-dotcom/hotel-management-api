# Hotel Management REST API

A modular, 3-tier RESTful backend service designed to manage hotel inventory, facilities, and dynamic pricing. This project demonstrates enterprise-level API design, asynchronous third-party data integration, and complex relational database mapping.

## 🚀 Tech Stack
* **Language:** Java 21
* **Framework:** Spring Boot 3
* **Database Integration:** Spring Data JPA, Hibernate ORM
* **Database:** Oracle Database (Relational)
* **API Client:** Spring WebFlux (WebClient) & Jackson (JSON Serialization)
* **Build Tool:** Maven
* **Testing:** Postman

## ✨ Key Features
* **Fault Tolerance & Resilience (New):** Implemented a robust fallback mechanism. If the third-party API goes offline or returns a `401 Unauthorized`, the system automatically catches the exception and injects mock fallback data to ensure continuous database persistence and uptime.
* **Strict Data Serialization (New):** Utilized Jackson's `@JsonProperty` to enforce exact PascalCase JSON payloads required by strict external endpoints.
* **Asynchronous API Integration:** Utilizes Spring WebFlux's non-blocking WebClient to fetch and parse external JSON payloads from a third-party mock provider into native Java DTOs.
* **Relational Data Modeling:** Implements robust `@OneToOne` and `@OneToMany` entity relationships using Hibernate, ensuring strict data integrity across parent (Hotel) and child (Rooms, Images, Contacts, Facilities) tables.
* **Global Exception Handling:** Employs `@ControllerAdvice` to intercept missing resources and return structured JSON `404 Not Found` error payloads instead of generic server traces.
* **Custom Business Logic:** Includes programmatic sorting algorithms at the Service/Controller layer to sort nested collections (e.g., ordering hotel rooms dynamically by price).

## 🗄️ Database Schema
The persistence layer is mapped to an Oracle Database with the following entities:
* `HOTEL_INFO` (Parent)
* `HOTEL_CONTACT_INFO` (One-to-One)
* `HOTEL_ROOM_INFO` (One-to-Many)
* `HOTEL_IMAGES` (One-to-Many)
* `HOTEL_FACILITIES` (One-to-Many)

## 📡 API Endpoints
| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/import/hotels` | Triggers the WebClient to fetch third-party hotel data (with fallback) and saves it to the local Oracle database. |
| `GET` | `/hotels/rooms/sorted` | Retrieves all hotels and automatically sorts their available rooms by lowest price. |
| `GET` | `/hotels/{hotelId}/images` | Retrieves the image gallery list for a specific hotel ID. |
| `GET` | `/hotels/{hotelId}/facilities` | Retrieves the list of available facilities for a specific hotel ID. |
| `GET` | `/hotels/{hotelId}/contact` | Retrieves the precise contact and address information for a specific hotel ID. |

## 🛠️ Local Setup Instructions
1. Ensure **Java 21** and **Maven** are installed.
2. Clone the repository to your local machine.
3. Configure your Oracle Database credentials in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
   spring.datasource.username=scott
   spring.datasource.password=tiger<img width="1920" height="1080" alt="Screenshot (547)" src="https://github.com/user-attachments/assets/c5aa5bcb-eadc-423d-a475-bb7dde795e5c" />

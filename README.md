# Quotes API using Spring Boot

Welcome to the Quotes API project! This project is designed to showcase the creation of a simple API for managing quotes using Spring Boot.

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Endpoints](#endpoints)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Description

This project demonstrates the creation of a RESTful API for managing quotes. The API is built using Spring Boot and utilizes an SQL database to store quotes. It provides endpoints to retrieve, create, update, delete, and even retrieve random quotes.

## Features

- Retrieve a list of all quotes.
- Create a new quote.
- Update an existing quote.
- Delete a quote.
- Retrieve a random quote.

## Endpoints

- **GET /api/quotes**: Retrieve a list of all quotes.
- **GET /api/quotes/{id}**: Retrieve a specific quote by ID.
- **POST /api/quotes**: Create a new quote.
- **PUT /api/quotes/{id}**: Update an existing quote.
- **DELETE /api/quotes/{id}**: Delete a quote.
- **GET /api/quotes/random**: Retrieve a random quote.

## Getting Started

1. Clone the repository.
2. Configure your database settings in `application.properties`.
3. Build and run the project using your preferred IDE or command line.
4. Access the API using the provided endpoints.

## Usage

1. Retrieve a list of all quotes: `GET /api/quotes`
2. Retrieve a specific quote: `GET /api/quotes/{id}`
3. Create a new quote: `POST /api/quotes`
4. Update an existing quote: `PUT /api/quotes/{id}`
5. Delete a quote: `DELETE /api/quotes/{id}`
6. Retrieve a random quote: `GET /api/quotes/random`

## Contributing

Contributions are welcome! If you'd like to contribute to this project, feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

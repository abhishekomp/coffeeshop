# Microservice Based Coffee Shop application

This project demonstrates microservice applications interacting with one another including a thymeleaf based frontend application.

## Project Overview

This Spring Boot Microservice application showcases the following features:

- Setting up individual Spring Boot application that talk to each other.
- (TBD) Dockerizing the microservice applications using GitHub Actions workflow.
- (TBD) Running the application in Docker container.
- (TBD) Usage of RestClient for interaction between different microservice applications.
- (TBD) Publishing of events to RabbitMQ using Outbox Pattern.
- (TBD) Implementation of email notification via mailhog.
- Frontend application based on Thymeleaf rendering 
- (TBD) AlpineJS for adding functionality on web page.
- (TBD) Cart functionality for Order placement.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK) 17 or later
- Apache Maven
- (TBD) Docker client

## Project Structure

The project (multi-module maven project) consists of the following applications:

- `coffeshop-backend`: A Spring boot application that manages the coffees for the application.
- `coffeshop-frontend`: (End User facing application) A Spring boot web mvc application using Thymeleaf for html rendering and AlpineJS for adding functionality to the html page.

## Usage

Once the application is running, you can interact access the application using following endpoint:

- Front end application: `http://localhost:8080`

The above endpoint will show the main page for the web application along with Cart in the upper right side.

Happy coding!
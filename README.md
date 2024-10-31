# langonifood
# Food Delivery App

This project is a **langonifood** designed to leverage microservices architecture for scalable, reliable, and cloud-deployable infrastructure. The backend is developed in **Java** using the **Spring** framework and integrates various tools and technologies for efficient service discovery, synchronous and asynchronous communication, fault tolerance, and cloud deployment.

## Features

- **Microservices with Java and Spring**: Each feature is developed as an independent microservice, connected to a MySQL database.
- **Service Discovery with Eureka**: Eureka is used to register and discover services, enabling scalability and fault tolerance.
- **API Gateway**: Centralized access point for all services, managing request routing and handling.
- **Synchronous Communication with OpenFeign**: Facilitates synchronous REST communication between microservices.
- **Circuit Breaker and Fallback**: Fault tolerance is ensured with circuit breaker patterns to maintain service stability.
- **Cloud Infrastructure**: Infrastructure is prepared for deployment on AWS using CDK.

## Technology Stack

- **Java**
- **Spring Boot**
- **MySQL**
- **Eureka** - Service Discovery
- **Spring Cloud Gateway** - API Gateway
- **OpenFeign** - Synchronous Communication
- **Circuit Breaker** - Resilience4j or Hystrix
- **RabbitMQ** - Message Broker for Asynchronous Communication
- **AWS** - Cloud Environment

## Cloud Deployment (AWS)

- **AWS CDK**: Infrastructure as code for easy deployment.
- **ECS, ECR, Fargate**: Containerized service management on AWS.
- **RDS (Relational Database Service)**: Managed MySQL instance.
- **CloudWatch**: Logging and monitoring.
- **Auto Scaling**: Adjust resources automatically based on demand.


## Microservices Architecture

1. **User Service**: Manages user data and authentication.
2. **Order Service**: Handles order processing.
3. **Restaurant Service**: Manages restaurant data.
4. **Notification Service**: Sends notifications asynchronously using RabbitMQ.

## Monitoring and Scaling

- **CloudWatch**: Logs and monitors all services.
- **Auto Scaling**: Automatically adjusts the resources of ECS services based on CPU and memory usage.

## Messaging and Asynchronous Communication

- **RabbitMQ**: Ensures reliable message delivery between services.
- **Error Handling**: Implements retry and error-handling mechanisms to ensure message delivery success.

## High Availability and Resilience

- **Circuit Breaker**: Detects and mitigates failures.
- **Fallback Mechanisms**: Provides alternate responses in case of failure.

## Future Enhancements

- Implement further monitoring tools.
- Enhance security with authentication/authorization.
- Improve resilience and scalability.



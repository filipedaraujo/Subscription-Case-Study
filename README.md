# Subscription Case Study
Case Study to design, code and deploy Subscription Service

## Mission Statement
With the information given and additional assumptions of yours, you should develop an API for SUBSCRIPTIONs using the Java framework of your choice (ideally use Spring Boot) or NodeJS framework of your choice (preferably ExpressJS).   

To create subscriptions a single endpoint will be created: in the public service.

Subscriptions contain: email, firstName, gender, dateOfBith, flag for consent and the newsletter Id corresponding to the campaign. Only gender and firstName are optional values. 

Rest of services receive the same parameters.

Services must be secure, only public service is accessible from the end user.

TIP: an example of a frontend application making use of this service would be similar to https://www.adidas.co.uk/on/demandware.store/Sites-adidas-GB-Site/en_GB/Newsletter-Subscribe

The subscription service has to persist the subscription and returns the ID of the created subscription to the public service.

To complete the subscription process, once the subscription was persisted by the subscription service, someway, the email service will receive the required  information to send an email to the user (take in account the SLAs to choose the best approach for this communication).

## Solution Overview 

<img src="subscription-service-solution.jpg"/>

## Subscription Service Overview

<img src="subscription-service-sequence.jpg"/>

## Getting Started

### Requirements
JDK 1.8 or later
Gradle 4+ or Maven 3.2+

You can also import the code straight into your IDE:
Spring Tool Suite (STS)

### Tech stack & Open-source libraries
*   [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
*   [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb) - provides integration with the MongoDB document database
*   [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway) - Spring Cloud Gateway aims to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency
*   [Spring AMQP](https://spring.io/projects/spring-amqp) - Framework to ease the bootstrapping and development of new Spring Applications
*   [Rabbitt MQ](https://www.rabbitmq.com/) - Open Source Message Broker
* 	[MongoDB](https://www.mongodb.com/) - Open-Source Document Database Management System
*   [ElastickSearch](https://www.elastic.co//) -  Open-Source distributed Observability Platform
*   [Envoy Proxy](https://www.envoyproxy.io/) - Open Source Edge and Service Proxy, designed for cloud-native applications. 
*   [Open Policy Agent](https://www.openpolicyagent.org/) - Open Source Policy-based control for cloud native environments
* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system
* 	[Azure Kubernertes Service](https://azure.microsoft.com/services/kubernetes-service/) - Kuberneters Service provided by Azure
* 	[Azure Cloud](https://azure.microsoft.com/) - Microsoft Cloud Provider


# SubscriptionCaseStudy
Case Study to design, code and deploy Subscription Service

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



### Build an executable JAR
You can run the application from the command line using:
```
mvn spring-boot:run
```
Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:
```
mvn clean package
```
Then you can run the JAR file with:
```
java -jar target/*.jar
```

*Instead of `mvn` you can also use the maven-wrapper `./mvnw` to ensure you have everything necessary to run the Maven build.*


### Running the application via docker container

* 	[filipedaraujo/spring-boot-subscription-service](https://hub.docker.com/repository/docker/filipedaraujo/spring-boot-subscription-service) - DockerHub Image

DockerHub Pull Command

```text
docker pull filipedaraujo/spring-boot-subscription-service
```

Ensure you build a jar of the application before building a docker image.  

```text
`mvn package -Dmaven.test.skip=true`    //skip all tests and build. The build once completed is available in target folder
```

```text
`mvn clean package`                     //run all tests and build
```

On Windows machine use **Windows Powershell**, navigate to the project folder where Dockerfile is present.

|                           Command                        |                                 Description                              |
|----------------------------------------------------------|--------------------------------------------------------------------------| 
|`docker images`                                           | take a look at the container images.                                     |
|`docker ps`                                               | list all the running containers.                                         |
|`docker ps -a`                                            | list all the containers, including the ones that have finished executing.|
|**`docker build -t spring-boot-subscription-service .`**  | **Build docker image of the project**                                    |
|**`docker run spring-boot-subscription-service`**         | **run the project's docker container**                                   |
|`docker stop [container_id]`                              | stop a container                                                         |
|`docker rm $(docker ps -aq)`                              | stop and remove all containers                                           |


#### Instructions

* Fork and clone the repository
* Install [Hugo](https://gohugo.io/getting-started/installing/#quick-install) and [npm](https://npmjs.com)
* Run `make serve`
* Open `http://localhost:1313` to check the site


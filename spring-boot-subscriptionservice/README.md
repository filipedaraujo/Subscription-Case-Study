# Spring Boot Subscription Application

## Requirements
JDK 1.8 or later
Gradle 4+ or Maven 3.2+

You can also import the code straight into your IDE:
Spring Tool Suite (STS)

## Spring Boot REST API Controller
In Spring, a controller class, which is capable of serving REST API requests, is called rest controller. It should be annotated with `@RestController` annotation.
The resource uris are specified in `@RequestMapping` annotations. It can be applied at class level and method level both. Complete URI for an API is resolved after adding class level path and method level path.

The controller of the application, `SubscriptionController`, defines the REST API endpoints. We have 3 API methods. 

* HTTP POST /subscription – Register new subscription and return subcription id 
* HTTP GET /list  - List All Subscriptions
* HTTP GET  /show/{subscription id} - Get Subscription By Id

## Spring Boot Application
Our REST APIs skeleton is ready. Now we need to configure Spring to detect our rest controller (using auto scanning) and deploy apis in embedded tomcat server. Thankfully, Spring boot makes all these things very easy by using the concept of auto configuration.

Auto-configuration attempts to guess and configure beans we you are likely to need. Auto-configuration classes are usually applied based on the jars in application classpath and the beans we have defined additionally in `@Configuration` classes.

In this case, it does following things.

It detects spring-webmvc so configure default spring mvc application beans. It help in scan and configure `@RestController` and similar annotations.
It detects embed tomcat jars so configure embedded tomcat for us.
It detects JSON jars so configure JSON support to APIs.

Our application implements a set of REST endpoints to manage subscriptions. We have a Subscription JPA entity and a repository named `SubscriptionRepository` that extends `CrudRepository` to perform CRUD operations on subscriptions against an in-memory H2 database.

The service layer is composed of a `SubscriptionService` interface and a `SubscriptionServiceImpl` implementation class.

## Model classes 

```
Subscription.java
```

```
package subscriptionservice.springframework.models;

//import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "subscriptions")
public class Subscription{
	
	//private static final long serialVersionUID = 1844136251472516656L;

    @ApiModelProperty(notes = "The email from customer")
    private String email;
    
    @ApiModelProperty(notes = "The auto-generated first name")
    private String firstName;
    
    @ApiModelProperty(notes = "The gender")
    private String gender;
    
    @ApiModelProperty(notes = "The date Of Birth")
    private Date dateOfBirth;
    
    @ApiModelProperty(notes = "The flag Consent")
    private Boolean flagConsent;
    
    @ApiModelProperty(notes = "The newsletter Id")
    private String newsletterId;
    
    @ApiModelProperty(notes = "The subscription id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subscriptionId;
     
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getFlagConsent() {
        return flagConsent;
    }

    public void setFlagConsent(Boolean flagConsent) {
        this.flagConsent = flagConsent;
    }
    
    public String getNewsletterId() {
        return newsletterId;
    }

    public void setNewsletterId(String newsletterId) {
        this.newsletterId = newsletterId;
    }
    
    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }   
}
```

At this point, you should be able to test the configuration by starting the app and pointing your browser to `http://localhost:8080/v2/api-docs.`

<img src="/Swagger_JSON_Output.png"/>

For nice human readable structured documentation, and this is where Swagger UI takes over, pointing your browser to `http://localhost:8080/swagger-ui.html`, you will see the generated documentation rendered by Swagger UI.


## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.arc.sbtest.SBtemplateApplication` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

The code can also be built into a jar and then executed/run. Once the jar is built, run the jar by double clicking on it or by using the command `java -jar SBtemplate-0.0.1-SNAPSHOT.jar`

To shutdown the jar, follow the below mentioned steps on a Windows machine.

*	In command prompt execute the **jcmd** command to print a list of all running Java processes
*	**Taskkill /PID PROCESS_ID_OF_RUNNING_APP /F** execute this command by replacing the **PROCESS_ID_OF_RUNNING_APP** with the actual process id of the running jar found out from executing the previous command

The app will start running at <http://localhost:8083>, change the database settings in **application.properties** file as per your need.

## Running the application via docker container

* 	[filipedaraujo/Subscription-Case-Study/spring-boot-subscriptionservice](https://hub.docker.com/repository/docker/filipedaraujo/spring-boot-subscriptionservice) - DockerHub Image

DockerHub Pull Command

```text
docker pull filipedaraujo/Subscription-Case-Study/spring-boot-subscriptionservice
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
|**`docker build -t spring-boot-subscriptionservice .`**   | **Build docker image of the project**                                    |
|**`docker run spring-boot-subscriptionservice`**          | **run the project's docker container**                                   |
|`docker stop [container_id]`                              | stop a container                                                         |
|`docker rm $(docker ps -aq)`                              | stop and remove all containers                                           |



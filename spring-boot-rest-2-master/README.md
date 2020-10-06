# Spring Boot Subscription Application

## Spring Boot REST API Controller
In Spring, a controller class, which is capable of serving REST API requests, is called rest controller. It should be annotated with @RestController annotation.
The resource uris are specified in @RequestMapping annotations. It can be applied at class level and method level both. Complete URI for an API is resolved after adding class level path and method level path.

In given controller, we have one API methods. 

HTTP POST /subscription – Register new subscription and return subcription id 

## Spring Boot Application
Our REST APIs skeleton is ready. Now we need to configure Spring to detect our rest controller (using auto scanning) and deploy apis in embedded tomcat server. Thankfully, Spring boot makes all these things very easy by using the concept of auto configuration.

Auto-configuration attempts to guess and configure beans we you are likely to need. Auto-configuration classes are usually applied based on the jars in application classpath and the beans we have defined additionally in @Configuration classes.

In this case, it does following things.

It detects spring-webmvc so configure default spring mvc application beans. It help in scan and configure @RestController and similar annotations.
It detects embed tomcat jars so configure embedded tomcat for us.
It detects JSON jars so configure JSON support to APIs.

## Model classes and DAO

```
InputMetada.java
```
```
package com.howtodoinjava.rest.model;
import java.util.DateTime;
 
public class Metadata {
  
  public InputMetadata() {
  }
 
    public InputMetadata(String traceParent, String traceState, String messageId, String messageCreatorId, DateTime messageCreationTimestamp) {
        super();
        this.traceParent = traceParent;
        this.traceState = traceState;
        this.messageId = messageId;
        this.messageCreatorId = messageCreatorId;
        this.messageCreationTimestamp = messageCreationTimestamp;
    }
  
    private String traceParent;
    private String traceState;
    private String messageId;
    private String messageCreatorId;
    private DateTime messageCreationTimestamp;
 
    //Getters and setters
 
    @Override
    public String toString() {
        return "InputMetadata [traceParent=" + traceParent + ", traceState=" + traceState + ", messageId=" + messageId + ", 
	messageCreatorId=" + messageCreatorId + ", messageCreationTimestamp=" + messageCreationTimestamp + "]"
    }
}
```

```
Subscription.java
```

```
package com.howtodoinjava.rest.model;
 
public class Subscitption {
  
  public Subscription() {
  }
 
    public Subscription(String email, String firstName, String gender, Date dateOfBirth, Boolean flagConsent,  String newsletterId, String subscriptionId) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.flagConsent = flagConsent;
        this.newsletterId = newsletterId;
        this.subscriptionId = subscriptionId;
    }
  
    private String email;
    private String firstName;
    private String gender;
    private Date dateOfBirth;
    private Boolean flagConsent;
    private String newsletterId;
    private Sring subscriptionId;
 
    //Getters and setters
 
    @Override
    public String toString() {
        return subcriptionId;
    }
}
```

```
DAO class uses a static list to store data. Here we need to implement actual database interaction.
SubscriptionDAO.java
```

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

The app will start running at <http://localhost:8080>, change the database settings in **application.properties** file as per your need.

## Running the application via docker container

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



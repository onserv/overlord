# IB Computer Science Internal Assessment

A Java RestAPI with SpringBoot including a full CRUD base of operations and implemented PostgreSQL database. Featuring a API controller, communicating with User, Roles, and Registry services, alongside a complete repository for full HTTP Get, Post, Put, and Delete mappings between applications.
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

In order to test locally there are a few pre-requisite dependencies

- Java OpenJDK 15
- Apache Maven
- PostgreSQL (need default password)
- Docker
- Git
- Favorite IDE for example IntelliJ or Visual Code
- Install IDE plugins like Java, SpringBoot, Lombok, and Maven support extensions
- Set two environment variables (db_pwd and api_port)

Review SpringBoot src/main/resources/application.properties for the api port, database ip and port, username and password.

```
1. Install the following Visual Code Extensions: Cloudfoundry Manifest YML Support, Concourse CI Pipeline Editor, Debugger for Java, Docker, ESLint, GitLens, Java Extension Pack, Java Test Runner, Language Support for Java(TM), Markdown Preview Enhanced, Maven for Java, PostgreSQL, Postman Runner, Prettier, Project Manager for Java, React Native Tools, Remote -WSL, SonarLint, Spring Boot Dashboard, Spring Boot Extension Pack, Spring Boot Tools, Spring Initializr Java Support, and Visual Studio IntelliCode.
2. Set up Docker Hub.
3. Set up GIT.
4. Set up API.
5. Set up database.
```

## Set Environment Variables

- export db_pwd=the user postgres password goes here
- export api_port=unused port goes here

- If you have postgres db running locally the Springboot can be started from the jar
- Simple way to get postgres is from docker hub and follow instructions: 

```
docker pull postgres
```

## Clone the source code from Github and run locally: 

```
git clone https://github.com/onserv/overlord.git
cd overlord
mvn clean install
mvn spring-boot:run
```

Alternatively after cloning the code use favorite IDE like Microsft Visual Code or IntelliJ to run.

Currently, the SpringBoot RestAPI is running on onserv.io:12000, however port has not been publicly exposed.

## Building API Docker Container

Modify Dockerfile to reference current compiled api jar for example:

```
FROM openjdk:15-jdk-slim
ARG JAR_FILE=./overlord-0.0.2-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
```

Modify builddocker.sh to build a named Docker container for example:

```
docker build -t overlordapi
```

To run the overlordapi named container on open ports with postgres password:

```
docker run -e db_pwd=the user password goes here -e api_port=unused port goes here -dp 12000:12500 --network=host overlordapi
```

## To Test API Using Postman

Install Postman, start the API, then create requests per example

![Example of how to test using Postman](postman.png)

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.0-SNAPSHOT/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.0-SNAPSHOT/maven-plugin/reference/html/#build-image)
* [Spring HATEOAS](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-spring-hateoas)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.4.2/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)

## Running the tests

* Postman
* Junit (wip)

## Deployment

Docker, maven, scripts

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

*  Benjamin Martin, 2021

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details




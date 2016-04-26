jpetstore-6-spring-data-mongodb
-------------------------------
 [![Build Status](https://travis-ci.org/igor-baiborodine/jpetstore-6-spring-data-mongodb.svg?branch=master)](https://travis-ci.org/igor-baiborodine/jpetstore-6-spring-data-mongodb)
 
#####This project is an exercise to port the original [JPetStore-6](https://github.com/mybatis/jpetstore-6) from RDBMS/MyBatis to NoSQL/MongoDB using Spring Data MongoDB.

######Run with Maven:
```bash
git clone https://github.com/igor-baiborodine/jpetstore-6-spring-data-mongodb.git
cd jpetstore-6-spring-data-mongodb

# In embedded mode
mvn clean package jetty:run -DskipTests

# In standalone mode if you have your MongoDB server installed
mvn clean package jetty:run -Dspring.profiles.active=standalone -DskipTests

# Access in your browser at http://localhost:8080
```

######Technologies used:######
* [Java SE 8](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html)
* [Lombok](https://projectlombok.org/) (you will need a Lombok plugin for the IDE of your choice)
* [Stripes](https://stripesframework.atlassian.net/wiki/display/STRIPES/Home)
* [Spring 4](http://projects.spring.io/spring-framework/#quick-start)
* [Spring Boot](http://projects.spring.io/spring-boot/)
* [Spring Data MongoDB](http://projects.spring.io/spring-data-mongodb/)
* [Embedded MongoDB](https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo)
* [Jetty](http://www.eclipse.org/jetty/)
* [Maven 3](http://maven.apache.org/)
* [JUnit 4](http://junit.org/)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)

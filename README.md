# weather-tracker-java-lambda-rds

This project is meant to be an exampleof how to create  and deploy an AWS Lambda function 
written in Java. The purpose of the Lambda function will be to retrieve weather 
statistics about the previous day from [WeatherAPI.com](https://weatherapi-com.p.rapidapi.com)
and persist the data into a relational database.

The Lambda function will be invoked once daily using an EventBridge cron trigger. It will be
configured as a Spring Boot application and will also leverage Spring Data JPA
and Spring Web. Given that this Lambda function only runs once per day and that it does not
need to be performant at all (i.e. there is no user waiting on a response from 
this Lambda function), we are not concerned with the long cold-start time caused by using so many Spring
libraries. Eventually, the Spring Boot application will be configured to run the Liquibase
database migration tool upon startup to ensure that the database schema version
is compatible with the version of the Lambda function itself.
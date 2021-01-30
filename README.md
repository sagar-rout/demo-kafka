# Demo Spring Boot with Apache Kafka

## Introduction

In this demo, we are sending Student json <strong>/students</strong> API. API will internally calls
StudentProducer bean and send message to the topic. In this example topic is "students".

There is one consumer, StudentConsumer bean which is listening for the topic, it will receive the message
and process as per the definition.

## Setup of apache Kafka

1. Download Apache Kafka : https://kafka.apache.org/downloads
2. Unzip the tar
3. Start zookeeper

```bash
$ tar -xzf kafka_2.13-2.7.0.tgz
$ cd kafka_2.13-2.7.0
$ bin/zookeeper-server-start.sh config/zookeeper.properties
$ bin/kafka-server-start.sh config/server.properties
```

Note: Your local environment should have at least Java 8 installed.

## Test the application

Start zookeeper and kafka, kafka will should run at localhost:9092 because we have configured in the app for the same. You can change the bootstrap-servers address if kafka is running at different server/host.

```bash
$ mvn spring-boot:run
$ http Post http://localhost:9000/students 'firstName=Sagar' 'lastName=Rout' 'age=29'
```

Check now console, you should have these two messages:

```bash
2021-01-30 23:38:47.445  INFO 34618 --- [nio-9000-exec-3] Producer : Send student information as an event @ Sat Jan 30 23:38:47 IST 2021
Student [firstName=Sagar, lastName=Rout, age=10]
```
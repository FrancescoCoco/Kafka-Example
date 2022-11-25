# Kakfa Example

It is a simple project to show the use of a kafka broker between a producer and a consumer.

Both producer and consumer are in the same project as Java Class in Spring Boot project, developed using Intellij.

The services deployed through a docker-compose.yaml are: 
- *zookeeper*: which is the main storage of kafka broker and it control the leader election.
- *kafka*: is the broker that receive the message from the producer and give it through the topics system to the consumer.
- *kafka-example*: the spring boot project with a producer and a consumer. 

The topic name is "example-topic". 

The information about kafka and how to build the application is on the file "Apache Kafka.pdf"

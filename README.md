# kafka_example

# Create Producer
./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic mytopic
# Create Consumer 
./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mytopic
# Start Kafka
 ./bin/kafka-server-start.sh config/server.properties
# Start Zookeeper
 sudo ./bin/zkServer.sh start 




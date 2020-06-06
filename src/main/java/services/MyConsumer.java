package services;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.PartitionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MyConsumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);
    @Autowired
    private ConsumerFactory<String, String> consumerFactory;

    @KafkaListener(topics = "mytopic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("********************************" + message);
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }

    public Set<String> getTopics() {
        try (Consumer<String, String> consumer =
                     consumerFactory.createConsumer()) {
            Map<String, List<PartitionInfo>> map = consumer.listTopics();
            return map.keySet();
        }
    }

}

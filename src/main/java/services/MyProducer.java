package services;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MyProducer {

    private final String TOPIC = "mytopic";
    private final String JSON_TOPIC = "jsontopic";

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    KafkaTemplate<String, User> userKafkaTemplate;

    public String sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message is send successfully";
    }

    public String sendUserMessage(User user) {
        userKafkaTemplate.send(TOPIC, user);
        return "Json Message is send successfully";
    }

}

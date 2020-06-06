package endpoints;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import services.MyConsumer;
import services.MyProducer;

import java.util.Set;

@RestController
public class UserController {

    @Autowired
    MyProducer producer;

    @Autowired
    MyConsumer consumer;

    @GetMapping("/send/{msg}")
    public String sendMessage(@PathVariable("msg") String message) {
        return producer.sendMessage(message);
    }

    @GetMapping("/sendUser/{name}")
    public String sendUserMessage(@PathVariable("name") String name) {
        return producer.sendUserMessage(new User(name, "Tech dept.", 2000L));
    }

    @GetMapping("listtopics")
    public Set<String> getTopics() {
        return consumer.getTopics();
    }

}

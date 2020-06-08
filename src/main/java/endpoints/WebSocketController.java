package endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    @RequestMapping("/websocket")
    public String getWebSocket() {
        return "ws-broadcast";
    }
}
package net.texala.eureka.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class ClientController {
	@Autowired
    private ServerServiceClient serverServiceClient;

    @GetMapping("/consumeData")
    public String consumeDataFromServer() {
        return serverServiceClient.getDataFromServer();
    }
}

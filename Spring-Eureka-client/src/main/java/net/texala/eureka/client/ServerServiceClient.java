package net.texala.eureka.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "server-service", url = "http://localhost:8080")
public interface ServerServiceClient {

    @GetMapping("/api/data")
    String getDataFromServer();
}

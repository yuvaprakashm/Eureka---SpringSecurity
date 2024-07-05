package net.texala.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String sayHelloAll() {
        return "Say Hello All";
    }
    @GetMapping("/user")
    public String sayHelloUser() {
        return "Say Hello User";
    }
    @GetMapping("/admin")
    public String sayHelloAdmin() {
        return "Say Hello Admin";
    }
}

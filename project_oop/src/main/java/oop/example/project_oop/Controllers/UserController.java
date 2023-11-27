package oop.example.project_oop.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @GetMapping("/")
    public String welcome1(){
        return "welcome";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}

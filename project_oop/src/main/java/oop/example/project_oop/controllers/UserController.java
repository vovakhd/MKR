package oop.example.project_oop.controllers;

import oop.example.project_oop.classes.Users;
import oop.example.project_oop.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import java.io.IOException;

@Controller
public class UserController {
    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public String welcome1(Authentication auth){
        return "welcome";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
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
    public String registration(Model model) {
        model.addAttribute("user", new Users());
        return "registration";
    }
    @PostMapping("/registration")
    public String newUser(@ModelAttribute Users user, Model model) throws IOException {
        model.addAttribute("user", user);
        if (!usersService.createUser(user)) { //if email is already used
            return "registration";
        }
        return "redirect:/login";
    }


}

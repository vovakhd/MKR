package oop.example.project_oop.controllers;

import lombok.AllArgsConstructor;
import oop.example.project_oop.classes.Users;
import oop.example.project_oop.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import java.io.IOException;

@Controller
@AllArgsConstructor
public class UserController {
    private final UsersService usersService;

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

    @GetMapping("/home")
    public String home(Authentication auth, Model model) {
        model.addAttribute("name", auth.getName());
        return "levels";
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

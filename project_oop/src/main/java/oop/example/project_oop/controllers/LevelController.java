package oop.example.project_oop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LevelController {
    @GetMapping("/levelA")
    public String levelA(Model model) {
        model.addAttribute("title", "Рівень А");
        model.addAttribute("level", "levelA");
        return "lessons";
    }
    @GetMapping("/levelB")
    public String levelB(Model model) {
        model.addAttribute("title", "Рівень B");
        model.addAttribute("level", "levelB");
        return "lessons";
    }
    @GetMapping("/Levels")
    public String levels() {
        return "levels";
    }
}
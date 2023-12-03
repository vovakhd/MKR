package oop.example.project_oop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{level}")
public class LessonController {
    @GetMapping("/lesson1")
    public String lesson1() {
        return "pageword";
    }
    @GetMapping("/lesson2")
    public String lesson2() {
        return "pageword";
    }
    @GetMapping("/lesson3")
    public String lesson3() {
        return "pageword";
    }
}
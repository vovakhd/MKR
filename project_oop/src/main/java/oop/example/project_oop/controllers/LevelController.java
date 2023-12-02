package oop.example.project_oop.controllers;

import com.opencsv.exceptions.CsvException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import oop.example.project_oop.classes.Levels;
import oop.example.project_oop.classes.Lessons;
import java.io.IOException;

@Controller

public class LevelController {
    @GetMapping("/levelA")
    public String levelA(Model model, Authentication auth) throws IOException, CsvException {
        model.addAttribute("title", "Рівень А");
        model.addAttribute("level", "levelA");
        model.addAttribute("Lesson1", Lessons.calculateProgress(auth.getName(),"A",1));
        model.addAttribute("Lesson2", Lessons.calculateProgress(auth.getName(),"A",2));
        model.addAttribute("Lesson3", Lessons.calculateProgress(auth.getName(),"A",3));
        return "lessons";
    }
    @GetMapping("/levelB")
    public String levelB(Model model, Authentication auth) throws IOException, CsvException {
        model.addAttribute("title", "Рівень B");
        model.addAttribute("level", "levelB");
        model.addAttribute("Lesson1", Lessons.calculateProgress(auth.getName(),"B",1));
        model.addAttribute("Lesson2", Lessons.calculateProgress(auth.getName(),"B",2));
        model.addAttribute("Lesson3", Lessons.calculateProgress(auth.getName(),"B",3));
        return "lessons";
    }
    @GetMapping("/Levels")
    public String levels(Model model, Authentication auth) {
        model.addAttribute("progressA",Levels.calculateLevelProgress(auth.getName(),"A"));
        model.addAttribute("progressB",Levels.calculateLevelProgress(auth.getName(),"B"));
        return "levels";
    }
}
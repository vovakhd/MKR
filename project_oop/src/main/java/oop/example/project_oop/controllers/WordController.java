package oop.example.project_oop.controllers;
import oop.example.project_oop.classes.Levels;
import oop.example.project_oop.services.UsersService;
import oop.example.project_oop.services.WordService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/{level}/{lessons}/pageword")
public class WordController {
    String Level;
    int Lesson;
    private final WordService wordService;
    public WordController(WordService Service) {
        this.wordService = Service;
    }

    @GetMapping("")
    public String pageword(Authentication auth, @PathVariable("level") String level, @PathVariable ("lessons") String lesson, Model model) {
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
        this.Level = String.valueOf(level.charAt(level.length()-1));
        this.Lesson = Integer.parseInt(String.valueOf(lesson.charAt(lesson.length()-1)));
        wordService.generateNewWord(Level,Lesson,auth.getName());
        if(wordService.getWord(auth.getName()).equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord(auth.getName()));
        return "pageword";
    }

    @PostMapping("/Click")
    public String Click(Authentication auth,@RequestParam String button,@PathVariable ("level") String level,@PathVariable ("lessons") String lesson, Model model) {
        if ("yes".equals(button)) {
            wordService.update_id(1, auth.getName());
        } else if ("no".equals(button)) {
            wordService.update_id(-1, auth.getName());
        }
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
        wordService.generateNewWord(Level,Lesson,auth.getName());
        if(wordService.getWord(auth.getName()).equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord(auth.getName()));
        return "pageword";
    }

    @PostMapping("/Result")
    public String Result(Authentication auth, @PathVariable ("level") String level,@PathVariable ("lessons") String lesson,Model model) {
        model.addAttribute("word", wordService.getWord(auth.getName()));
        model.addAttribute("translate", wordService.getTranslate(auth.getName()));
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
        return "answer";
    }

    @PostMapping("/Know")
    public String Know(Authentication auth,@PathVariable ("level") String level,@PathVariable ("lessons") String lesson,Model model) {
        wordService.update_id(5 - wordService.getIndicator(auth.getName()), auth.getName());
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
        wordService.generateNewWord(Level,Lesson,auth.getName());
        if(wordService.getWord(auth.getName()).equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord(auth.getName()));
        return "pageword";
    }

    @GetMapping("/Levels")
    public String Levels(Authentication auth,Model model) {
        model.addAttribute("progressA", Levels.calculateLevelProgress(auth.getName(),"A"));
        model.addAttribute("progressB",Levels.calculateLevelProgress(auth.getName(),"B"));
        return "redirect:/levels";
    }

}

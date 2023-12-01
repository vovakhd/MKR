package oop.example.project_oop.controllers;
import oop.example.project_oop.services.WordService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/{level}/{lesson}/pageword")
public class WordController {
    String Level;
    int Lesson;
    String Email;
    private WordService wordService;

    @GetMapping("")
    public String pageword(Authentication auth,@PathVariable("level") String level, @PathVariable ("lesson") String lesson, Model model) {
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
        this.Level = String.valueOf(level.charAt(level.length()-1));
        this.Lesson = Integer.parseInt(String.valueOf(lesson.charAt(lesson.length()-1)));
        this.Email = auth.getName();
        this.wordService = new WordService(Level, Lesson, Email);
        if(wordService.getWord().equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord());
        return "pageword";
    }

    @PostMapping("/Click")
    public String Click(@RequestParam String button,@PathVariable ("level") String level,@PathVariable ("lesson") String lesson, Model model) {
        if ("yes".equals(button)) {
            wordService.update_id(1);
        } else if ("no".equals(button)) {
            wordService.update_id(-1);
        }
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
        wordService.generateNewWord();
        if(wordService.getWord().equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord());
        return "pageword";
    }

    @PostMapping("/Result")
    public String Result(@PathVariable ("level") String level,@PathVariable ("lesson") String lesson,Model model) {
        model.addAttribute("word", wordService.getWord());
        model.addAttribute("translate", wordService.getTranslate());
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
        return "answer";
    }

    @PostMapping("/Know")
    public String Know(@PathVariable ("level") String level,@PathVariable ("lesson") String lesson,Model model) {
        if(wordService.getIndicator()<0){
            wordService.update_id(wordService.getIndicator()+5);
        }else {
            wordService.update_id(5 - wordService.getIndicator());
        }
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
        wordService.generateNewWord();
        if(wordService.getWord().equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord());
        return "pageword";
    }

    @GetMapping("/Levels")
    public String Levels() {
        return "redirect:/levels";
    }

}

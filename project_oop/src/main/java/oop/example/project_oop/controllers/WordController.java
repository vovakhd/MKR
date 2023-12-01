package oop.example.project_oop.controllers;
import oop.example.project_oop.services.WordService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/{level}/{lesson}/pageword")
public class WordController {
    private WordService wordService;

    @GetMapping("")
    public String pageword(Authentication auth,@PathVariable("level") String level, @PathVariable ("lesson") String lesson, Model model) {
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
        this.Level = String.valueOf(level.charAt(level.length()-1));
        this.Lesson = Integer.parseInt(String.valueOf(lesson.charAt(lesson.length()-1)));
        this.Email = auth.getName();
        this.wordService = new WordService();
        wordService.generateNewWord(Level,Lesson,auth.getName());
        if(wordService.getWord().equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord_now().getWord());
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
        if(wordService.getWord().equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord_now().getWord());
        return "pageword";
    }

    @PostMapping("/Result")
    public String Result(@PathVariable ("level") String level,@PathVariable ("lesson") String lesson,Model model) {
        model.addAttribute("word", wordService.getWord_now().getWord());
        model.addAttribute("translate", wordService.getWord_now().getTranslate());
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
        return "answer";
    }

    @PostMapping("/Know")
    public String Know(Authentication auth,@PathVariable ("level") String level,@PathVariable ("lessons") String lesson,Model model) {
        if(wordService.getIndicator()<0){
            wordService.update_id(wordService.getIndicator()+5, auth.getName());
        }else {
            wordService.update_id(5 - wordService.getIndicator(), auth.getName());
        }
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
        wordService.generateNewWord(Level,Lesson,auth.getName());
        if(wordService.getWord().equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord_now().getWord());
        return "pageword";
    }

    @GetMapping("/Levels")
    public String Levels() {
        return "redirect:/levels";
    }

}

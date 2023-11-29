package oop.example.project_oop.controllers;
import oop.example.project_oop.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WordController {
    WordService wordService=new WordService();

    @GetMapping("/pageword")
    public String pageword(Model model) {
        if(wordService.getWord().equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord());
        return "pageword";
    }

    @PostMapping("/Click")
    public String Click(@RequestParam String button,Model model) {
        if ("yes".equals(button)) {
            wordService.update_id(1);
        } else if ("no".equals(button)) {
            wordService.update_id(-1);
        }
        wordService.generateNewWord();
        if(wordService.getWord().equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord());
        return "pageword";
    }

    @PostMapping("/Result")
    public String Result(@RequestParam String button,Model model) {
        model.addAttribute("word", wordService.getWord());
        model.addAttribute("translate", wordService.getTranslate());
        return "answer";
    }

    @PostMapping("/Know")
    public String Know(@RequestParam String button,Model model) {
        if(wordService.getIndicator()<0){
            wordService.update_id(wordService.getIndicator()+5);
        }else {
            wordService.update_id(5 - wordService.getIndicator());
        }
        wordService.generateNewWord();
        if(wordService.getWord().equals("1")){
            return "allwords";
        }
        model.addAttribute("word", wordService.getWord());
        return "pageword";
    }

    @PostMapping("/AllWords")
    public String Allwords(@RequestParam String button) {
        return "levels";
    }

    @PostMapping("/Levels")
    public String Levels(@RequestParam String button) {
        return "levels";
    }

}

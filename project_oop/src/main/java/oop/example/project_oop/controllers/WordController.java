package oop.example.project_oop.controllers;
import oop.example.project_oop.services.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/{level}/{lesson}/pageword")
public class WordController {

    WordService wordService=new WordService();



    @GetMapping("")
    public String pageword(@PathVariable("level") String level, @PathVariable ("lesson") String lesson, Model model) {
        model.addAttribute("level", level);
        model.addAttribute("lesson", lesson);
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

    @PostMapping("/AllWords")
    public String Allwords(@RequestParam String button) {
        return "levels";
    }

    @PostMapping("/Levels")
    public String Levels(@RequestParam String button) {
        return "levels";
    }

}

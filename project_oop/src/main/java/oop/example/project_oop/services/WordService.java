package oop.example.project_oop.services;

import oop.example.project_oop.classes.Word;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static oop.example.project_oop.Data.WordData.create_Word;
import static oop.example.project_oop.Data.WordData.update_indikator;
@Service
public class WordService {
    private Word wordService ;
    private String email;
    private String level;
    private int lesson;

    public WordService(String level,int lesson,String email){
        this.email = email;
        this.level = level;
        this.lesson = lesson;
        try {
            this.wordService = create_Word(level, lesson, email);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTranslate(){
        return wordService.getTranslate();
    }

    public String getWord(){
        return wordService.getWord();
    }

    public int getIndicator() {
        return  wordService.getIndicator();
    }

    public void update_id(int update) {
        wordService.setIndicator(wordService.getIndicator()+update);
        try {
            update_indikator(wordService.getWord(),email,update);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateNewWord() {
        try {
            wordService = create_Word(level, lesson, email);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

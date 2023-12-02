package oop.example.project_oop.services;

import lombok.Getter;
import oop.example.project_oop.classes.Word;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static oop.example.project_oop.Data.WordData.create_Word;
import static oop.example.project_oop.Data.WordData.update_indikator;
@Service
public class WordService {
    private Word word_now ;

    public String getWord() {
        return word_now.getWord();
    }
    public String getTranslate() {
        return word_now.getTranslate();
    }
    public int getIndicator() {
        return word_now.getIndicator();
    }
    public void update_id(int update, String email) throws IOException {
        word_now.setIndicator(word_now.getIndicator()+update);
        update_indikator(word_now.getWord(),email,update);
    }

    /**Generate a new word from the vocabulary
     * depending on current user, level & lesson*/
    public void generateNewWord(String level,int lesson,String email) throws IOException {
        word_now = create_Word(level, lesson, email);
    }
}

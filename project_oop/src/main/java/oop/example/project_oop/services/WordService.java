package oop.example.project_oop.services;

import lombok.Getter;
import oop.example.project_oop.classes.Word;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static oop.example.project_oop.Data.WordData.create_Word;
import static oop.example.project_oop.Data.WordData.update_indikator;
@Service
@Getter
public class WordService {
    private Word word_now ;
    public void update_id(int update, String email) {
        word_now.setIndicator(word_now.getIndicator()+update);
        try {
            update_indikator(word_now.getWord(),email,update);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateNewWord(String level, String lesson, String email) {
        try {
            word_now =create_Word(level, Integer.parseInt(lesson), email);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

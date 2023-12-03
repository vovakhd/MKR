package oop.example.project_oop.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import oop.example.project_oop.classes.Word;
import oop.example.project_oop.repositories.WordRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static oop.example.project_oop.Data.WordData.create_Word;
import static oop.example.project_oop.Data.WordData.update_indikator;
@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository repository;
    private final UsersService usersService;
    public String getWord(String email) {
        return repository.findById(usersService.findUserId(email)).getWord();
    }
    public String getTranslate(String email) {
        return repository.findById(usersService.findUserId(email)).getTranslate();
    }
    public int getIndicator(String email) {
        return repository.findById(usersService.findUserId(email)).getIndicator();
    }
    public void update_id(int update, String email) {
        Word word = repository.findById(usersService.findUserId(email));
        repository.delete(word);
        word.setIndicator(word.getIndicator()+update);
        try {
            update_indikator(word.getWord(),email,update);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        repository.save(word);
    }

    /**Generate a new word from the vocabulary
     * depending on current user, level & lesson*/
    public void generateNewWord(String level,int lesson,String email) {
        try {
            if(repository.findById(usersService.findUserId(email)) != null)
                repository.delete(repository.findById(usersService.findUserId(email)));
            repository.save(create_Word(level, lesson, usersService.findUserId(email), email)) ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

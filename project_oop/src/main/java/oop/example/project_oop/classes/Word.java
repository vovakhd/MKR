package oop.example.project_oop.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Word {
    private String word;
    private String translate;
    private int indicator;
    @Id
    private Long id;

    public Word(String word,String translate,int indicator, Long User) {
        this.word=word;
        this.translate=translate;
        this.indicator=indicator;
        this.id = User;

    }

    public Word() {

    }

    public String getWord() {
        return word;
    }
    public String getTranslate() {
        return translate;
    }
    public int getIndicator() {
        return indicator;
    }
    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

}

package oop.example.project_oop.classes;

import lombok.Getter;

@Getter
public class Word {
    private String word;
    private String translate;
    private int indicator;

    public Word(String word,String translate,int indicator) {
        this.word=word;
        this.translate=translate;
        this.indicator=indicator;

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

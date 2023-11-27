package oop.example.project_oop.Classes;

import lombok.Getter;

@Getter
public class Word {
    private String word;
    private String translate;
    private int num;

    public Word(String word, String translate, int num) {
        this.word = word;
        this.translate = translate;
        this.num = num;
    }

    public String getWord(){
        return word;
    }
    public String getTranslate(){
        return  translate;
    }

    public int getNum(){
        return num;
    }
}

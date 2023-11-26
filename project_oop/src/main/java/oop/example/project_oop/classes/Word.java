package oop.example.project_oop.classes;

import lombok.Getter;

@Getter
public final class Word {
    final private String word;
    final private String translate;
    private int num;


    public Word() {
        this.word = "word";
        this.translate = "translation";
        this.num = 0;
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

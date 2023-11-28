package oop.example.project_oop.Classes;

import lombok.Getter;

@Getter
public class Word {
    private String word;
    private String translate;
    private int indikator;

    public Word(String word,String translate,int indikator) {
        this.word=word;
        this.translate=translate;
        this.indikator = indikator;
    }
    public String getWord(){
        return word;
    }
    public String getTranslate(){
        return  translate;
    }

    public int getIndikator(){
        return indikator;
    }
}

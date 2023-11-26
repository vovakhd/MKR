package com.example.project_oop.classes;

import lombok.Getter;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

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
}

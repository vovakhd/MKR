package oop.example.project_oop.Data;
import oop.example.project_oop.classes.Word;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WordData {
    public static Word create_Word(String level,int lesson,String email)  throws IOException{
        String file = "vocabulary.csv";
        BufferedReader reader = null;
        String line = "";
        int index =0;
        List<String> Word = new ArrayList<>();
        List<String> Translation = new ArrayList<>();
        List<Integer> Indicator= new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            String[] headlines = line.split(",");
            for (int i = 0; i < headlines.length; i++) {
                if (email.equals(headlines[i])) {
                    index = i;
                    break;
                }
            }
            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if(level.equals(row[0]) && Integer.parseInt(row[1]) == lesson && Integer.parseInt(row[index]) < 5) {
                    Word.add(row[2]);
                    Translation.add(row[3]);
                    Indicator.add(Integer.parseInt(row[index]));
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        Random random = new Random();
        int word_random=random.nextInt(Word.size());
        String word=Word.get(word_random);
        String translate=Translation.get(word_random);
        int indikator=Indicator.get(word_random);
        return new Word(word, translate, indikator);
    }

}

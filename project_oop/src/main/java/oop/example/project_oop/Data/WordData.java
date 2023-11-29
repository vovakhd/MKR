package oop.example.project_oop.Data;
import oop.example.project_oop.classes.Word;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
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

    public static void update_indikator(String word,String email,int update) throws IOException {
        String file = "vocabulary.csv";
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String line = "";
        int index_email = 0;
        int index_word = 1;
        int indikator = 0;
        String[] row = null;
        List<String[]> fileData = new ArrayList<>();
        //зчитування з файлу
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            String[] headlines = line.split(",");
            fileData.add(headlines);
            //пошук індекса стовпця
            for (int i = 0; i < headlines.length; i++) {
                if (email.equals(headlines[i])) {
                    index_email = i;
                    break;
                }
            }
            //пошук індекса рядка
            while ((line = reader.readLine()) != null) {
                row = line.split(",");
                if (row[2].equals(word)) {
                    indikator = Integer.parseInt(row[index_email]);
                    fileData.add(row);
                    break;
                }
                fileData.add(row);
                index_word++;
            }
            //зчитування в fileData
            while ((line = reader.readLine()) != null) {
                row = line.split(",");
                fileData.add(row);
            }

        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        //заміна рядка на оновлений в fileData
        row=fileData.get(index_word-1);
        row[index_email] = String.valueOf(indikator + update);
        fileData.set(index_word-1,row);
        //запис назад у файл
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(String.join(",", fileData.get(0)) + "\n");
            for (int i = 1;i < fileData.size(); i++){
                writer.write(fileData.get(i)[0]+","+fileData.get(i)[1]+","+fileData.get(i)[2]+","+fileData.get(i)[3]);
                for (int j = 4; j < fileData.get(i).length; j++) {
                    writer.write(","+Integer.parseInt(fileData.get(i)[j]));
                }
                writer.write("\n");
            }
        }finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}

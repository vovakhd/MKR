package com.example.project_oop.classes;

import org.supercsv.io.CsvMapReader;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Users {

    private int id;
    private String email;
    private String password;

    public Users(int id,String email,String password){
        this.id=id;
        this.email=email;
        this.password=password;
    }

    public int getId(){
        return id;
    }
    public String getEmail(){
        return  email;
    }
    public String getPassword(){
        return password;
    }
    public void changePassword(String newPassword){
        this.password=newPassword;
    }
    public String information(){
        return "User{" + "id='" + id + ", username='"+ ", email='" + email + '\'' + '}';
    }

    public static void addUserToVocabulary(String header_name) throws IOException {
        //add new column for new user in the vocabulary
        ICsvMapReader Reader = null;
        ICsvMapWriter Writer = null;
        try {
            //read vocabulary's headers, add new column
            Reader = new CsvMapReader(new FileReader("vocabulary.csv"), CsvPreference.STANDARD_PREFERENCE);
            final String[] oldHeaders = Reader.getHeader(true);
            final String[] newHeaders = new String[oldHeaders.length + 1];
            System.arraycopy(oldHeaders, 0, newHeaders, 0, oldHeaders.length);
            newHeaders[newHeaders.length - 1] = header_name;

            //write newHeaders with new column
            Writer = new CsvMapWriter(new FileWriter("vocabulary.csv"), CsvPreference.STANDARD_PREFERENCE);
            Writer.writeHeader(newHeaders);
            //fill column with -1 for every word
            Map<String, String> row;
            while ((row = Reader.read(oldHeaders)) != null) {
                row.put(header_name, "-1");
                Writer.write(row, newHeaders);
            }

        } finally { //close file
            if (Reader != null) {
                Reader.close();
            }
            if (Writer != null) {
                Writer.close();
            }
        }

    }
}

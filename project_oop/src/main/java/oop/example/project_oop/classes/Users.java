package oop.example.project_oop.classes;

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
    private String email;
    private String password;

    public Users(String email,String password){
        this.email=email;
        this.password=password;
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

}

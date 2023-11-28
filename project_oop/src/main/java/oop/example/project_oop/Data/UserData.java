package oop.example.project_oop.Data;
import java.io.*;
import oop.example.project_oop.classes.Users;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UserData {

    /**add new column for new user in the vocabulary*/
    public static  void addUserToVocabulary(Users user) throws IOException {
        ICsvMapReader Reader = null;
        ICsvMapWriter Writer = null;
        try {
            //read vocabulary's headers, add new column
            Reader = new CsvMapReader(new FileReader("vocabulary.csv"), CsvPreference.STANDARD_PREFERENCE);
            final String[] oldHeaders = Reader.getHeader(true);
            final String[] newHeaders = new String[oldHeaders.length + 1];
            System.arraycopy(oldHeaders, 0, newHeaders, 0, oldHeaders.length);
            newHeaders[newHeaders.length - 1] = user.getId().toString();

            //write newHeaders with new column
            Writer = new CsvMapWriter(new FileWriter("vocabulary.csv"), CsvPreference.STANDARD_PREFERENCE);
            Writer.writeHeader(newHeaders);
            //fill column with -1 for every word
            Map<String, String> row;
            while ((row = Reader.read(oldHeaders)) != null) {
                row.put(user.getId().toString(), "-1");
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
    /**add new user to file with users' information*/
    public static void write_User(Users user)  throws IOException{
        String file = "users.csv";
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            String email= user.getEmail();
            String password= user.getPassword();
            writer.write(email + "," + password + "\n");

        }finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static List<String> readUsersEmailorPassword(int num) throws IOException {
        String file = "users.csv";
        BufferedReader reader = null;
        String line = "";
        List<String> users_Email = new ArrayList<>();
        List<String> users_Password= new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();      //пропуск заголовків
            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                users_Email.add(row[0]);
                users_Password.add(row[1]);

            }
        }finally {
            if (reader != null) {
                reader.close();
            }
        }
        if(num==1) {
            return users_Email;
        }else{
            return  users_Password;
        }

    }

    public static String Email_Password(String email) throws IOException {
        String file = "users.csv";
        BufferedReader reader = null;
        String line = "";
        String users_Password = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();      //пропуск заголовків
            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if(email.equals(row[0])){
                    users_Password=row[1];
                }
            }
        }finally {
            if (reader != null) {
                reader.close();
            }
        }
        return users_Password;
    }


    public static void changePassword(String email,String password)  throws IOException{
        String file = "users.csv";
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String line = "";
        List<String> users_Email = new ArrayList<>();
        List<String> users_Password= new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if(email.equals(row[0])){
                    users_Password.add(password);
                }else{
                    users_Password.add(row[1]);
                }
                users_Email.add(row[0]);
            }
            writer = new BufferedWriter(new FileWriter(file));
            writer.write("email" + "," + "password" + "," + "id" + "\n");
            for(int i=0;i<users_Email.size();i++){
                writer.write(users_Email.get(i) + "," + users_Password.get(i) +  "\n");
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}

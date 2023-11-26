package oop.example.project_oop.Data;

import oop.example.project_oop.classes.Users;
import com.opencsv.CSVReader;
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
    public static  void addUserToVocabulary(String header_name) throws IOException {
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
    public static List<String> readUsersEmail() throws IOException {
        List<String> users_Email = new ArrayList<>();
        CsvMapReader reader = null;
        try  {
            reader = new CsvMapReader(new FileReader("users.csv"), CsvPreference.STANDARD_PREFERENCE);
            final String[] headers = reader.getHeader(true);
            Map<String, String> row;
            while ((row = reader.read(headers)) != null) {
                String email = row.get("email");
                users_Email.add(email);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return users_Email;


    }
    public static List<String> readUsersPassword() throws IOException {
        List<String> users_Password = new ArrayList<>();
        CsvMapReader reader = null;
        try  {
            reader = new CsvMapReader(new FileReader("users.csv"), CsvPreference.STANDARD_PREFERENCE);
            final String[] headers = reader.getHeader(true);
            Map<String, String> row;
            while ((row = reader.read(headers)) != null) {
                String email = row.get("email");
                users_Password.add(email);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return users_Password;
    }

}

package oop.example.project_oop;
import oop.example.project_oop.classes.Users;
import org.junit.jupiter.api.Test;
import static oop.example.project_oop.Data.UserData.write_User;
import static oop.example.project_oop.Data.UserData.Email_Password;
import static oop.example.project_oop.Data.UserData.addUserToVocabulary;
import static oop.example.project_oop.Data.UserData.delete_last_user;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class UserDataTest {

    @Test
    void new_User() throws IOException {
        String file = "vocabulary.csv";
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        String line1 = "";
        String line2 = "";
        reader1 = new BufferedReader(new FileReader(file));
        reader2 = new BufferedReader(new FileReader(file));
        line1 = reader1.readLine();
        String[] row1 = line1.split(",");
        Users user =new Users("user1","1234");
        addUserToVocabulary(user);
        delete_last_user();
        line2 = reader2.readLine();
        String[] row2 = line2.split(",");
        assertArrayEquals(row1, row2);
    }
    @Test
    void Write_User() throws IOException {
        Users user =new Users("user1","1234");
        write_User(user);
        String user_password=Email_Password("user1");
        assertEquals(user.getPassword(), user_password);

    }
    @Test
    void Email_password() throws IOException {
        String Password="$2a$08$aghNlEMojLAaO6uxxLbN1eagwTc4IlVEqz7Rh.C3qL8W2N.2moDaW";
        String user_password=Email_Password("user@mail");
        assertEquals(Password, user_password);
    }
}

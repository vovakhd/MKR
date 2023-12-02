package oop.example.project_oop;
import oop.example.project_oop.classes.Users;
import org.junit.jupiter.api.Test;
import static oop.example.project_oop.Data.UserData.write_User;
import static oop.example.project_oop.Data.UserData.Email_Password;
import static oop.example.project_oop.Data.UserData.changePassword;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
public class UserDataTest {
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
    @Test
    void ChangePassword() throws IOException {
        Users user =new Users("user@2","1111");
        write_User(user);
        String new_password="******";
        changePassword("user@2",new_password);
        String user_password=Email_Password("user@2");
        assertEquals(new_password, user_password);
    }
}

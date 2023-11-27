package oop.example.project_oop.classes;

import java.util.Objects;

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

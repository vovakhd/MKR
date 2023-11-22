package oop.example.project_oop.classes;

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

}

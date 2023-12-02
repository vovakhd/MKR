package oop.example.project_oop.classes;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;

    public Users() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Role> role = new HashSet<Role>();
        role.add(Role.ROLE_USER);  //ЗА ЗАМОВЧУВАННЯМ ВСІ КОРИСТУВАЧІ ЮЗЕРИ
        return role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password;
    }

    public void setEmail(String email) { this.email = email;
    }
}

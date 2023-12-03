package oop.example.project_oop.classestest;

import oop.example.project_oop.classes.Role;
import oop.example.project_oop.classes.Users;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTest {

    @Test
    public void testGetAuthorities() {
        Users user = new Users("test@example.com", "password");
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        assertEquals(1, authorities.size());
        assertEquals(Role.ROLE_USER, authorities.iterator().next());
    }

    @Test
    public void testGetters() {
        Users user = new Users("test@example.com", "password");

        assertEquals("test@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testSetAndGetPassword() {
        Users user = new Users("test@example.com", "password123");
        user.setPassword("newPassword");
        user.setEmail("newEmail");
        user.setId(1L);

        assertEquals("newPassword", user.getPassword());
        assertEquals("newEmail", user.getEmail());
        assertEquals(1L, user.getId());
    }
}

package oop.example.project_oop.classestest;

import oop.example.project_oop.classes.Role;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTest {

    @Test
    public void testGetAuthority() {
        Role userRole = Role.ROLE_USER;
        Role adminRole = Role.ROLE_ADMIN;

        assertEquals("ROLE_USER", userRole.getAuthority());
        assertEquals("ROLE_ADMIN", adminRole.getAuthority());
    }
}

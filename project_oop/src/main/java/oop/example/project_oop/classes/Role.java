package oop.example.project_oop.classes;

import org.springframework.security.core.GrantedAuthority;
//визначає роль користувача для визначення рівня доступу
public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}

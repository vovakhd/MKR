package oop.example.project_oop.authorization;

import lombok.RequiredArgsConstructor;
import oop.example.project_oop.classes.Users;
import oop.example.project_oop.repositories.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository repository;

    /** Security authorisation uses data from UserRepository,
     which contain all ever registered users*/
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Users user = repository.findByEmail(email);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.getAuthorities());
        } else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}
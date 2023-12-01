package oop.example.project_oop;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import oop.example.project_oop.services.UsersService;

@Component
@RequiredArgsConstructor
public class CustomApplicationRunner implements ApplicationRunner {
private final UsersService usersService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("APPLICATION IS WORKING!");
        usersService.loadUsersFromFile(); //завантажує користувачів з файлу у репозиторій
    }
}
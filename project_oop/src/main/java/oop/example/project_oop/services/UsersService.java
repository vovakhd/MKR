package oop.example.project_oop.services;

import lombok.RequiredArgsConstructor;
import oop.example.project_oop.ProjectOopApplication;
import oop.example.project_oop.classes.Users;
import oop.example.project_oop.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvMapReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import static oop.example.project_oop.Data.UserData.addUserToVocabulary;
import static oop.example.project_oop.Data.UserData.write_User;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final Logger log = LoggerFactory.getLogger(ProjectOopApplication.class);
    private final UsersRepository repository;
    private final PasswordEncoder passwordEncoder;

    /** - REGISTRATION of user -
     checking uniquely of email,
     encode a password,
     and save new user to repository
     and save new user to file
     and add to the vocabulary(personal progress)*/
    public boolean createUser(Users user) throws IOException {
        if (repository.findByEmail(user.getEmail()) != null) return false;  //check if email is used
        user.setPassword(passwordEncoder.encode(user.getPassword()));  //encode password for security
        repository.save(user); //save in repository as entity
        write_User(user); //add to the file with users
        addUserToVocabulary(user);  //add to the file vocabulary
        log.info("New User was registered: {} {}", user.getEmail(), user.getPassword());  //console's message
        return true;
    }

    /** - DOWNLOADING of users -
     and save users from file to repository
     (used only once when app is started)*/
    public boolean loadUsersFromFile() throws IOException {
        CsvMapReader Reader = null;
        try {
            //read headers
            Reader = new CsvMapReader(new FileReader("users.csv"), CsvPreference.STANDARD_PREFERENCE);
            final String[] Headers = Reader.getHeader(true);

            Map<String, String> row;
            while ((row = Reader.read(Headers)) != null) {
                //read each row and save the user as an entity in the repository
                Users user = new Users(row.get("email"), row.get("password"));
                repository.save(user);
                log.info("User was saved from file: {} {}", user.getEmail(), user.getPassword());
            }
            return true;

        }finally { //close file
            if (Reader != null)
                Reader.close();
        }

    }


}

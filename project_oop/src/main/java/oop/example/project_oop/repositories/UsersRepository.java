package oop.example.project_oop.repositories;

import oop.example.project_oop.classes.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>{
        Users findByEmail(String email);
        Users findById(long id);
}



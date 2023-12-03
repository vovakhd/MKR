package oop.example.project_oop.repositories;

import oop.example.project_oop.classes.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {
    Word findById(long id);
}

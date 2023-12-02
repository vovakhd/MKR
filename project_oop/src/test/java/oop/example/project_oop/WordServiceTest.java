package oop.example.project_oop;
import oop.example.project_oop.classes.Word;
import oop.example.project_oop.services.WordService;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static oop.example.project_oop.Data.WordData.create_Word;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WordServiceTest {
    @Test
    void WordService() throws IOException {
        WordService word =new WordService();
        word.generateNewWord("A",1,"user@mail");
        int Indikator1=word.getIndicator();
        word.update_id(1,"user@mail");
        assertNotEquals("1", word.getWord());
        assertNotEquals("1", word.getTranslate());
        assertEquals(Indikator1+1, word.getIndicator());
    }
}

package oop.example.project_oop;
import oop.example.project_oop.classes.Word;
import org.junit.jupiter.api.Test;
import static oop.example.project_oop.Data.WordData.create_Word;
import static oop.example.project_oop.Data.WordData.update_indikator;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
public class WordDataTest {
    @Test
    void create_Word_ValidWord() throws IOException {
        Word word =create_Word("A", 1, "user@mail");
        assertNotEquals("1", word.getWord());
        assertNotEquals("1", word.getTranslate());
        assertNotEquals(6, word.getIndicator());
    }
    // Для цього тесту в файлі в рівні А і уроці 3 всі індикатори мають бути 5
    @Test
    void create_Word_ID5() throws IOException {
        Word word =create_Word("A", 3, "user@mail");
        assertEquals("1", word.getWord());
        assertEquals("1", word.getTranslate());
        assertEquals(1, word.getIndicator());
    }
    //Для цього тесту в файлі в рівні B і уроці 3 всі індикатори мають бути 5 крім слова fascinating
    @Test
    void update_Id_One() throws IOException {
        Word word1 = create_Word("B", 3, "user@mail");
        update_indikator("fascinating","user@mail",1);
        Word word2 = create_Word("B", 3, "user@mail");
        assertEquals(word1.getIndicator()+1, word2.getIndicator());
        assertEquals(word1.getWord(), word2.getWord());
        assertEquals(word1.getTranslate(), word2.getTranslate());
    }

}

package oop.example.project_oop.classestest;

import oop.example.project_oop.classes.Word;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordTest {

    @Test
    public void testWordClass() {
        Word word = new Word("apple", "яблуко", 3);

        assertEquals("apple", word.getWord());
        assertEquals("яблуко", word.getTranslate());
        assertEquals(3, word.getIndicator());
    }

    @Test
    public void testSetIndicator() {
        Word word = new Word("apple", "яблуко", 3);
        word.setIndicator(5);

        assertEquals(5, word.getIndicator());
    }
}
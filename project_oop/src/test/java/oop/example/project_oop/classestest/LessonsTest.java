package oop.example.project_oop.classestest;

import com.opencsv.exceptions.CsvException;
import oop.example.project_oop.classes.Lessons;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LessonsTest {

    @Test
    public void testCalculateProgress() throws Exception {
        double progress = Lessons.calculateProgress("user@mail", "A", 2);
        assertEquals(3.85, progress, 0.01);
    }

    @Test
    public void testCalculateProgressWithInvalidEmail() {
        assertThrows(CsvException.class, () -> {
            Lessons.calculateProgress("nonexistentEmail", "A", 2);
        });
    }

    @Test
    public void testReadCSV() {
        assertDoesNotThrow(() -> {
            Lessons.readCSV();
        });
    }
}

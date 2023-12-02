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

    @Test
    public void testLessonsFields() {
        Lessons lesson = new Lessons();
        lesson.setNumberOfLesson("Lesson 1");
        lesson.setLessonProgress("75%");
        lesson.setId(1L);

        assertEquals("Lesson 1", lesson.getNumberOfLesson());
        assertEquals("75%", lesson.getLessonProgress());
        assertEquals(1L, lesson.getId());
    }
}

package oop.example.project_oop.classestest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import oop.example.project_oop.classes.Levels;

public class LevelsTest {

    @Test
    public void testCalculateLevelProgress() {
        double levelProgress = Levels.calculateLevelProgress("user@mail", "A");
        assertEquals(29.03, levelProgress, 0.01);
    }

    @Test
    public void testLevelFields() {
        Levels level = new Levels();
        level.setLevel("A");
        level.setLevelProgress("50%");
        level.setLessonsNumber(5);

        assertEquals("A", level.getLevel());
        assertEquals("50%", level.getLevelProgress());
        assertEquals(5, level.getLessonsNumber());
    }
}

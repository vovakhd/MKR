package oop.example.project_oop.classestest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import oop.example.project_oop.classes.Levels;

public class LevelsTest {

    @Test
    public void testCalculateLevelProgress() {
        double levelProgress = Levels.calculateLevelProgress("user@mail", "B");
        assertEquals(48.15, levelProgress, 0.01);
    }
}

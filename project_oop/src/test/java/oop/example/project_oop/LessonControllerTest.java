package oop.example.project_oop;

import oop.example.project_oop.controllers.LessonController;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class LessonControllerTest {

    @Test
    public void testLesson1() throws Exception {
        LessonController lessonController = new LessonController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(lessonController).build();
        mockMvc.perform(get("/some-level/lesson1"))
                .andExpect(status().isOk())
                .andExpect(view().name("pageword"));
    }

    @Test
    public void testLesson2() throws Exception {
        LessonController lessonController = new LessonController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(lessonController).build();
        mockMvc.perform(get("/some-level/lesson2"))
                .andExpect(status().isOk())
                .andExpect(view().name("pageword"));
    }

    @Test
    public void testLesson3() throws Exception {
        LessonController lessonController = new LessonController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(lessonController).build();
        mockMvc.perform(get("/some-level/lesson3"))
                .andExpect(status().isOk())
                .andExpect(view().name("pageword"));
    }
}

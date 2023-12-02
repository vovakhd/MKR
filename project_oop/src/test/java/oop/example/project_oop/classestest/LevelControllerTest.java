package oop.example.project_oop.classestest;

import com.opencsv.exceptions.CsvException;

import oop.example.project_oop.classes.Lessons;
import oop.example.project_oop.controllers.LevelController;
import org.junit.jupiter.api.Test;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class LevelControllerTest {

    @WithMockUser(value = "user@mail")

    @Test
    public void testLevelA() throws Exception {
        LevelController levelController = new LevelController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(levelController).build();

        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken("user@mail", "$2a$08$aghNlEMojLAaO6uxxLbN1eagwTc4IlVEqz7Rh.C3qL8W2N.2moDaW");
        Authentication auth = authManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();

        sc.setAuthentication(auth);
        mockMvc.perform(get("/levelA"))
                .andExpect(status().isOk())
                .andExpect(view().name("lessons"))
                .andExpect(model().attribute("title", "Рівень А"))
                .andExpect(model().attribute("level", "levelA"))
                .andExpect(model().attribute("Lesson1", Lessons.calculateProgress("user@mail","A",1)))
                .andExpect(model().attribute("Lesson2", Lessons.calculateProgress("user@mail","A",2)))
                .andExpect(model().attribute("Lesson3", Lessons.calculateProgress("user@mail","A",3)));
    }

    @Test
    public void testLevelB() throws Exception {
        LevelController levelController = new LevelController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(levelController).build();

        mockMvc.perform(get("/levelB"))
                .andExpect(status().isOk())
                .andExpect(view().name("lessons"))
                .andExpect(model().attribute("title", "Рівень B"))
                .andExpect(model().attribute("level", "levelB"))
                .andExpect(model().attribute("Lesson1", 50))
                .andExpect(model().attribute("Lesson2", 50))
                .andExpect(model().attribute("Lesson3", 50));
    }

    @Test
    public void testLevels() throws Exception {
        LevelController levelController = new LevelController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(levelController).build();

        mockMvc.perform(get("/Levels"))
                .andExpect(status().isOk())
                .andExpect(view().name("levels"))
                .andExpect(model().attribute("progressA", 50))
                .andExpect(model().attribute("progressB", 50));
    }
}
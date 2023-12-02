package oop.example.project_oop;

import oop.example.project_oop.classes.Lessons;
import oop.example.project_oop.classes.Levels;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class LevelControllerTest {
    @Autowired
    WebApplicationContext wac;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "user@mail")
    public void testLevelA() throws Exception {
        mockMvc.perform(get("/levelA").with(user("user@mail")))
                .andExpect(status().isOk())
                .andExpect(view().name("lessons"))
                .andExpect(model().attribute("title", "Рівень А"))
                .andExpect(model().attribute("level", "levelA"))
                .andExpect(model().attribute("Lesson1", Lessons.calculateProgress("user@mail","A",1)))
                .andExpect(model().attribute("Lesson2", Lessons.calculateProgress("user@mail","A",2)))
                .andExpect(model().attribute("Lesson3", Lessons.calculateProgress("user@mail","A",3)));
    }

    @Test
    @WithMockUser(username = "user@mail")
    public void testLevelB() throws Exception {

        mockMvc.perform(get("/levelB").with(user("user@mail")))
                .andExpect(status().isOk())
                .andExpect(view().name("lessons"))
                .andExpect(model().attribute("title", "Рівень B"))
                .andExpect(model().attribute("level", "levelB"))
                .andExpect(model().attribute("Lesson1", Lessons.calculateProgress("user@mail","B",1)))
                .andExpect(model().attribute("Lesson2", Lessons.calculateProgress("user@mail","B",2)))
                .andExpect(model().attribute("Lesson3", Lessons.calculateProgress("user@mail","B",3)));
    }

    @Test
    @WithMockUser(username = "user@mail")
    public void testLevels() throws Exception {

        mockMvc.perform(get("/Levels").with(user("user@mail")))
                .andExpect(status().isOk())
                .andExpect(view().name("levels"))
                .andExpect(model().attribute("progressA",Levels.calculateLevelProgress("user@mail","A")))
                .andExpect(model().attribute("progressB",Levels.calculateLevelProgress("user@mail","B")));

    }

}

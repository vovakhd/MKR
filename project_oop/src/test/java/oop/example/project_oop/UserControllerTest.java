package oop.example.project_oop;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import oop.example.project_oop.classes.Levels;
import oop.example.project_oop.classes.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIfRegularHomePageIsSecured() throws Exception {
        final ResultActions resultActions = mockMvc.perform(get("/"));
        resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("welcome"));
    }

    @Test
    public void testIfSpecialHomePageIsSecured() throws Exception {
        final ResultActions resultActions = mockMvc.perform(get("/levels"));
        resultActions
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithMockUser
    public void testIfLoggedUserHasAccessToRegularHomePage() throws Exception {
        final ResultActions resultActions = mockMvc.perform(get("/about"));
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("about"));
    }

    @Test
    @WithMockUser
    public void testIfLoggedUserHasAccessToSpecialHomePage() throws Exception {
        final ResultActions resultActions = mockMvc.perform(get("/Levels").with(user("user")));
        resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("levels"));
    }

    @Test
    @WithMockUser
    public void testLogin() throws Exception {
        final ResultActions resultActions = mockMvc.perform(get("/login"));
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    @WithMockUser
    public void testWelcome() throws Exception {
        final ResultActions resultActions = mockMvc.perform(get("/welcome"));
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"));
    }

    @Test
    @WithMockUser
    public void testRegistration() throws Exception {
        final ResultActions resultActions = mockMvc.perform(get("/registration"));
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("registration"));
    }
}

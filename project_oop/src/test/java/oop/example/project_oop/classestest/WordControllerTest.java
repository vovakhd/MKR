package oop.example.project_oop.classestest;

import oop.example.project_oop.controllers.WordController;
import oop.example.project_oop.services.WordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WordControllerTest {

    @Mock
    private WordService wordService;

    @InjectMocks
    private WordController wordController;

    @Mock
    private Authentication authentication;

    @Mock
    private Model model;

    @Test
    void testPageword() {
        when(authentication.getName()).thenReturn("testUser");
        when(wordService.getWord("testUser")).thenReturn("exampleWord");

        String result = wordController.pageword(authentication, "A", "1", model);

        verify(model).addAttribute("word", "exampleWord");
    }

    @Test
    void testClick() {
        when(authentication.getName()).thenReturn("testUser");
        when(wordService.getWord("testUser")).thenReturn("exampleWord");

        String result = wordController.Click(authentication, "yes", "A", "1", model);

        verify(wordService).update_id(1, "testUser");
        verify(model).addAttribute("level", "A");
        verify(model).addAttribute("lesson", "1");
    }

    @Test
    void testResult() {
        when(authentication.getName()).thenReturn("testUser");
        when(wordService.getWord("testUser")).thenReturn("exampleWord");
        when(wordService.getTranslate("testUser")).thenReturn("exampleTranslate");

        String result = wordController.Result(authentication, "A", "1", model);

        verify(model).addAttribute("word", "exampleWord");
        verify(model).addAttribute("translate", "exampleTranslate");
    }

    @Test
    void testKnow() {
        when(authentication.getName()).thenReturn("testUser");
        when(wordService.getIndicator("testUser")).thenReturn(2);
        when(wordService.getWord("testUser")).thenReturn("exampleWord");

        String result = wordController.Know(authentication, "A", "1", model);

        verify(wordService).update_id(anyInt(), eq("testUser"));
        verify(model).addAttribute("level", "A");
        verify(model).addAttribute("lesson", "1");
    }

}

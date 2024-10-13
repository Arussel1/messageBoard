package com.example.messageboard.controller;

import com.example.messageboard.model.Message;
import com.example.messageboard.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; // Import the post method
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MessageControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageController messageController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
    }

    @Test
    public void testIndex() throws Exception {
        Message message1 = new Message("Hello World!", "User1", new Date());
        Message message2 = new Message("Second message", "User2", new Date());
        when(messageRepository.findAll()).thenReturn(Arrays.asList(message1, message2));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("messages"))
                .andExpect(model().attribute("messages", Arrays.asList(message1, message2)));
    }

    @Test
    public void testNewMessageForm() throws Exception {
        mockMvc.perform(get("/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("form"))
                .andExpect(model().attributeExists("title"))
                .andExpect(model().attribute("title", "Send a Message"));
    }

    @Test
    public void testAddMessage() throws Exception {
        mockMvc.perform(post("/new")
                        .param("messageUser", "Test User")
                        .param("messageText", "Test Message"))
                .andExpect(status().is3xxRedirection()) 
                .andExpect(view().name("redirect:/"));
    }
}

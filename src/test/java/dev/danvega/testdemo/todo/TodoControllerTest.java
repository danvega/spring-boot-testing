package dev.danvega.testdemo.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoRepository todoRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void shouldFindAllTodos() throws Exception {
        var todos = List.of(new Todo("test 1", true), new Todo("test 2",true));
        Mockito.when(todoRepository.findAll()).thenReturn(todos);

        mockMvc.perform(get("/api/todos"))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(todos))
                );


    }

}
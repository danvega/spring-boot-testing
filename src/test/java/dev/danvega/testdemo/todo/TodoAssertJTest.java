package dev.danvega.testdemo.todo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoAssertJTest {

    @Test
    void shouldCreateNewTodo() {
        var test = new Todo("TEST",true);

        assertThat(test.name())
                .startsWith("T")
                .endsWith("T")
                .contains("ES")
                .isEqualToIgnoringCase("test");
    }

}

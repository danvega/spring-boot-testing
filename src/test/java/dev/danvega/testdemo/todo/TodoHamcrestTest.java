package dev.danvega.testdemo.todo;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TodoHamcrestTest {

    @Test
    void shouldCreateNewTodo() {
        var test1 = new Todo("TEST",true);
        var test2 = new Todo("TEST",true);

        assertThat(test1,equalTo(test2));
    }

}

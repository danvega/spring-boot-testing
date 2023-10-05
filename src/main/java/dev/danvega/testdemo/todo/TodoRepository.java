package dev.danvega.testdemo.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
class TodoRepository {

    private static final Logger log = LoggerFactory.getLogger(TodoRepository.class);
    List<Todo> todos = new ArrayList<>();

    public TodoRepository() {
        todos = List.of(new Todo("test 1", true), new Todo("test 2",true));
    }

    List<Todo> findAll() {
        log.info("TodoRepository.findAll() called..");
        return todos;
    }
}

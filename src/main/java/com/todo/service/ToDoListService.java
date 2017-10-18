package com.todo.service;

import com.todo.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ToDoListService {

    private List<ToDo> toDoList;

    ToDoListService() {
        this(new ArrayList<ToDo>(Arrays.asList(
                new ToDo(UUID.randomUUID().toString(), "Learning 1"),
                new ToDo(UUID.randomUUID().toString(), "Learning 2"),
                new ToDo(UUID.randomUUID().toString(), "Learning 3"),
                new ToDo(UUID.randomUUID().toString(), "Learning 4"),
                new ToDo(UUID.randomUUID().toString(), "Learning 5")
        )));
    }

    ToDoListService(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public boolean deleteToDo(String itemIdToBeDeleted) {
        return toDoList.removeIf(item -> item.getId().equals(itemIdToBeDeleted));
    }

    public boolean completeToDo(String idToBeCompleted) {
        Optional<ToDo> toDo = toDoList.stream()
                .filter(item -> item.getId().equals(idToBeCompleted))
                .findAny();
        toDo.ifPresent(x -> x.setCompleted(true));
        return toDo.isPresent();
    }

    public boolean addToDo(String name) {
        ToDo newItem = new ToDo(UUID.randomUUID().toString(),name);
        return toDoList.add(newItem);
    }
}

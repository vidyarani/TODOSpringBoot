package com.todo.service;

import com.todo.model.ToDo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ToDoListServiceTest {
    private List<ToDo> mockToDoList = new ArrayList<>();
    private ToDo toDoItem1, toDoItem2;
    private ToDoListService toDoListService;

    @Before
    public void setUp() {

        toDoItem1 = new ToDo("L1", "Learning 1");
        toDoItem2 = new ToDo("L2", "Learning 2");
        mockToDoList.add(toDoItem1);
        mockToDoList.add(toDoItem2);
        toDoListService = new ToDoListService(mockToDoList);
    }

    @Test
    public void shouldAddNewTodoItem(){
        toDoListService.addToDo("L20");
        assertEquals(3, mockToDoList.size());
    }

    @Test
    public void shouldDeleteToDoItem() {
        boolean isDeleted = toDoListService.deleteToDo("L1");
        assertTrue(isDeleted);
    }

    @Test
    public void shouldCompleteToDoItem(){
        boolean isCompleted = toDoListService.completeToDo("L2");
        assertTrue(isCompleted);
    }

    @Test
    public void shouldReturnFalseIfTodoIsNotCompleted(){
        boolean isCompleted = toDoListService.completeToDo("L10");
        assertFalse(isCompleted);
    }
}
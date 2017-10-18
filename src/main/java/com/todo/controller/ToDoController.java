package com.todo.controller;

import com.todo.model.ToDo;
import com.todo.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private ToDoListService toDoListService;

    @RequestMapping(value = "/list")
    public ResponseEntity<List<ToDo>> getToDoList() {
        List<ToDo> toDoList = toDoListService.getToDoList();
        return ResponseEntity.ok(toDoList);
    }


    @PostMapping(value = "/add/{name}")
    public ResponseEntity addToDo(@PathVariable String name) {
        boolean isToDoAdded = toDoListService.addToDo(name);
        if (isToDoAdded)
            return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteToDo(@PathVariable String id) {
        boolean isDeleted = toDoListService.deleteToDo(id);
        if (isDeleted)
            return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PatchMapping(value = "/complete/{id}")
    public ResponseEntity completeToDo(@PathVariable String id) {
        boolean isCompleted = toDoListService.completeToDo(id);
        if (isCompleted)
            return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

//    @DeleteMapping(value = "/delete1")
//    public ResponseEntity deleteToDo1(@RequestPart String id) {
//        System.out.println(id);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
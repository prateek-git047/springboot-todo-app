package com.example.todo.controller;
import com.example.todo.model.Todo;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/todos")
public class TodoController {
 private List<Todo> todoList=new ArrayList<>();
 private int idCounter=1;
 @PostMapping public Todo addTodo(@RequestBody String task){
  Todo t=new Todo(idCounter++,task); todoList.add(t); return t;
 }
 @GetMapping public List<Todo> getAllTodos(){ return todoList; }
 @DeleteMapping("/{id}") public String delete(@PathVariable int id){
  todoList.removeIf(t->t.getId()==id); return "Deleted";
 }
}
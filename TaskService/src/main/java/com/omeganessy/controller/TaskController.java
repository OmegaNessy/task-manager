package com.omeganessy.controller;

import com.omeganessy.model.Task;
import com.omeganessy.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    TaskServiceImpl taskServiceImpl;

    @Autowired
    public TaskController(TaskServiceImpl taskServiceImpl){
        this.taskServiceImpl = taskServiceImpl;
    }

    @PostMapping("/taskService/create")
    public ResponseEntity<Task> createNewTask(@RequestBody Task task){
        HttpStatus status;
        try{
            taskServiceImpl.createNewTask(task);
            status = HttpStatus.OK;
        }catch (Exception e){
            status = HttpStatus.SERVICE_UNAVAILABLE;
        }
        return ResponseEntity.status(status).body(task);
    }

    @GetMapping("/taskService/list")
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks;
        ResponseEntity<List<Task>> response;
        try {
            tasks = taskServiceImpl.getAllTasks();
            if(tasks != null){
                response = ResponseEntity.status(HttpStatus.OK).body(tasks);
            }else{
                response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return response;
    }

    @DeleteMapping("/taskService/delete")
    public ResponseEntity<Task> deleteTaskById(@RequestParam Long id){
        boolean deletedTask = taskServiceImpl.deleteTaskById(id);
        ResponseEntity<Task> response;
        try {
            if (deletedTask){
                response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return response;
    }

    @PutMapping("/taskService/update")
    public ResponseEntity<Task> updateTaskById(@RequestBody Task task){
        boolean updatedTask = taskServiceImpl.updateTask(task);
        ResponseEntity<Task> response;
        try {
            if (updatedTask){
                response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return response;
    }
}

package com.omeganessy.service;

import com.omeganessy.model.Task;

import java.util.List;

public interface TaskService {
    Task createNewTask(Task task);
    List<Task> getAllTasks();
    boolean deleteTaskById(Long id);
    boolean updateTask(Task task);
}

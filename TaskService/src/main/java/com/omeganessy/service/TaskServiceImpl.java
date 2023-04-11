package com.omeganessy.service;

import com.omeganessy.model.Task;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    
    @Override
    public Task createNewTask(Task task) {
        
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public boolean deleteTaskById(Long id) {
        return false;
    }

    @Override
    public boolean updateTask(Task task) {
        return false;
    }
}

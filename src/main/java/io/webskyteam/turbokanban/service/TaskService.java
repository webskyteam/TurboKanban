package io.webskyteam.turbokanban.service;
import io.webskyteam.turbokanban.dao.TaskDAO;
import io.webskyteam.turbokanban.entity.Task;
import io.webskyteam.turbokanban.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
}


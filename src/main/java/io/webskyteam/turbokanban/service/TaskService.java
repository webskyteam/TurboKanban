package io.webskyteam.turbokanban.service;
import io.webskyteam.turbokanban.dao.TaskDAO;
import io.webskyteam.turbokanban.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskDAO taskDAO;

    @Autowired
    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public List<Task> getTask() {
        return null;
    }
}

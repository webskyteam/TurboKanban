package io.webskyteam.turbokanban.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class KanbanBoard {

    private Map<TaskStatus, List<TaskDTO>> tasks;

    public KanbanBoard(List<TaskDTO> tasks) {
        this.tasks = new HashMap<>();
        for (TaskStatus status : TaskStatus.values()) {
            this.tasks.put(status, new ArrayList<>());
        }

        for (TaskDTO task : tasks) {
            addTaskToMap(task);
        }
    }

    private void addTaskToMap(TaskDTO task) {
        TaskStatus status = task.getProcessStatus();
        List<TaskDTO> taskDTOS = tasks.get(status);
        taskDTOS.add(task);
        tasks.put(status, taskDTOS);
    }

    public List<TaskDTO> getTasks(TaskStatus status) {

        return tasks.get(status);
    }
}

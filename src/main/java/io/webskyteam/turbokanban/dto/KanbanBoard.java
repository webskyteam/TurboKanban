package io.webskyteam.turbokanban.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class KanbanBoard {

    private Map<String, List<TaskDTO>> tasks;

    public KanbanBoard(List<TaskDTO> tasksDto) {
        this.tasks = new HashMap<>();
        for (int i = 0; i < tasksDto.size(); i++) {
            this.tasks.put(tasksDto.get(i).getProcessStatus(), new ArrayList<>());
        }

        for (TaskDTO task : tasksDto) {
            addTaskToMap(task);
        }
    }

    private void addTaskToMap(TaskDTO task) {
//        TaskStatus status = task.getProcessStatus();
        List<TaskDTO> taskDTOS = tasks.get(task.getProcessStatus());
        taskDTOS.add(task);
        tasks.put(task.getProcessStatus(), taskDTOS);
    }

    public List<TaskDTO> getTasks(String status){                  //TaskStatus status) {
        return tasks.get(status);
    }

//
//    public String getTasksStatus(){
//        return tasks.get();
//    }
}

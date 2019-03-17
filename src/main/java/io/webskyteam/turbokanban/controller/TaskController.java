package io.webskyteam.turbokanban.controller;

import io.webskyteam.turbokanban.entity.Task;
import io.webskyteam.turbokanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @RequestMapping("/table")
    public String listTasks(Model model) {
        List<Task> tasks = taskService.getTasks();

        List<Task> tasksToDo = new ArrayList<>();
        List<Task> tasksDoing = new ArrayList<>();
        List<Task> tasksDone = new ArrayList<>();
        List<Task> tasksArchive = new ArrayList<>();

        Map<String, List<Task>> tasksBystatus = new HashMap<>();
        tasksBystatus.put("todo", tasksToDo);
        tasksBystatus.put("done", tasksDone);
        tasksBystatus.put("doing", tasksDoing);
        tasksBystatus.put("archive",tasksArchive);


        for (Task task : tasks) {
            if (task.getProcessStatus().equals("todo")) {
                tasksToDo.add(task);
            }
            if (task.getProcessStatus().equals("done")) {
                tasksDone.add(task);
            }
            if(task.getProcessStatus().equals("doing")) {
                tasksDoing.add(task);
            }
            else {
                tasksArchive.add(task);
            }
        }

//        List<Task> tasks = taskService.getTaskToDo("todo");

//            model.addAttribute("tasks", tasks);
            model.addAttribute("tasksTODO",tasksBystatus.get("todo"));
            return "kanban-table";
        }
    }


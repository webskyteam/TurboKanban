package io.webskyteam.turbokanban.controller;

import io.webskyteam.turbokanban.dto.KanbanBoard;
import io.webskyteam.turbokanban.dto.TaskDTO;
import io.webskyteam.turbokanban.dto.TaskStatus;
import io.webskyteam.turbokanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/table")
    public String listTasks(Model model) {

        KanbanBoard kanbanTasks = taskService.getTasks();

        List<TaskDTO> tasksTodo = kanbanTasks.getTasks(TaskStatus.TODO);
        model.addAttribute("tasksTODO", tasksTodo);

        List<TaskDTO> tasksInProgress = kanbanTasks.getTasks(TaskStatus.IN_PROGRESS);
        model.addAttribute("tasksDOING", tasksInProgress);

        List<TaskDTO> tasksDone = kanbanTasks.getTasks(TaskStatus.DONE);
        model.addAttribute("tasksDONE", tasksDone);

        return "kanban-table";
    }

    @GetMapping("/addForm")
    public String showFormForAdd(Model model){

        TaskDTO taskDTO = new TaskDTO();

        model.addAttribute("task", taskDTO);

        return "task-form";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") TaskDTO theTask){

        taskService.saveTask(theTask);

        return "redirect:/table";
    }




}


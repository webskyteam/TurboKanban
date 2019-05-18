package io.webskyteam.turbokanban.controller;

import io.webskyteam.turbokanban.dto.KanbanBoard;
import io.webskyteam.turbokanban.dto.TaskDTO;
import io.webskyteam.turbokanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


        List<TaskDTO> tasksTodo = kanbanTasks.getTasks("TODO");
        model.addAttribute("tasksTODO", tasksTodo);

        List<TaskDTO> tasksInProgress = kanbanTasks.getTasks("IN_PROGRESS");
        model.addAttribute("tasksDOING", tasksInProgress);

        List<TaskDTO> tasksDone = kanbanTasks.getTasks("DONE");
        model.addAttribute("tasksDONE", tasksDone);

        return "kanban-table";
    }

    @GetMapping("/addForm")
    public String showFormForAdd(Model model){
        model.addAttribute("task", new TaskDTO());
        return "task-form";
    }

    @PostMapping("/save")
    public String saveTask(@Valid @ModelAttribute("task") TaskDTO theTask,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "task-form";
        } else {
            taskService.save(theTask);
            return "redirect:/table";
        }
    }

    @GetMapping("/showFormForUpdate")
    public String updateTask(@RequestParam("id") Integer id, Model theModel){
        TaskDTO taskDTO = taskService.findTaskById(id);
        theModel.addAttribute("task", taskDTO);
        return "task-form";
    }

    @GetMapping("delete")
    public String deleteTask(@RequestParam("id") Integer id){
        taskService.deleteTask(id);
        return "redirect:/table";
    }

    @GetMapping("deleteFromArchive")
    public String deleteTaskFromArchive(@RequestParam("id") Integer id){
        taskService.deleteTask(id);
        return "redirect:/archive";
    }

    @RequestMapping("/archive")
    public String listArchiveTasks(Model model) {
        KanbanBoard kanbanTasks = taskService.getTasks();
        List<TaskDTO> tasksArchive = kanbanTasks.getTasks("ARCHIVE");
        model.addAttribute("tasksArchive", tasksArchive);
        return "archive";
    }

    @GetMapping("/moveToInProgress")
    public String moveTaskToDoing(@RequestParam("id") Integer theId) {

        taskService.moveToInProgress(theId);

        return "redirect:/table";
    }

    @GetMapping("/moveToTodo")
    public String moveTaskToTodo(@RequestParam("id") Integer theId) {

        taskService.moveTaskToTodo(theId);

        return "redirect:/table";
    }

    @GetMapping("/moveToDone")
    public String moveTaskToDone(@RequestParam("id") Integer theId) {

        taskService.moveTaskToDone(theId);

        return "redirect:/table";
    }

    @GetMapping("/moveToArchive")
    public String moveTaskToArchive(@RequestParam("id") Integer theId) {

        taskService.moveTaskToArchive(theId);

        return "redirect:/table";
    }




}


package io.webskyteam.turbokanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TaskController {

    @RequestMapping(value="/table")
    public String listTasks() {
        return "kanban-table";
    }
}

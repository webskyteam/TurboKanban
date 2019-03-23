package io.webskyteam.turbokanban.service;
import io.webskyteam.turbokanban.EntityDTOConversion.TaskConverter;
import io.webskyteam.turbokanban.dto.KanbanBoard;
import io.webskyteam.turbokanban.dto.TaskDTO;
import io.webskyteam.turbokanban.dto.TaskStatus;
import io.webskyteam.turbokanban.entity.TaskEntity;
import io.webskyteam.turbokanban.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public KanbanBoard getTasks() {
        List<TaskEntity> all = taskRepository.findAll();
        List<TaskDTO> taskDtos = all.stream().map(e -> TaskConverter.toDto(e)).collect(Collectors.toList());

        KanbanBoard kanbanBoard = new KanbanBoard(taskDtos);

        return kanbanBoard;
    }


    public void saveTask(TaskDTO taskDTO) {

        TaskEntity taskEntity = TaskConverter.toEntity(taskDTO);
        taskRepository.save(taskEntity);
    }
}


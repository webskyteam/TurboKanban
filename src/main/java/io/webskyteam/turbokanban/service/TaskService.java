package io.webskyteam.turbokanban.service;

import io.webskyteam.turbokanban.EntityDTOConversion.TaskConverter;
import io.webskyteam.turbokanban.dto.KanbanBoard;
import io.webskyteam.turbokanban.dto.TaskDTO;
import io.webskyteam.turbokanban.dto.TaskStatus;
import io.webskyteam.turbokanban.entity.TaskEntity;
import io.webskyteam.turbokanban.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
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

    public void save(TaskDTO taskDTO) {
        TaskEntity taskEntity = TaskConverter.toEntity(taskDTO);
        taskRepository.save(taskEntity);
    }

    public TaskDTO findTaskById(Integer theId) {
        TaskEntity taskEntity = taskRepository.findOne(theId);
        TaskDTO taskDTO = TaskConverter.toDto(taskEntity);

        return taskDTO;
    }

    public void deleteTask(Integer theId) {
        taskRepository.delete(theId);
    }


    public void moveToInProgress(Integer theId) {
        TaskDTO taskDtoById = findTaskById(theId);
        taskDtoById.setProcessStatus(TaskStatus.IN_PROGRESS);
        save(taskDtoById);
    }

    public void moveTaskToTodo(Integer theId) {
        TaskDTO taskDtoById = findTaskById(theId);
        taskDtoById.setProcessStatus(TaskStatus.TODO);
        save(taskDtoById);
    }

    public void moveTaskToDone(Integer theId) {
        TaskDTO taskDtoById = findTaskById(theId);
        taskDtoById.setProcessStatus(TaskStatus.DONE);
        save(taskDtoById);
    }

    public void moveTaskToArchive(Integer theId) {
        TaskDTO taskDtoById = findTaskById(theId);
        taskDtoById.setProcessStatus(TaskStatus.ARCHIVE);
        save(taskDtoById);
    }
}


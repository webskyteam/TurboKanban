package io.webskyteam.turbokanban.EntityDTOConversion;

import io.webskyteam.turbokanban.dto.TaskDTO;
import io.webskyteam.turbokanban.entity.TaskEntity;

public class TaskConverter {

    public static TaskEntity toEntity(TaskDTO taskDto){
        return new TaskEntity(taskDto.getId(), taskDto.getProcessStatus(), taskDto.getTaskName(), taskDto.getDescription());
    }

    public static TaskDTO toDto(TaskEntity taskEntity){
        return new TaskDTO(taskEntity.getId(), taskEntity.getProcessStatus(), taskEntity.getTaskName(), taskEntity.getDescription());
    }
}

package io.webskyteam.turbokanban.dto;

public class TaskDTO {

    private Integer id;

    private TaskStatus processStatus;

    private String taskName;

    private String description;

    public TaskDTO(TaskStatus processStatus, String taskName, String description) {
        this.processStatus = processStatus;
        this.taskName = taskName;
        this.description = description;
    }

    public TaskDTO(){}

    public Integer getId() {
        return id;
    }

    public TaskStatus getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(TaskStatus processStatus) {
        this.processStatus = processStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

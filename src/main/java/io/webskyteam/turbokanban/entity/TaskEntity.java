package io.webskyteam.turbokanban.entity;


import io.webskyteam.turbokanban.dto.TaskStatus;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "process_status", length = 20)
    @Enumerated(EnumType.STRING)
    private TaskStatus processStatus;

    @Column(name = "task_name", length = 40)
    private String taskName;

    @Column(name = "description", length = 4000)
    private String description;

    public TaskEntity(TaskStatus processStatus, String taskName, String description) {
        this.processStatus = processStatus;
        this.taskName = taskName;
        this.description = description;
    }

    public TaskEntity(){}

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

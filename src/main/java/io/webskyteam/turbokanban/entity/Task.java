package io.webskyteam.turbokanban.entity;


import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "process_status", length = 20)
    private String processStatus;

    @Column(name = "task_name", length = 40)
    private String taskName;

    @Column(name = "description", length = 4000)
    private String description;

    public Task() {
    }

    public Task(String processStatus, String taskName, String description) {
        this.processStatus = processStatus;
        this.taskName = taskName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
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

package io.webskyteam.turbokanban.entity;


import javax.persistence.*;

@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "process_status", length = 20)
//    @Enumerated(EnumType.STRING)
    private String processStatus;

    @Column(name = "task_name", length = 40)
    private String taskName;

    @Column(name = "description", length = 4000)
    private String description;

    public TaskEntity(Integer id, String processStatus, String taskName, String description) {
        this.id = id;
        this.processStatus = processStatus;
        this.taskName = taskName;
        this.description = description;
    }

    public TaskEntity(){}

    public Integer getId() {
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

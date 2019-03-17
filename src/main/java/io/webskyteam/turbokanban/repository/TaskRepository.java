package io.webskyteam.turbokanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import  io.webskyteam.turbokanban.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task,Long>{
    List<Task> findByProcessStatus(String processStatus);
}

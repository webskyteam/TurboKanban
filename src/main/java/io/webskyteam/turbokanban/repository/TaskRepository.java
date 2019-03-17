package io.webskyteam.turbokanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import  io.webskyteam.turbokanban.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository <Task,Long>{

}

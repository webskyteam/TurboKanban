package io.webskyteam.turbokanban.dto;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KanbanBoardTest {

    @Test
    public void testCreationOfKanbanBoard() {
        List<TaskDTO> dtos = new ArrayList<>();
        dtos.add(new TaskDTO(1, TaskStatus.TODO, "zadanie 1", "opis zadania 1"));
        dtos.add(new TaskDTO(2, TaskStatus.TODO, "zadanie 2", "opis zadania 2"));

        KanbanBoard kanbanBoard = new KanbanBoard(dtos);

        Assert.assertEquals(2, kanbanBoard.getTasks(TaskStatus.TODO).size());
    }
}

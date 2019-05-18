package io.webskyteam.turbokanban.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Integer id;

    private String processStatus;

    @NotNull
    @Size(min=2, max=30, message = "Please, write min 2 and max 30 signs.")
    private String taskName;

    private String description;
}

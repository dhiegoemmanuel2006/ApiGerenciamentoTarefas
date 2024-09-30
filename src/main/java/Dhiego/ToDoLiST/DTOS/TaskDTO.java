package Dhiego.ToDoLiST.DTOS;

import Dhiego.ToDoLiST.models.StatusType;

public record TaskDTO(

        String taskName,
        String description,
        StatusType status,
        Boolean priorityTask) {
}

package Dhiego.ToDoLiST.models;

import Dhiego.ToDoLiST.DTOS.TaskDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String taskName;
    private String taskDescription;
    private StatusType taskStatus;
    public Boolean priorityTask;

    public Task(TaskDTO data){
        this.taskName = data.taskName();
        this.taskDescription = data.description();
        this.taskStatus = data.status();
        this.priorityTask = data.priorityTask();
    }
}

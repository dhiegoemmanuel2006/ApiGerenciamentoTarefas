package Dhiego.ToDoLiST.repository;

import Dhiego.ToDoLiST.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {


}

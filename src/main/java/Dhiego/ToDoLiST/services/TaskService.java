package Dhiego.ToDoLiST.services;

import Dhiego.ToDoLiST.DTOS.TaskDTO;
import Dhiego.ToDoLiST.models.Task;
import Dhiego.ToDoLiST.repository.TaskRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> findAll() {
        return repository.findAll();
    }


    public Task save(Task task) {
        return repository.save(task);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public ResponseEntity<Task> update(Long id, TaskDTO task) throws  Exception{
        Optional<Task> taskOptional = repository.findById(id);
       if(taskOptional.isPresent()){
           Task updatedTask = taskOptional.get();
           if(task.priorityTask() != null){
               updatedTask.setPriorityTask(task.priorityTask());
           } if(task.taskName() != null){
               updatedTask.setTaskName(task.taskName());
           } if(task.description() != null){
               updatedTask.setTaskDescription(task.description());
           } if(task.status() != null){
               updatedTask.setTaskStatus(task.status());
           }
           save(updatedTask);
           return ResponseEntity.ok(updatedTask);
       }
       else{
           throw new Exception("Servidor não consegue atualizar a tarefa");
       }
    }

}

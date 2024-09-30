package Dhiego.ToDoLiST.services;

import Dhiego.ToDoLiST.models.Task;
import Dhiego.ToDoLiST.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void delete(Long name){
        repository.deleteById(name);
    }

}

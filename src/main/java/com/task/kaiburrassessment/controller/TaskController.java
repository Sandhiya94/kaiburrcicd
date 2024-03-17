package com.task.kaiburrassessment.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;
import com.task.kaiburrassessment.model.Task;
import com.task.kaiburrassessment.service.ServiceImpl;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired		
	private ServiceImpl	 service;
	
	@GetMapping
	public List<Task> getTasks()
	{
		return service.findAllTasks();	
		}
	
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable String taskId){
    	try {
    		Task task = service.getTaskByTaskId(taskId);
    		return new ResponseEntity<>(task, HttpStatus.OK);
    	}
    	catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
      
    }
    
    @GetMapping("name/{name}")
    public ResponseEntity<List<Task>> getTaskByName(@PathVariable String name){
    	try {
    		List<Task> task = service.getTaskByName(name);
    		return new ResponseEntity<>(task, HttpStatus.OK);
    	}
    	catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
      
    }
    
    @GetMapping("/assignee/{assignee}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<List<Task>> getTaskByAssignee(@PathVariable String assignee){
    	try {
            List<Task> tasks= service.getTaskByAssignees(assignee);
            return new ResponseEntity<>(tasks, HttpStatus.OK);
    	}
    	catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task)
	{
        return service.addTask(task);
    }
	
	
	 @DeleteMapping("/{taskId}")
	    public String deleteTask(@PathVariable String taskId){
	        return service.deleteTask(taskId);
	    }
	
}

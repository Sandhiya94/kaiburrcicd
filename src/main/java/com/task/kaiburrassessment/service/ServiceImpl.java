package com.task.kaiburrassessment.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.task.kaiburrassessment.model.Task;
import com.task.kaiburrassessment.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class ServiceImpl {
	 @Autowired
	    private TaskRepository taskRepository;


	    public List<Task> findAllTasks() 
	    {
	        return taskRepository.findAll();
	    }
	    
	    public Task getTaskByTaskId(String taskId) throws NotFoundException{
//	        return taskRepository.findById(taskId).get();
	    	Optional<Task> tasks = taskRepository.findById(taskId);
	        if (tasks.isPresent())
	        {
	        	return tasks.get();
	        }
	        	else {
	            throw new NotFoundException();
	        	}
	    }
	    
	    public List<Task> getTaskByName(String name) throws NotFoundException
	    {
	    	List<Task> tasks = taskRepository.findByName(name);
	        if (tasks.isEmpty()) {
	            throw new NotFoundException();
	        }
	        return tasks;
	    }
	    
	    public List<Task> getTaskByAssignees(String assignee) throws NotFoundException
	    {   	
	    	 List<Task> tasks= taskRepository.findTop10ByAssigneeOrderByStartTimeDesc(assignee);
	        if (tasks.isEmpty()) {
	            throw new NotFoundException();
	        }
	        return tasks;
	    }
	    
	    public Task addTask(Task task) {
	    	 String name = "sandhiya";
	         int length = name.length();
	         StringBuilder selectedCharacters = new StringBuilder();         
	         Random random = new Random();       
	         for (int i = 0; i < 5; i++) {
	             int randomIndex = random.nextInt(length);
	             char randomChar = name.charAt(randomIndex);
	             selectedCharacters.append(randomChar);
	         }
	    	task.setSandhiyaProperty(selectedCharacters.toString());
	        return taskRepository.save(task);
	    }
	    
	    public String deleteTask(String taskId){
	        taskRepository.deleteById(taskId);
	        return taskId+"Deleted ";
	    }

}

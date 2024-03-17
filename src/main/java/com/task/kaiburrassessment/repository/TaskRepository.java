package com.task.kaiburrassessment.repository;
import com.task.kaiburrassessment.model.Task;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TaskRepository extends MongoRepository<Task, String> 
{
	List<Task> findTop10ByAssigneeOrderByStartTimeDesc(String assignee);

	List<Task> findByName(String name);
}

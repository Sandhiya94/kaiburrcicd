package com.task.kaiburrassessment.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;
@Document(collection = "tasks")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Task {
	@Id
	private String id;
	private String name;
	private String assignee;
	private String project ;
	private LocalDateTime startTime; 
	private String sandhiyaProperty;
	
	public Task() {
    }

    public Task(String name, String id, String assignee, String project, LocalDateTime startTime,String sandhiyaProperty) {
        this.name = name;
        this.id = id;
        this.assignee = assignee;
        this.project = project;
        this.startTime = startTime;
        this.sandhiyaProperty = "12345";
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAssignee() {
        return assignee;
    }
    public String getProject() {
        return project;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public String getSandhiyaProperty() {
        return sandhiyaProperty;
    }

    public void setSandhiyaProperty(String sandhiyaProperty) {
        this.sandhiyaProperty = sandhiyaProperty;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
    public void setStartTime(String startTime) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSX");
        this.startTime = LocalDateTime.parse(startTime, formatter);
    }
    public void setProject(String project) {
        this.project = project;
    }

}

package com.manage.task.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="parent_task_table")
public class ParentTask {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="parent_id")
	private int id;
	
	@Column(name="parent_task")
	private String parentTask;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Task> taskList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
	

}

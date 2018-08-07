package com.manage.task.service;

import java.util.List;

import com.manage.task.model.Task;

public interface ITaskService {
	
	public Task addTask(Task task);
	public Task editTask(Task task);
	public void deleteTask(int taskid);
	public List<Task> viewTasks();
	public Task findTaskById(int taskid);
	public Task endTask(Task task);
	

}

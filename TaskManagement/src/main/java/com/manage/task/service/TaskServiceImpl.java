package com.manage.task.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.task.dao.IParentRepository;
import com.manage.task.dao.ITaskRepository;
import com.manage.task.model.ParentTask;
import com.manage.task.model.Task;

@Service
public class TaskServiceImpl implements ITaskService {

	@Autowired
	private ITaskRepository taskRepo;

	@Autowired
	private IParentRepository parentRepo;

	@Transactional
	@Override
	public Task addTask(Task task) {

		ParentTask pTask = null;
		if (task.getParent() != null) {
			List<ParentTask> parentList = parentRepo.findAll();
			for (ParentTask parentTask : parentList) {
				if (parentTask.getParentTask() != null
						&& parentTask.getParentTask().equalsIgnoreCase(task.getParent().getParentTask())) {
					pTask = parentTask;
				}
			}
			if (pTask == null) {
				pTask = new ParentTask();
				pTask.setParentTask(task.getParent().getParentTask());
				parentRepo.save(pTask);
			}
		}
		task.setParent(pTask);
		task.setStatus("Open");
		return taskRepo.save(task);
	}

	@Transactional
	@Override
	public Task editTask(Task task) {

		ParentTask pTask = null;
		if (taskRepo.findById(task.getId()).isPresent()) {
			if (task.getParent() != null) {
				List<ParentTask> parentList = parentRepo.findAll();
				for (ParentTask parentTask : parentList) {
					if (parentTask.getParentTask() != null
							&& parentTask.getParentTask().equalsIgnoreCase(task.getParent().getParentTask())) {
						pTask = parentTask;
					}
				}
				if (pTask == null) {
					pTask = new ParentTask();
					pTask.setParentTask(task.getParent().getParentTask());
					parentRepo.save(pTask);
				}
			}

		}
		task.setParent(pTask);
		task.setStatus("Open");
		return taskRepo.save(task);
	}

	@Transactional
	@Override
	public void deleteTask(int taskid) {
		taskRepo.deleteById(taskid);
	}

	@Override
	public List<Task> viewTasks() {
		return taskRepo.findAll();
	}

	@Override
	public Task findTaskById(int taskid) {
		Optional<Task> optTask = taskRepo.findById(taskid);
		Task task = optTask.isPresent() ? optTask.get() : null;
		return task;
	}

	@Transactional
	@Override
	public Task endTask(Task task) {
		task.setStatus("Completed");
		return taskRepo.save(task);
	}

}

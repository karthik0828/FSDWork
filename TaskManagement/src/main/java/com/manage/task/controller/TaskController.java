package com.manage.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.task.model.Task;
import com.manage.task.service.ITaskService;

@RestController
@RequestMapping("/taskapp")
public class TaskController {

	@Autowired
	private ITaskService taskService;

	@GetMapping
	public ResponseEntity<List<Task>> viewAllTasks() {
		return new ResponseEntity<List<Task>>(taskService.viewTasks(), HttpStatus.OK);
	}

	@PostMapping("/newtask")
	public ResponseEntity<Task> addNewTask(@RequestBody Task task) {

		return new ResponseEntity<Task>(taskService.addTask(task), HttpStatus.OK);
	}

	@PutMapping("/updatetask")
	public ResponseEntity<Task> editTask(@RequestBody Task task) {
		return new ResponseEntity<Task>(taskService.editTask(task), HttpStatus.OK);
	}

	@DeleteMapping("/deletetask/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable(value = "id") int id) {
		ResponseEntity<Void> response = null;
		taskService.deleteTask(id);
		response = new ResponseEntity<>(HttpStatus.OK);
		return response;
	}

	@GetMapping("/findtask/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") int id) {
		return new ResponseEntity<Task>(taskService.findTaskById(id), HttpStatus.OK);
	}

	@PutMapping("/endtask")
	public ResponseEntity<Task> endTask(@RequestBody Task task) {
		return new ResponseEntity<Task>(taskService.endTask(task), HttpStatus.OK);
	}

}

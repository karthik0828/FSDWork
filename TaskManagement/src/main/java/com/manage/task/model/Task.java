package com.manage.task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task_table")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_id")
	private int id;
	
	@Column(name="task")
	private String taskName;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="end_date")
	private String endDate;
	
	@Column(name="priority")
    private int priority;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="parent_id" , nullable=false)
	private ParentTask parent;
	
	@Column(name="status")
    private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public ParentTask getParent() {
		return parent;
	}

	public void setParent(ParentTask parent) {
		this.parent = parent;
	}
	
	

}

package com.manage.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.task.model.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task,Integer>{

}

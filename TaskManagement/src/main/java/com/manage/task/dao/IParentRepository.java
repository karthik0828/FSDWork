package com.manage.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.task.model.ParentTask;

@Repository
public interface IParentRepository extends JpaRepository<ParentTask,Integer>{

}

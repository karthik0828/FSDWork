package com.manage.task;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.manage.task.controller.TaskController;
import com.manage.task.model.Task;
import com.manage.task.service.ITaskService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TaskController.class)
public class TaskControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	private ITaskService taskService;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testViewAllTasks() throws Exception {
		Task task = new Task();
		task.setTaskName("UI Design");
		
		List<Task> allTasks = singletonList(task);
		
		given(taskService.viewTasks()).willReturn(allTasks);
		
		   mockMvc.perform(get("/taskapp").accept(MediaType.APPLICATION_JSON)) 
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(1)))
	      .andExpect(jsonPath("$[0].taskName", is(task.getTaskName())));
		
	}

}

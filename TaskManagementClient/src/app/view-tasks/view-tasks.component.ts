import { Component, OnInit } from '@angular/core';
import { TaskMngService } from '../service/task-mng.service';
import {Task } from '../model/task';
import { TaskSearchPipe } from '../task-search.pipe';

@Component({
  selector: 'app-view-tasks',
  templateUrl: './view-tasks.component.html',
  styleUrls: ['./view-tasks.component.css'],
  providers: [TaskMngService],
  
})
export class ViewTasksComponent implements OnInit {

   private tasks : Task[] =[];
   task : Task = new Task();

  constructor(private taskMngService : TaskMngService) { }

  ngOnInit() {
    this.taskMngService.viewtasks()
    .subscribe(data => this.tasks = data)
  }

  deleteTask(task){
    if (confirm("Are you sure want to delete " + task.taskName + "?")) {


      this.taskMngService.deletetask(task)
      .subscribe(success => {
        var index = this.tasks.indexOf(task);
        this.tasks.splice(index, 1);
        this.getlatestView(); 
        });
      


    }
  }

  getlatestView(){
    this.taskMngService.viewtasks()
    .subscribe(data => this.tasks = data)
  }

  endTask(task){
    if (confirm("Are you sure want to end the task " + task.taskName + "?")) {
      this.taskMngService.endtask(task)
      .subscribe(task => {
      this.task = task;
      this.getlatestView();
      });          
    
   }
  }
}

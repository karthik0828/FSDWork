import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'taskSearch'
})
export class TaskSearchPipe implements PipeTransform {

  transform(tasks: any, taskNameSearch: string, parentSearch: string, startDateSearch: string,endDateSearch: string): any {
    if (tasks && tasks.length){
      return tasks.filter(task =>{
          if (taskNameSearch && task.taskName.toLowerCase().indexOf(taskNameSearch.toLowerCase()) === -1){
              return false;
          }
          if (parentSearch && task.parent.parentTask.toLowerCase().indexOf(parentSearch.toLowerCase()) === -1){
              return false;
          }
          if (startDateSearch && task.startDate.toLowerCase().indexOf(startDateSearch.toLowerCase()) === -1){
              return false;
          }
          if (endDateSearch && task.endDate.toLowerCase().indexOf(endDateSearch.toLowerCase()) === -1){
            return false;
        }
          return true;
     })
  }
  else{
      return tasks;
  }
  }

}

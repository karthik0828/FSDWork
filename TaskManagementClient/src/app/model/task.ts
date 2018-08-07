import { ParentTask } from '../model/parent-task';

export class Task {

    id:number;
    taskName:string;
    startDate:string;
    endDate:string;
    priority:number;    
    parent: ParentTask = new ParentTask();
    status:string;

}

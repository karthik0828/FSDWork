import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map'

@Injectable()
export class TaskMngService {

  constructor(private http:Http) {

   }

   private url : string ="/taskapp";
   private addUrl : string ="/taskapp/newtask";
   private updateUrl : string ="/taskapp/updatetask";
   private deleteUrl : string ="/taskapp/deletetask";
   private getUrl : string = "/taskapp/findtask";
   private endUrl : string = "/taskapp/endtask";

   viewtasks(){
       return this.http.get(this.url)
       .map(res => res.json())
   }

   addtask(task){
        return this.http.post(this.addUrl,task)
        .map(res => res.json());
   }

   updatetask(task,id){
    task.id = id;
    return this.http.put(this.updateUrl,task)
    .map(res => res.json());
  }

  deletetask(task){
    return this.http.delete(this.deleteUrl+"/"+task.id)
    .map(res => res.status);
  }

  gettask(id){
    return this.http.get(this.getUrl+"/"+id)
    .map(res => res.json());
  }

  endtask(task){
    return this.http.put(this.endUrl,task)
    .map(res => res.json());
  }

}

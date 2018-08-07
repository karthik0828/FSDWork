import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule , ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { ViewTasksComponent } from './view-tasks/view-tasks.component';
import { TaskMngService } from './service/task-mng.service';
import { AddTaskComponent } from './add-task/add-task.component';
import { EditTaskComponent } from './edit-task/edit-task.component';
import { TaskSearchPipe } from './task-search.pipe';
import { NavigationComponent } from './navigation/navigation.component';
import { HomeComponent } from './home/home.component';

const appRoutes : Routes = [
  {path: '', pathMatch: 'full',component: HomeComponent},
  {path:'home' , component:HomeComponent},
  {path:'viewtasks' ,component:ViewTasksComponent},
  {path:'addtask' ,component:AddTaskComponent},
  {path:'edittask/:id' , component:EditTaskComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    ViewTasksComponent,   
    AddTaskComponent,
    EditTaskComponent,
    TaskSearchPipe,
    NavigationComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [TaskMngService], 
  bootstrap: [AppComponent]
})
export class AppModule { }

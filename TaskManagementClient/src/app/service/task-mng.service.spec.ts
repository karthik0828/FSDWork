/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TaskMngService } from './task-mng.service';

describe('TaskMngService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TaskMngService]
    });
  });

  it('should ...', inject([TaskMngService], (service: TaskMngService) => {
    expect(service).toBeTruthy();
  }));
});

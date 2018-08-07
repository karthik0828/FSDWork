import { TaskManagementClientPage } from './app.po';

describe('task-management-client App', function() {
  let page: TaskManagementClientPage;

  beforeEach(() => {
    page = new TaskManagementClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

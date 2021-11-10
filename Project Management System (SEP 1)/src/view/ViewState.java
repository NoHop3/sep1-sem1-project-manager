package view;

public class ViewState
{
  private int selectedProject;
  private int selectedReq;
  private int selectedTask;
  private int selectedTM;
  public ViewState(){
    this.selectedProject=-1;
    this.selectedReq=-1;
    this.selectedTask=-1;
    this.selectedTM=-1;
  }
  public int getSelectedProject()
  {
    return selectedProject;
  }
  public int getSelectedReq()
  {
    return selectedReq;
  }
  public int getSelectedTask()
  {
    return selectedTask;
  }
  public int getSelectedTM()
  {
    return selectedTM;
  }
  public void setSelectedProject(int selectedProject){
    this.selectedProject = selectedProject;
  }
  public void setSelectedReq(int selectedReq){
    this.selectedReq = selectedReq;
  }
  public void setSelectedTask(int selectedTask){
    this.selectedTask = selectedTask;
  }
  public void setSelectedTM(int selectedTM)
  {
    this.selectedTM = selectedTM;
  }
}

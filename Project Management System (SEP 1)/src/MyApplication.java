import javafx.application.Application;
import javafx.stage.Stage;
import model.ProjectModel;
import model.ProjectModelManager;
import view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    ProjectModel model = new ProjectModelManager();
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}

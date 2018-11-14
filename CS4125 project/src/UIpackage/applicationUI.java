package UIpackage;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author seani
 */
public class applicationUI  extends Application{
    
    public void applicationUI(){
        Stage appS = new Stage();
        start(appS);
    }

    @Override
    public void start(Stage appS) {
        appS.setTitle("Login Screen");
        
    }
    
}

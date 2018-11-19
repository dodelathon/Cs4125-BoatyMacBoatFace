package UIpackage;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author seani
 */
public class applicationUI  {


    public void applicationUI(String username){
        Stage appStage = new Stage();
        start(appStage, username);
    }

    public void start(Stage appS, String username) {
        appS.setTitle("Game Lobby");
        
        System.out.println(username);
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIpackage;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author seani
 */
public class gameScreenUI extends Application{

    public void gameScreenUI() throws Exception {
        Stage gameS = new Stage();
        start(gameS);
    }
    
    @Override
    public void start(Stage gameStage) throws Exception {
        System.out.println("here");
    }
    
}

package UIpackage;

import Objects.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.*;

/**
 *
 * @author seani
 */
public class applicationUI  {


    public void applicationUI(Stage loginStage, String [] userDetails){
        Stage appStage = new Stage();
        start(appStage, userDetails, loginStage);
    }

    public void start(Stage appS, String [] userDetails, Stage loginStage) 
    {
        boolean isDev = false;
        appUsers currentUser = null;
        appUsersFactory userFactory = new appUsersFactory();
        if (userDetails[2].equals("0"))
        {
            currentUser = userFactory.makeUser("player");
            currentUser.setUsername(userDetails[1]);
        }
        else
        {
            isDev = true;
            currentUser = userFactory.makeUser("dev");
            currentUser.setUsername(userDetails[1]);
        }
        System.out.println(currentUser.getUsername());
        appS.setTitle("Main Menu");
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10,50,50,50));
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));        
        GridPane gPane = new GridPane();
        gPane.setPadding(new Insets(20,20,20,20));
        gPane.setHgap(5);
        gPane.setVgap(5);     
        
        Button viewLeaderboardbtn = new Button("View Leaderboard");
        Button startGamebtn = new Button("Start Game");
        Button changeRatingbtn = new Button("Change Rating");
        Button logoutbtn = new Button("Logout");
        gPane.add(viewLeaderboardbtn,0,1);
        gPane.add(startGamebtn,1,1);
        gPane.add(changeRatingbtn,2,1);
        gPane.add(logoutbtn,0,2);
        
        bPane.setTop(hb);
        bPane.setCenter(gPane);
        Scene appScene = new Scene(bPane);
        appScene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        appS.setScene(appScene);
        appS.setResizable(false);
        appS.show();     
        
        viewLeaderboardbtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event)
            {
                try 
                {
                    leaderboardUI leaderboard = new leaderboardUI();
                } 
                catch (Exception ex) {
                    Logger.getLogger(applicationUI.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        });
               
        startGamebtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event)
            {
                gameScreenUI gameScreen = new gameScreenUI();
                try 
                {
                    gameScreen.gameScreenUI();
                } 
                catch (Exception ex) 
                {
                    Logger.getLogger(applicationUI.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
        
         changeRatingbtn.setOnAction(new EventHandler() 
         {
            @Override
            public void handle(Event event)
            {
                try 
                {
                     changeRatingUI changeRating = new changeRatingUI();
                } 
                catch (Exception ex) 
                {
                    Logger.getLogger(applicationUI.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
        
        logoutbtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event)
            {
                try 
                {
                    loginStage.show();
                    appS.hide();
                } 
                catch (Exception ex) 
                {
                    Logger.getLogger(applicationUI.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
    }
}

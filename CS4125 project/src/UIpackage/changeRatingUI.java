/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIpackage;

import Data_Layer.Client_socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import Data_Layer.Client_socket;


/**
 *
 * @author hilto
 */
public class changeRatingUI 
{
    private Stage changeRatingS;

    public changeRatingUI() throws Exception
    {
       this.changeRatingS = new Stage();
       //changeRatingStart (changeRatingS);
    }

    
    public void changeRatingStart(Stage changeRatingStage, String[] userDetails)
    {
        
        changeRatingStage.setTitle("Change Rating");
        
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(20,20,20,20));
        
        HBox hb = new HBox();
        hb.setPadding(new Insets(0,0,0,0));
        
        GridPane gPane = new GridPane();
        gPane.setPadding(new Insets(20,20,20,20));
        gPane.setHgap(80);
        gPane.setVgap(100);
        
        Button enterBtn = new Button("Enter");
        Label newRating = new Label("New Rating");
        final TextField newRatingText = new TextField();
        
        
        gPane.add(enterBtn, 3, 5);
        gPane.add(newRating, 0, 0);
        gPane.add(newRatingText, 1, 0);
     
        bPane.setId("bPane");
        gPane.setId("root");
        enterBtn.setId("Btn");
        
        bPane.setTop(hb);
        bPane.setCenter(gPane);
        Scene changeRatingScene = new Scene(bPane);
        changeRatingScene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        changeRatingStage.setScene(changeRatingScene);
        //leaderboardStage.titleProperty().bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));
        changeRatingStage.setResizable(false);
        changeRatingStage.show();
        
        enterBtn.setOnAction(new EventHandler() 
         {
            @Override
            public void handle(Event event)
            {
                try 
                {
                    if (userDetails[2].equals("1"))
                    {
                        Client_socket proxy = new Client_socket();
                        String matchMaker;
                        
                        matchMaker = proxy.sendInfo("getAll,matchmaker_info");
                        String [] interim = matchMaker.split(",");
                        
                        for(int i = 0; i < interim.length - 5; i += 5)
                        {
                            
                        }
                    }
                    else
                    {
                        changeRatingUI changeRating = new changeRatingUI();
                    }
                } 
                catch (Exception ex) 
                {
                    Logger.getLogger(applicationUI.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
    }
    
    Stage getStage()
    {
        return this.changeRatingS;
    }
}


   

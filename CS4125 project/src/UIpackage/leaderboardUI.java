/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIpackage;

import Data_Layer.Client_socket;
import javafx.application.Application;
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

/**
 *
 * @author seani
 */
public class leaderboardUI 
{
    
    public leaderboardUI() throws Exception
    {
       Stage leaderboardS = new Stage();
       leaderboardStart (leaderboardS);
    }

    
    public void leaderboardStart(Stage leaderboardStage)
    {
        leaderboardStage.setTitle("Leaderboard");
         
        System.out.print ("Yah boi is here");
        
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(20,20,20,20));
        
        HBox hb = new HBox();
        hb.setPadding(new Insets(0,0,0,0));
        
        GridPane gPane = new GridPane();
        gPane.setPadding(new Insets(20,20,20,20));
        gPane.setHgap(80);
        gPane.setVgap(100);
        
        Button backBtn = new Button("Back");
        
        gPane.add(backBtn, 3, 5);
     
        bPane.setId("bPane");
        gPane.setId("root");
        backBtn.setId("Btn");
        
        bPane.setTop(hb);
        bPane.setCenter(gPane);
        Scene leaderboardScene = new Scene(bPane);
        leaderboardScene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        leaderboardStage.setScene(leaderboardScene);
        //leaderboardStage.titleProperty().bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));
        leaderboardStage.setResizable(false);
        leaderboardStage.show();
        
    }
}


   
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIpackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author seani
 */
public class gameScreenUI {

    public void gameScreenUI() throws Exception {
        Stage gameS = new Stage();
        start(gameS);
    }
    
    public void start(Stage gameStage)
    {
        System.out.print ("Yah boi is here");
        
        gameStage.setTitle("Game Screen");
        
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10,50,50,50));
        
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));
        
        GridPane gPane = new GridPane();
        gPane.setPadding(new Insets(20,20,20,20));
        gPane.setHgap(5);
        gPane.setVgap(5);
        
        Button backBtn = new Button("Go Back");
        
        gPane.add(backBtn, 0, 0);
     
        bPane.setId("bPane");
        gPane.setId("root");
        backBtn.setId("Btn");
        
        bPane.setTop(hb);
        bPane.setCenter(gPane);
        Scene scene = new Scene(bPane);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        gameStage.setScene(scene);
        //gameStage.titleProperty().bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));
        gameStage.setResizable(false);
        gameStage.show();
    }
    
}

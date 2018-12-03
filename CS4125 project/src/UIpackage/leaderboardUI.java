/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIpackage;

import Data_Layer.Client_socket;
import Objects.Player;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
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
        TableView<Player> table = new TableView<>();
        Scene scene = new Scene(new Group());
        leaderboardStage.setWidth(450);
        leaderboardStage.setHeight(550);
        leaderboardStage.setTitle("Leaderboard");                     
       
        
        TableColumn userNameCol = new TableColumn("Username");
        userNameCol.setMinWidth(100);
        userNameCol.setCellValueFactory(
                new PropertyValueFactory<>("username"));
        
        TableColumn eloCol = new TableColumn("Rating");
        eloCol.setMinWidth(100);
        eloCol.setCellValueFactory(
                new PropertyValueFactory<>("rating"));

        
        ObservableList<Player> data = getPlayerList();

        table.setItems(data);
        table.getColumns().addAll(userNameCol, eloCol);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        leaderboardStage.setScene(scene);
        leaderboardStage.show();
        
       /* BorderPane bPane = new BorderPane();
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
        leaderboardStage.setResizable(false);*/
        
        
        //leaderboardStage.show();
        
    } 
    private ObservableList<Player> getPlayerList() 
    {
        
        Client_socket proxy = new Client_socket();
        String matchMaker;
        matchMaker = proxy.sendInfo("getAll,matchmaker_info");
        ArrayList<Player> data = new ArrayList<>();
        
        String [] interim = matchMaker.split(",");
 
     for(int i = 0; i < interim.length - 5; i++)
        {  
            if(i % 5 == 0)
            {
                Player p = new Player();
                p.setUsername(interim[i+1]);
                p.setRating(Double.parseDouble(interim[i+2]));
                data.add(p);
            }
        }   
         
 
      ObservableList<Player> list = FXCollections.observableArrayList(data);
      return list;
    }
}


   
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


   
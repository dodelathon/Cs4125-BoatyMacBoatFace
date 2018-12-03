/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIpackage;

/**
 *
 * @author hilto
 */

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
import Objects.Match_Limit5;


public class LobbyList
{
     public LobbyList() throws Exception
    {
       Stage lobbies = new Stage();
       LobbyListStart (lobbies);
    }

    
    public void LobbyListStart(Stage lobbyStage)
    {
        TableView<Match_Limit5> table = new TableView<>();
        ObservableList<Match_Limit5> data = getPlayerList();
        Scene scene = new Scene(new Group());
        lobbyStage.setWidth(1200);
        lobbyStage.setHeight(550);
        lobbyStage.setTitle("Lobbies");                     
       
        
        TableColumn gid = new TableColumn("Game ID");
        gid.setMinWidth(100);
        gid.setCellValueFactory(new PropertyValueFactory<Match_Limit5, Integer>("GID"));
        
        TableColumn p1 = new TableColumn("Player 1 ID");
        p1.setMinWidth(100);
        p1.setCellValueFactory(new PropertyValueFactory<Match_Limit5, Integer>("p1"));
        
        TableColumn p1n = new TableColumn("Player 1");
        p1n.setMinWidth(100);
        p1n.setCellValueFactory(new PropertyValueFactory<Match_Limit5, String>("p1n"));
        
        TableColumn p2 = new TableColumn("Player 2 ID");
        p2.setMinWidth(100);
        p2.setCellValueFactory(new PropertyValueFactory<Match_Limit5, Integer>("p2"));
        
        TableColumn p2n = new TableColumn("Player 2");
        p2n.setMinWidth(100);
        p2n.setCellValueFactory(new PropertyValueFactory<Match_Limit5, String>("p2n"));
        
        TableColumn p3 = new TableColumn("Player 3 ID");
        p3.setMinWidth(100);
        p3.setCellValueFactory(new PropertyValueFactory<Match_Limit5, Integer>("p3"));
        
        TableColumn p3n = new TableColumn("Player 3");
        p3n.setMinWidth(100);
        p3n.setCellValueFactory(new PropertyValueFactory<Match_Limit5, String>("p3n"));
        
        TableColumn p4 = new TableColumn("Player 4 ID");
        p4.setMinWidth(100);
        p4.setCellValueFactory(new PropertyValueFactory<Match_Limit5, Integer>("p4"));
        
        TableColumn p4n = new TableColumn("Player 4");
        p4n.setMinWidth(100);
        p4n.setCellValueFactory(new PropertyValueFactory<Match_Limit5, String>("p4n"));
        
        TableColumn p5 = new TableColumn("Player 5 ID");
        p5.setMinWidth(100);
        p5.setCellValueFactory(new PropertyValueFactory<Match_Limit5, Integer>("p5"));
        
        TableColumn p5n = new TableColumn("Player 5");
        p5n.setMinWidth(100);
        p5n.setCellValueFactory(new PropertyValueFactory<Match_Limit5, String>("p5n"));


        table.setItems(data);
        table.getColumns().addAll(gid, p1, p1n, p2, p2n, p3, p3n, p4, p4n, p5, p5n);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        lobbyStage.setScene(scene);
        lobbyStage.show();
        
    } 
    
    private ObservableList<Match_Limit5> getPlayerList() 
    {
        
        Client_socket proxy = new Client_socket();
        String matchMaker;
        proxy.sendInfo("match");
        matchMaker = proxy.sendInfo("getall,matches");
        ArrayList<Match_Limit5> data = new ArrayList<>();
        
        String [] interim = matchMaker.split(",");
 
        for(int i = 0; i < interim.length - 11; i += 11)
        {  
            int gid = Integer.parseInt(interim[i]);
            int p1 = Integer.parseInt(interim[i + 1]);
            int p2 = Integer.parseInt(interim[i + 3]);
            int p3 = Integer.parseInt(interim[i + 5]);
            int p4 = Integer.parseInt(interim[i + 7]);
            int p5 = Integer.parseInt(interim[i + 9]);
            
            String p1n = interim[i + 2];
            String p2n = interim[i + 4];
            String p3n = interim[i + 6];
            String p4n = interim[i + 8];
            String p5n = interim[i + 10];
            data.add(new Match_Limit5(gid, p1, p2, p3, p4, p5, p1n, p2n, p3n, p4n, p5n));
            
        }   
         
 
      ObservableList<Match_Limit5> list = FXCollections.observableArrayList(data);
      return list;
    }
}


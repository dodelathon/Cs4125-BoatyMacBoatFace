package Application;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ApplicationMain extends Application
{
    public static void main (String [] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Login Screen");
        
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10,50,50,50));
        
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));
        
        GridPane gPane = new GridPane();
        gPane.setPadding(new Insets(20,20,20,20));
        gPane.setHgap(5);
        gPane.setVgap(5);
        
        Label userName = new Label("Username");
        final TextField userNameText = new TextField();
        Label password = new Label("Password");
        final PasswordField passF = new PasswordField();
        Button loginBtn = new Button("Login");
        final Label message = new Label();
        
        gPane.add(userName, 0, 0);
        gPane.add(userNameText, 1, 0);
        gPane.add(password, 0, 1);
        gPane.add(passF, 1, 1);
        gPane.add(loginBtn,2, 1);
        gPane.add(message,1 ,2);
        
        bPane.setTop(hb);
        bPane.setCenter(gPane);
        Scene scene = new Scene(bPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

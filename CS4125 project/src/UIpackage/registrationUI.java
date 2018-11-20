package UIpackage;
import Authentication.loginEncryption;
import Data_Layer.Client_socket;
import java.awt.event.ActionListener;
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
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.Event;
import javax.xml.transform.Source;

/**
 *
 * @author seani
 */
public class registrationUI implements UI {

    @Override
    public String getUname() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPassword(String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void registrationUI() {
        
    }
    public void register(Stage loginStage, Client_socket cS)
    {
        Stage registerStage = new Stage();
        start(registerStage, loginStage, cS);
    }
    public void start(Stage registerStage, Stage loginStage, Client_socket cS)
    {
        registerStage.setTitle("Regestration");
        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(10,50,50,50));
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));
        GridPane gPane = new GridPane();
        gPane.setPadding(new Insets(20,20,20,20));
        gPane.setHgap(5);
        gPane.setVgap(5);
        Label userName = new Label("Username :");
        final TextField userNameText = new TextField();
        Label password = new Label("Password :");
        final PasswordField passF = new PasswordField();
        Button RegistrationBtn = new Button("Register");
        
        RegistrationBtn.setOnAction(new EventHandler() {
            Client_socket cSo = cS;
            @Override
            public void handle(Event event) {
                String username = userNameText.getText();
                String password = loginEncryption.loginEncryption(passF.getText());
                String addUser = "adduser," + username + "," + password + "," + 0;
                System.out.println(addUser);
                System.out.print(cSo.sendInfo(addUser));
                registerStage.hide();
                loginStage.show();
            }

        });
        
        gPane.add(userName, 0, 0);
        gPane.add(userNameText, 0, 1);
        gPane.add(password, 1, 0);
        gPane.add(passF, 1, 1);
        gPane.add(RegistrationBtn, 1, 2);
        bPane.setTop(hb);
        bPane.setCenter(gPane);
        Scene scene = new Scene(bPane);
        registerStage.setScene(scene);
        registerStage.setResizable(false);
        registerStage.show();

    }
    


    
}

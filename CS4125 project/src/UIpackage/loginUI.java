package UIpackage;
import Authentication.loginEncryption;
import Data_Layer.Client_socket;
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
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.Event;

public class loginUI extends Application implements UI {
    String sampleUsername = "sDonnelly";
    String samplePassword = "309e509b879dccb653c53f432a2098ea2a31386f8f33080e516ad53939e120316648e88b9c368fdc477d4eccd22599ed5e2ebf2b87f7beac1d63d38c95eacb0e";
    String checkUname, checkPword;
    private final Client_socket cS = new Client_socket();
    public loginUI() 
    {
    }
    public void login()
    {
        launch();
    }
    
    @Override
    public void start(Stage loginStage)
    {
        loginStage.setTitle("Login Screen");
        
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
        Button RegistrationBtn = new Button("Register");
        
        gPane.add(userName, 0, 0);
        gPane.add(userNameText, 1, 0);
        gPane.add(password, 0, 1);
        gPane.add(passF, 1, 1);
        gPane.add(loginBtn,2, 1);
        gPane.add(RegistrationBtn,3, 1);

        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gPane.setEffect(r);
        
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        
        loginBtn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event)
            {
                String[] dataElements;
                checkUname = userNameText.getText();
                checkPword = passF.getText();
                String passed = "getuser" + "," + checkUname + "," + "login_info";
                String userData = cS.sendInfo(passed);
                if (!userData.equalsIgnoreCase("Invalid input"))
                {
                    dataElements = userData.split(",");
                    if (loginEncryption.loginEncryption(checkPword).equals(dataElements[2]))
                    {
                        applicationUI app = new applicationUI();
                        app.applicationUI(loginStage, dataElements);
                        System.out.println("logged in!!");
                                        loginStage.hide();

                    }
                }
                else
                    System.out.println("Login attempt failed!!");

            }
        });
        RegistrationBtn.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                registrationUI register = new registrationUI();
                loginStage.hide();
                register.register(loginStage, cS);
            }
            
        });
        
        
        bPane.setId("bPane");
        gPane.setId("root");
        loginBtn.setId("Btn");
        RegistrationBtn.setId("Btn");
        
        bPane.setTop(hb);
        bPane.setCenter(gPane);
        Scene scene = new Scene(bPane);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        loginStage.setScene(scene);
        //loginStage.titleProperty().bind(scene.widthProperty().asString().concat(" : ").concat(scene.heightProperty().asString()));
        loginStage.setResizable(false);
        loginStage.show();
        
    }   

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
}

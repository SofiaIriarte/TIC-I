package um.edu.tic1.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static um.edu.tic1.client.UserApplication.springContext;

@Component
@FxmlView("/um.edu.tic1.client/aboutUs.fxml")
public class AboutUs implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private Button home;
    @FXML private Button registrarse;
    @FXML private Button logIn;
    @FXML private Button shop;

    @FXML
    public void goToHome (ActionEvent event) throws IOException {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(Inicio.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToRegisterScene (ActionEvent event) throws IOException {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(RegistrarUsuario.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToLogIn (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(LogInUsuario.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToShop (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(ShopSinLogIn.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
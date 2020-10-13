package um.edu.tic1.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.UserApplication;
import um.edu.tic1.client.dtos.ClientDTO;
import um.edu.tic1.client.services.ClientService;
import java.net.URL;
import java.util.ResourceBundle;
import static um.edu.tic1.client.UserApplication.cliente;
import static um.edu.tic1.client.UserApplication.springContext;

@Component
@FxmlView("/um.edu.tic1.client/tempLogIn.fxml")
public class TempLogIn implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private Button logIn;
    @FXML private Button menu;
    @FXML private RadioButton admin;
    @FXML private RadioButton client;
    @FXML private RadioButton store;
    @FXML private RadioButton brand;
    @FXML private ToggleGroup toggleGroup;
    @FXML private TextField userName;
    @FXML private PasswordField password;
    @FXML private Label revisar;
    @FXML private Label mensaje;

    @FXML
    public void logIn (){
        ClientService clientServices = new ClientService();
        if (client.isSelected()){
            ClientDTO clienteCheck = clientServices.findById(userName.getText());
            if (clienteCheck != null && clienteCheck.getPassworld().equals(password.getText())) {
                mensaje.setText("Log in exitoso");
                UserApplication.cliente = clienteCheck;
            } else if (clienteCheck == null){
                mensaje.setText("Usuario no existe");
            }else if (clienteCheck != null && clienteCheck.getPassworld() != password.getText()) {
                mensaje.setText("Contraseña incorrecta");
            }
        }
    }

    @FXML
    public void goToMenu (ActionEvent event){
        if (cliente == null) {
            FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
            Parent root = fxWeaver.loadView(MainMenu.class);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }


}

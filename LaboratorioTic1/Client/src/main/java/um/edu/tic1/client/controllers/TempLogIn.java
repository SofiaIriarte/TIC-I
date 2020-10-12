package um.edu.tic1.client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import um.edu.tic1.client.dtos.ClientDTO;
import um.edu.tic1.client.services.ClientService;

import java.net.URL;
import java.util.ResourceBundle;

public class TempLogIn implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private Button logIn;
    @FXML private Button check;
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
            if (clienteCheck != null && clienteCheck.getPassworld() == password.getText()) {
                mensaje.setText("Log in exitoso");

            } else if (clienteCheck == null){
                mensaje.setText("Usuario no existe");
            }else if (clienteCheck != null && clienteCheck.getPassworld() != password.getText()) {
                mensaje.setText("Contraseña incorrecta");
            }
        }
    }

    @FXML
    public void checkUserIsLogIn (){

    }


}

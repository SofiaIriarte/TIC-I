package com.example.ticproject.app.client.controller;


import com.example.ticproject.app.server.entities.Client;
import com.example.ticproject.app.server.entitiesControllers.ClientController;
import com.example.ticproject.app.client.services.ClientServices;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/com.example.ticproject.app/sample.fxml")
public class Controller implements Initializable {

    @Autowired
    ClientController clientController;

    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField id;
    @FXML private DatePicker fechaNacimiento;
    @FXML private TextField address;
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private Button submit;
    @FXML private Button marca;
    @FXML private Button local;
    @FXML private Button back;
    @FXML private Button exit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void exitButton(MouseEvent mouseEvent) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void submitButton(){
        Client client = new Client(id.getText(),
                firstName.getText(),
                lastName.getText(),
                fechaNacimiento.getValue(),
                address.getText(),
                email.getText(),
                password.getText());
        ClientServices clientServices = new ClientServices();
        clientServices.save(client);
        System.out.println("funciono");
    }

}

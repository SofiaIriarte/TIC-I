package com.example.ticproject.app.controller;


import com.example.ticproject.app.entities.ClientController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    @FXML private TextField address;
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private Button submit;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void exitButton(javafx.scene.input.MouseEvent mouseEvent) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void submitButton(){
        clientController.createCustomer(id.getText(),
                firstName.getText(),
                lastName.getText(),
                address.getText(),
                email.getText(),
                password.getText());
        System.out.println("funciono");
    }

}

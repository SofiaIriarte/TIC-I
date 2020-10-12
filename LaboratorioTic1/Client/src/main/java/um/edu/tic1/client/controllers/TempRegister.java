package um.edu.tic1.client.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.dtos.ClientDTO;
import um.edu.tic1.client.dtos.ShoppingCartDTO;
import um.edu.tic1.client.services.ClientService;
import um.edu.tic1.client.services.ShoppingCartService;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/um.edu.tic1.client/tempRegister.fxml")
public class TempRegister implements Initializable {

    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField id;
    @FXML private DatePicker fechaNacimiento;
    @FXML private TextField address;
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private Button submit;
    @FXML private Label error;
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
    public void submitButton() {
        ClientService clientServices = new ClientService();
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        if (id.getText().isEmpty() || firstName.getText().isEmpty() || lastName.getText().isEmpty()
                || address.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()){
            error.setText("Falta Parametro Obligatorio");
        }
        ClientDTO clienteCheck = clientServices.findById(email.getText());
        if (clienteCheck != null) {
            error.setText("Ya existe un usuario con el User Name colocado");
        } else {
            ShoppingCartDTO cartUser = new ShoppingCartDTO(email.getText());
            shoppingCartService.save(cartUser);
            ClientDTO client = new ClientDTO(id.getText(), firstName.getText(), lastName.getText(),
                    fechaNacimiento.getValue(), address.getText(), email.getText(), password.getText(), cartUser);
            clientServices.save(client);
        }
    }
}

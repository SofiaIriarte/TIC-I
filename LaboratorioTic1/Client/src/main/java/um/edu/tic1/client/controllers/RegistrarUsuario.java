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
import um.edu.tic1.client.dtos.ClientDTO;
import um.edu.tic1.client.dtos.ShoppingCartDTO;
import um.edu.tic1.client.services.ClientService;
import um.edu.tic1.client.services.ShoppingCartService;

import java.net.URL;
import java.util.ResourceBundle;

import static um.edu.tic1.client.UserApplication.cliente;
import static um.edu.tic1.client.UserApplication.springContext;

@Component
@FxmlView("/um.edu.tic1.client/registrarUsuario.fxml")
public class RegistrarUsuario implements Initializable {

    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField id;
    @FXML private DatePicker fechaNacimiento;
    @FXML private TextField address;
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private Button submit;

    @FXML private Label error;

    @FXML private Button menu;
    @FXML private Button logIn;
    @FXML private Button aboutUs;
    @FXML private Button shop;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void submitButton(ActionEvent event) {
        ClientService clientServices = new ClientService();
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        if (id.getText().isEmpty() || firstName.getText().isEmpty() || lastName.getText().isEmpty()
                || address.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()){
            error.setText("Falta Parametro Obligatorio");
        } else {
            ClientDTO clienteCheck = clientServices.findById(email.getText());
            if (clienteCheck != null) {
                error.setText("Ya existe un usuario con el User Name colocado");
            } else {
                ShoppingCartDTO cartUser = new ShoppingCartDTO(email.getText());
                shoppingCartService.save(cartUser);
                ClientDTO client = new ClientDTO(id.getText(), firstName.getText(), lastName.getText(),
                        fechaNacimiento.getValue(), address.getText(), email.getText(), password.getText(), cartUser);
                clientServices.save(client);
                cliente = client;
                FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
                Parent root = fxWeaver.loadView(InicioUsuario.class);
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        }
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
    public void goToMenu (ActionEvent event){
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(Inicio.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToAboutUs (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(AboutUs.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}

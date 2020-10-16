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
import um.edu.tic1.client.dtos.AdministradorDTO;
import um.edu.tic1.client.dtos.BrandDTO;
import um.edu.tic1.client.dtos.ClientDTO;
import um.edu.tic1.client.dtos.StoreDTO;
import um.edu.tic1.client.services.AdministradorService;
import um.edu.tic1.client.services.BrandService;
import um.edu.tic1.client.services.ClientService;
import um.edu.tic1.client.services.StoreService;

import java.io.IOException;
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
    @FXML private Button registrarse;
    @FXML private Button aboutUs;
    @FXML private Button shop;

    @FXML private RadioButton admin;
    @FXML private RadioButton client;
    @FXML private RadioButton store;
    @FXML private RadioButton brand;
    @FXML private ToggleGroup toggleGroup;

    @FXML private TextField userName;

    @FXML private PasswordField password;

    @FXML private Label mensaje;

    @FXML
    public void logIn (ActionEvent event){
        ClientService clientServices = new ClientService();
        AdministradorService administradorService = new AdministradorService();
        BrandService brandService = new BrandService();
        StoreService storeService = new StoreService();
        if (client.isSelected()){
            ClientDTO clienteCheck = clientServices.findById(userName.getText());
            if (clienteCheck != null && clienteCheck.getPassworld().equals(password.getText())) {
                mensaje.setText("Log in exitoso");
                UserApplication.cliente = clienteCheck;
                FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
                Parent root = fxWeaver.loadView(MainMenuWithLogIn.class);
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else if (clienteCheck == null){
                mensaje.setText("Usuario no existe");
            }else if (clienteCheck != null && clienteCheck.getPassworld() != password.getText()) {
                mensaje.setText("Contraseña incorrecta");
            }
        } else if (admin.isSelected()){
            AdministradorDTO administradorDTO = administradorService.findById(userName.getText());
            if (administradorDTO != null && administradorDTO.getPassworld().equals(password.getText())) {
                mensaje.setText("Log in exitoso");
                UserApplication.admin = administradorDTO;
                FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
                Parent root = fxWeaver.loadView(AdminHome.class);
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else if (administradorDTO == null){
                mensaje.setText("Usuario no existe");
            }else if (administradorDTO != null && administradorDTO.getPassworld() != password.getText()) {
                mensaje.setText("Contraseña incorrecta");
            }
        } else if (brand.isSelected()){
            try {
                int idBrand = Integer.parseInt(userName.getText());
                BrandDTO brandDTO = brandService.findById(idBrand);
                if (brandDTO != null && brandDTO.getPassworld().equals(password.getText())) {
                    mensaje.setText("Log in exitoso");
                    UserApplication.brand = brandDTO;
                    FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
                    Parent root = fxWeaver.loadView(BrandHome.class);
                    Scene scene = new Scene(root);
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } else if (brandDTO == null){
                    mensaje.setText("Usuario no existe");
                }else if (brandDTO != null && brandDTO.getPassworld() != password.getText()) {
                    mensaje.setText("Contraseña incorrecta");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        } else if (store.isSelected()) {
            StoreDTO storeDTO = storeService.findById(userName.getText());
            if (storeDTO != null && storeDTO.getPassword().equals(password.getText())) {
                mensaje.setText("Log in exitoso");
                UserApplication.store = storeDTO;
                FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
                Parent root = fxWeaver.loadView(TiendaHome.class);
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else if (storeDTO == null){
                mensaje.setText("Usuario no existe");
            }else if (storeDTO != null && storeDTO.getPassword() != password.getText()) {
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

    @FXML
    public void goToRegisterScene (ActionEvent event) throws IOException {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(TempRegister.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
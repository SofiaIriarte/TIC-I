package um.edu.tic1.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.dtos.BrandDTO;
import um.edu.tic1.client.services.BrandService;

import java.net.URL;
import java.util.ResourceBundle;

import static um.edu.tic1.client.UserApplication.springContext;

@Component
@FxmlView("/um.edu.tic1.client/registrarMarca.fxml")
public class RegistrarMarca implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {    }

    @FXML private TextField id;
    @FXML private TextField userName;
    @FXML private PasswordField password;

    @FXML private Button submit;
    @FXML private Button home;

    @FXML
    public void submitButton() {
        BrandService storeService = new BrandService();
        try {
            if (id.getText().isEmpty() || userName.getText().isEmpty() || password.getText().isEmpty()){
                return;
            } else {
                int idBrand = Integer.parseInt(id.getText());
                BrandDTO brand = new BrandDTO(idBrand, userName.getText(), password.getText());
                storeService.save(brand);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
    }

    @FXML
    public void goToAdminHome (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(AdminInicio.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }



}

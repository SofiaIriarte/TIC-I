package um.edu.tic1.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/um.edu.tic1.client/tiendaHome.fxml")
public class TiendaHome implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private Button addProduct;
    @FXML private Button addStock;

    @FXML
    public void goToAddProduct (ActionEvent event) throws IOException {
//        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
//        Parent root = fxWeaver.loadView(RegistrarMarca.class);
//        Scene scene = new Scene(root);
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
    }

    @FXML
    public void goToAddStock (ActionEvent event) throws IOException {
//        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
//        Parent root = fxWeaver.loadView(RegistrarMarca.class);
//        Scene scene = new Scene(root);
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
    }

}

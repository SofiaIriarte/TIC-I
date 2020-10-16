package um.edu.tic1.client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.services.ProductService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import static um.edu.tic1.client.UserApplication.springContext;

@Component
@FxmlView("/um.edu.tic1.client/shop.fxml")
public class Shop implements Initializable {

    @Autowired
    ProductService productService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> marcas = productService.getDistinctBrand();
        ObservableList<String> obList = FXCollections.observableList(marcas);
        this.marca.setItems(obList);

        List<String> colores = productService.getDistinctColor();
        ObservableList<String> obList2 = FXCollections.observableList(colores);
        this.color.setItems(obList2);

        List<String> categorias = productService.getDistinctCathegory();
        ObservableList<String> obList3 = FXCollections.observableList(categorias);
        this.categoria.setItems(obList3);

        List<String> estaciones = productService.getDistinctEstacion();
        ObservableList<String> obList4 = FXCollections.observableList(estaciones);
        this.estacion.setItems(obList4);
    }

    @FXML private Button aboutUs;
    @FXML private Button buscar;
    @FXML private Button miPerfil;
    @FXML private Button cart;
    @FXML private Button home;

    @FXML private ComboBox<String> marca;
    @FXML private ComboBox<String> categoria;
    @FXML private ComboBox<String> color;
    @FXML private ComboBox<String> estacion;

    @FXML
    public void goToMyPerfil (ActionEvent event) {

    }

    @FXML
    public void goToCart (ActionEvent event) {

    }

    @FXML
    public void goToMenu (ActionEvent event){
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(MainMenuWithLogIn.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}

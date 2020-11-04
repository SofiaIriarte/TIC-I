package um.edu.tic1.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.UserApplication;
import um.edu.tic1.client.dtos.ProductDTO;
import um.edu.tic1.client.dtos.StockDTO;
import um.edu.tic1.client.services.ProductService;
import um.edu.tic1.client.services.StockService;

import java.net.URL;
import java.util.ResourceBundle;

import static um.edu.tic1.client.UserApplication.springContext;

@Component
@FxmlView("/um.edu.tic1.client/agregarProductoATienda.fxml")
public class AgregarProductoATienda implements Initializable {

    @Autowired
    StockService stockService;
    @Autowired
    ProductService productService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private TextField idProducto;
    @FXML private TextField cantidad;
    @FXML private TextField talle;
    @FXML private TextField color;

    @FXML private Button home;
    @FXML private Button agregarProducto;
    @FXML private Button contact;

    @FXML
    private void goToContactUs (ActionEvent event){
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(ContactUs.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToStoreHome (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(TiendaInicio.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void registerProduct (){
        Integer prod = Integer.parseInt(idProducto.getText());
        int store = UserApplication.store.getiD();
        int cant = Integer.parseInt(cantidad.getText());
        String id = idProducto.getText()+UserApplication.store.getUser()+talle.getText()+color.getText();
        String size = talle.getText();
        String colorPrenda = color.getText();
        ProductDTO productDTO = productService.findById("?productId=" + prod.toString());
        if (productDTO == null){
            return;
        } else {
            StockDTO temp = stockService.getStock(id);
            if (temp != null){
                temp.setQuantity(temp.getQuantity() + cant);
            } else {
                StockDTO stock = new StockDTO(id, prod, store, size, cant,colorPrenda);
                stockService.save(stock);
            }
        }
    }

}

package um.edu.tic1.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.dtos.CompraDTO;
import um.edu.tic1.client.services.CompraService;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import static um.edu.tic1.client.UserApplication.cliente;
import static um.edu.tic1.client.UserApplication.springContext;

@Component
@FxmlView("/um.edu.tic1.client/historialCompras.fxml")
public class HistorialCompras implements Initializable {

    @Autowired
    CompraService compraService;

    @FXML private Button aboutUs;
    @FXML private Button shop;
    @FXML private Button miPerfil;
    @FXML private Button home;
    @FXML private Button carrito;

    @FXML private Button goNextPage;
    @FXML private Button goPreviousPage;

    @FXML private Label nombre;
    @FXML private Label nombre2; @FXML private Label nombre3;
    @FXML private Label nombre4; @FXML private Label nombre5;
    @FXML private Label nombre6; @FXML private Label nombre7;

    @FXML private Label tiendaTalle;
    @FXML private Label tiendaTalle2; @FXML private Label tiendaTalle3;
    @FXML private Label tiendaTalle4; @FXML private Label tiendaTalle5;
    @FXML private Label tiendaTalle6; @FXML private Label tiendaTalle7;

    @FXML private Label date;
    @FXML private Label date2; @FXML private Label date3;
    @FXML private Label date4; @FXML private Label date5;
    @FXML private Label date6; @FXML private Label date7;

    @FXML private Label metPago;
    @FXML private Label metPago2; @FXML private Label metPago3;
    @FXML private Label metPago4; @FXML private Label metPago5;
    @FXML private Label metPago6; @FXML private Label metPago7;

    @FXML private Label precio;
    @FXML private Label precio2; @FXML private Label precio3;
    @FXML private Label precio4; @FXML private Label precio5;
    @FXML private Label precio6; @FXML private Label precio7;

    @FXML private Label cantidad;
    @FXML private Label cantidad2; @FXML private Label cantidad3;
    @FXML private Label cantidad4; @FXML private Label cantidad5;
    @FXML private Label cantidad6; @FXML private Label cantidad7;

    @FXML private Label mensjaeEmptyHistorial;
    @FXML private ImageView fotoEmptyHistorial;
    @FXML private Label column1,column2,column3,column4,column5,column6;

    private List<CompraDTO> compras;
    private int page = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        compras = compraService.getboughtItems(cliente.getUserName());
        if (compras.size() > 0){
            this.showProducts();

        }
        this.emptyScreen();
    }

    private void emptyScreen (){
        if (compras.size() == 0){
            mensjaeEmptyHistorial.setVisible(true);
            fotoEmptyHistorial.setVisible(true);
            column1.setVisible(false);
            column2.setVisible(false);
            column3.setVisible(false);
            column4.setVisible(false);
            column5.setVisible(false);
            column6.setVisible(false);
        } else {
            mensjaeEmptyHistorial.setVisible(false);
            fotoEmptyHistorial.setVisible(false);
        }
    }

    @FXML
    public void goToMyPerfil (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(MiPerfil.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToShop (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(Shop.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToAboutUs (ActionEvent event){

    }

    @FXML
    public void goToMenu (ActionEvent event){
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioUsuario.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToCart (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(MiCarrito.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void showProducts () {
        this.clear();
        int i = page*7;
        int productInCart = 0;
        while (compras.get(i) != null && i<(page*7+7) ){
            CompraDTO item = compras.get(i);
            String name = item.getProductId();
            String metodoPago = item.getMetodoDePago();
            LocalDate localDate = item.getDate();
            String price = item.getPrice();
            Integer cant = item.getQuantity();
            String storeAndTalle = item.getTiendaTalle();
            if(productInCart==0){
                nombre.setText(name);
                precio.setText(price);
                metPago.setText(metodoPago);
                cantidad.setText(cant.toString());
                tiendaTalle.setText(storeAndTalle);
                date.setText(localDate.toString());
            } else if (productInCart==1){
                nombre2.setText(name);
                precio2.setText(price);
                metPago2.setText(metodoPago);
                cantidad2.setText(cant.toString());
                tiendaTalle2.setText(storeAndTalle);
                date2.setText(localDate.toString());
            } else if (productInCart==2){
                nombre3.setText(name);
                precio3.setText(price);
                metPago3.setText(metodoPago);
                cantidad3.setText(cant.toString());
                tiendaTalle3.setText(storeAndTalle);
                date3.setText(localDate.toString());
            } else if (productInCart==3){
                nombre4.setText(name);
                precio4.setText(price);
                metPago4.setText(metodoPago);
                cantidad4.setText(cant.toString());
                tiendaTalle4.setText(storeAndTalle);
                date4.setText(localDate.toString());
            } else if (productInCart==4){
                nombre5.setText(name);
                precio5.setText(price);
                metPago5.setText(metodoPago);
                cantidad5.setText(cant.toString());
                tiendaTalle5.setText(storeAndTalle);
                date5.setText(localDate.toString());
            } else if (productInCart==5){
                nombre6.setText(name);
                precio6.setText(price);
                metPago6.setText(metodoPago);
                cantidad6.setText(cant.toString());
                tiendaTalle6.setText(storeAndTalle);
                date6.setText(localDate.toString());
            } else if (productInCart==6){
                nombre7.setText(name);
                precio7.setText(price);
                metPago7.setText(metodoPago);
                cantidad7.setText(cant.toString());
                tiendaTalle7.setText(storeAndTalle);
                date7.setText(localDate.toString());
            }
            productInCart++;
            i++;
            if (i == compras.size()){
                break;
            }
        }
        if (page*7 + 7 > compras.size()){
            goNextPage.setVisible(false);
            goNextPage.setDisable(true);
        } else {
            goNextPage.setVisible(true);
            goNextPage.setDisable(false);
        }
        if (page == 0){
            goPreviousPage.setVisible(false);
            goPreviousPage.setDisable(true);
        } else {
            goPreviousPage.setVisible(true);
            goPreviousPage.setDisable(false);
        }
    }

    private void clear (){
        this.goNextPage.setVisible(false);
        this.goPreviousPage.setVisible(false);
        this.goNextPage.setDisable(true);
        this.goPreviousPage.setDisable(true);
        this.nombre.setText("");
        this.nombre2.setText("");
        this.nombre3.setText("");
        this.nombre4.setText("");
        this.nombre5.setText("");
        this.nombre6.setText("");
        this.nombre7.setText("");
        this.cantidad.setText("");
        this.cantidad2.setText("");
        this.cantidad3.setText("");
        this.cantidad4.setText("");
        this.cantidad5.setText("");
        this.cantidad6.setText("");
        this.cantidad7.setText("");
        this.tiendaTalle.setText("");
        this.tiendaTalle2.setText("");
        this.tiendaTalle3.setText("");
        this.tiendaTalle4.setText("");
        this.tiendaTalle5.setText("");
        this.tiendaTalle6.setText("");
        this.tiendaTalle7.setText("");
        this.precio.setText("");
        this.precio2.setText("");
        this.precio3.setText("");
        this.precio4.setText("");
        this.precio5.setText("");
        this.precio6.setText("");
        this.precio7.setText("");
        this.metPago.setText("");
        this.metPago2.setText("");
        this.metPago3.setText("");
        this.metPago4.setText("");
        this.metPago5.setText("");
        this.metPago6.setText("");
        this.metPago7.setText("");
        this.date.setText("");
        this.date2.setText("");
        this.date3.setText("");
        this.date4.setText("");
        this.date5.setText("");
        this.date6.setText("");
        this.date7.setText("");
    }

    @FXML
    public void goToPreviousPage () throws IOException {
        this.clear();
        page--;
        this.showProducts();
    }

    @FXML
    public void goToNextPage () throws IOException {
        this.clear();
        page++;
        this.showProducts();
    }

}

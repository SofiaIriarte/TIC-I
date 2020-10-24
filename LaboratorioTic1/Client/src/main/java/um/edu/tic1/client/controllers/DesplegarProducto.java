package um.edu.tic1.client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.dtos.CarritoDTO;
import um.edu.tic1.client.dtos.StockDTO;
import um.edu.tic1.client.dtos.StoreDTO;
import um.edu.tic1.client.services.ShoppingCartService;
import um.edu.tic1.client.services.StockService;
import um.edu.tic1.client.services.StoreService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static um.edu.tic1.client.UserApplication.*;

@Component
@FxmlView("/um.edu.tic1.client/desplegarProducto.fxml")
public class DesplegarProducto implements Initializable {

    @Autowired
    StockService stockService;

    @Autowired
    StoreService storeService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @FXML private Label nombre;
    @FXML private Label descripcion;
    @FXML private Label marca;
    @FXML private Label precio;

    @FXML private ImageView imagenProducto;

    @FXML private ComboBox<String> entrega;
    @FXML private ComboBox<String> tiendaTalle;
    @FXML private ComboBox<String> cantidad;

    @FXML private Button addToCart;
    @FXML private Button back;
    @FXML private Button home;
    @FXML private Button miPerfil;
    @FXML private Button shop;
    @FXML private Button aboutUs;

    @FXML private Label errorMessage;

    private List<StockDTO> stocks = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        errorMessage.setVisible(false);

        this.nombre.setText(productDTO.getName());

        List<String> entregasTipos = new ArrayList<>();
        entregasTipos.add("Pick up");
        entregasTipos.add("Deleviry");
        ObservableList<String> obList = FXCollections.observableList(entregasTipos);
        this.entrega.setItems(obList);

        this.cantidad.getItems().add("1");
        this.cantidad.getItems().add("2");
        this.cantidad.getItems().add("3");
        this.cantidad.getItems().add("4");

        stocks = stockService.getStocks(productDTO.getiD());
        if (stocks.size() > 0){
            for (int i =0; i < stocks.size(); i++){
                StockDTO temp = stocks.get(i);
                String toAdd = "";
                StoreDTO storeDTO = storeService.findByNum(temp.getStoreId());
                toAdd = storeDTO.getUser() + "-" + temp.getTalle();
                this.tiendaTalle.getItems().add(toAdd);
            }
        }

        try {
            byte[] byteArray = productDTO.getImage();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
            BufferedImage bufferedImage = null;
            bufferedImage = ImageIO.read(byteArrayInputStream);
            Image imagen = SwingFXUtils.toFXImage(bufferedImage, null);
            this.imagenProducto.setImage(imagen);
            this.descripcion.setText(productDTO.getDescription());
            Long price = productDTO.getPrice();
            this.precio.setText("$ " +price.toString());
            this.marca.setText(productDTO.getMarca());
        } catch (IOException e) {
            e.printStackTrace();
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
    public void goToCart (ActionEvent event) {

    }

    private void goShopScene (ActionEvent event){
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(Shop.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goBack (ActionEvent event) {
        productDTO = null;
        volver = true;
        this.goShopScene(event);
    }

    @FXML
    public void agregarAlCarrito (ActionEvent event){
        String entrega = this.entrega.getValue();
        String tiendaYTalle = this.tiendaTalle.getValue();
        int cant = Integer.parseInt(this.cantidad.getValue());
        if (entrega != null && tiendaYTalle != null && cant > 0) {
            Integer id = productDTO.getiD();
            String identificador = id.toString() + cliente.getUserName();
            CarritoDTO existeItem = shoppingCartService.getCarrito(identificador);
            if (existeItem != null) {
                existeItem.setQuantity(existeItem.getQuantity()+cant);
                shoppingCartService.saveCarrito(existeItem);
                this.goShopScene(event);
            } else {
                String[] temp = tiendaYTalle.split("-");
                String idStock = id.toString() + temp[0] + temp[1];
                CarritoDTO carritoDTO = new CarritoDTO(identificador, cant, id, productDTO.getName(),
                        cliente.getUserName(), tiendaYTalle, idStock, this.precio.getText());
                shoppingCartService.saveCarrito(carritoDTO);
                this.goShopScene(event);
            }
        } else {
            errorMessage.setVisible(true);
        }
    }

}
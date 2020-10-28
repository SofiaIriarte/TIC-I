package um.edu.tic1.client.controllers;


import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static um.edu.tic1.client.UserApplication.*;

@Component
@FxmlView("/um.edu.tic1.client/comparacionProductos.fxml")
public class ComparacionProductos implements Initializable {

    @FXML private Button aboutUs;
    @FXML private Button shop;
    @FXML private Button miPerfil;
    @FXML private Button home;
    @FXML private Button carrito;
    @FXML private Button back;
    @FXML private Button login;
    @FXML private Button register;

    @FXML private Label nombre;
    @FXML private Label descripcion;
    @FXML private Label marca;
    @FXML private Label estacion;
    @FXML private Label precio;
    @FXML private ImageView imagenProducto;

    @FXML private Label nombre2;
    @FXML private Label descripcion2;
    @FXML private Label marca2;
    @FXML private Label estacion2;
    @FXML private Label precio2;
    @FXML private ImageView imagenProducto2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (cliente == null){
            miPerfil.setVisible(false);
            miPerfil.setDisable(true);
            carrito.setDisable(true);
            carrito.setVisible(false);
        } else {
            login.setVisible(false);
            login.setDisable(true);
            register.setVisible(false);
            register.setDisable(true);
        }

        nombre.setText(productDTOtoCompare1.getName());
        descripcion.setText(productDTOtoCompare1.getDescription());
        marca.setText(productDTOtoCompare1.getMarca());
        estacion.setText(productDTOtoCompare1.getEstacion());
        Long precioProducto1 = productDTOtoCompare1.getPrice();
        precio.setText(precioProducto1.toString());
        try {
            byte[] byteArray = productDTOtoCompare1.getImage();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            Image imagen = SwingFXUtils.toFXImage(bufferedImage, null);
            imagenProducto.setImage(imagen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        nombre2.setText(productDTOtoCompare2.getName());
        descripcion2.setText(productDTOtoCompare2.getDescription());
        marca2.setText(productDTOtoCompare2.getMarca());
        estacion2.setText(productDTOtoCompare2.getEstacion());
        Long precioProducto2 = productDTOtoCompare2.getPrice();
        precio2.setText(precioProducto2.toString());
        try {
            byte[] byteArray = productDTOtoCompare2.getImage();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            Image imagen = SwingFXUtils.toFXImage(bufferedImage, null);
            imagenProducto2.setImage(imagen);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void goToRegisterScene (ActionEvent event) throws IOException {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(RegistrarUsuario.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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
    public void goToMyPerfil (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(MiPerfil.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToAboutUs (ActionEvent event){

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

    private void goShopScene (ActionEvent event){
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(Shop.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void goShopSceneWithNoLogIn (ActionEvent event){
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(ShopSinLogIn.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goBack (ActionEvent event) {
        productDTOtoCompare1 = null;
        productDTOtoCompare2 = null;
        volver = true;
        if (cliente != null) {
            this.goShopScene(event);
        } else {
            this.goShopSceneWithNoLogIn(event);
        }
    }

}

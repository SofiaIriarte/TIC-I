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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.dtos.ProductDTO;
import um.edu.tic1.client.services.ProductService;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static um.edu.tic1.client.UserApplication.springContext;

@Component
@FxmlView("/um.edu.tic1.client/shopSinLogIn.fxml")
public class ShopSinLogIn implements Initializable {

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

        addToCart.setVisible(false);
    }

    @FXML private Button aboutUs;
    @FXML private Button buscar;
    @FXML private Button registrarse;
    @FXML private Button logIn;
    @FXML private Button home;

    @FXML private GridPane grid;

    @FXML private ImageView productImage;
    @FXML private Label nombreProducto;
    @FXML private Button addToCart;

    @FXML private ImageView productImage2;
    @FXML private Label nombreProducto2;
    @FXML private Button addToCart2;

    @FXML private ImageView productImage3;
    @FXML private Label nombreProducto3;
    @FXML private Button addToCart3;

    @FXML private ImageView productImage4;
    @FXML private Label nombreProducto4;
    @FXML private Button addToCart4;

    @FXML private ComboBox<String> marca;
    @FXML private ComboBox<String> categoria;
    @FXML private ComboBox<String> color;
    @FXML private ComboBox<String> estacion;

    @FXML Button derecha;
    @FXML Button izquierda;

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
    public void goToMenu (ActionEvent event){
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(Inicio.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void search (ActionEvent event) throws IOException {
        String cat = this.categoria.getValue();
        String brand = this.marca.getValue();
        String col = this.color.getValue();
        String esta = this.estacion.getValue();
        List<ProductDTO> resultados = productService.getProductosFiltrados(cat,brand,col,esta);
        nombreProducto.setText(resultados.get(0).getName());
        byte[] byteArray = resultados.get(0).getImage();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
        Image imagen = SwingFXUtils.toFXImage(bufferedImage, null);;
        productImage.setImage(imagen);
        addToCart.setVisible(true);
    }

}

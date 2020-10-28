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

import static um.edu.tic1.client.UserApplication.*;

@Component
@FxmlView("/um.edu.tic1.client/shop.fxml")
public class Shop implements Initializable {

    @Autowired
    ProductService productService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        compareMensaje.setVisible(false);

        List<String> marcas = productService.getDistinctBrand();
        ObservableList<String> obList = FXCollections.observableList(marcas);
        this.marca.setItems(obList);
        this.marca.getItems().add(null);

        List<String> categorias = productService.getDistinctCathegory();
        ObservableList<String> obList3 = FXCollections.observableList(categorias);
        this.categoria.setItems(obList3);
        this.categoria.getItems().add(null);

        List<String> estaciones = productService.getDistinctEstacion();
        ObservableList<String> obList4 = FXCollections.observableList(estaciones);
        this.estacion.setItems(obList4);
        this.estacion.getItems().add(null);

        if (volver == true){
            try {
                this.page = 0;
                this.search();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            addToCart.setVisible(false);
            addToCart.setDisable(true);
            addToCart2.setVisible(false);
            addToCart2.setDisable(true);
            addToCart3.setVisible(false);
            addToCart3.setDisable(true);
            addToCart4.setVisible(false);
            addToCart4.setDisable(true);
            addToCart5.setVisible(false);
            addToCart5.setDisable(true);
            addToCart6.setVisible(false);
            addToCart6.setDisable(true);
            addToCompare1.setVisible(false);
            addToCompare1.setDisable(true);
            addToCompare2.setVisible(false);
            addToCompare2.setDisable(true);
            addToCompare3.setVisible(false);
            addToCompare3.setDisable(true);
            addToCompare4.setVisible(false);
            addToCompare4.setDisable(true);
            addToCompare5.setVisible(false);
            addToCompare5.setDisable(true);
            addToCompare6.setVisible(false);
            addToCompare6.setDisable(true);
            nextPage.setVisible(false);
            previousPage.setVisible(false);
            nextPage.setDisable(true);
            previousPage.setDisable(true);
        }

    }

    @FXML private Button aboutUs;
    @FXML private Button buscar;
    @FXML private Button cart;
    @FXML private Button perfil;
    @FXML private Button home;

    @FXML private Button compare, addToCompare1, addToCompare2, addToCompare3, addToCompare4, addToCompare5, addToCompare6;
    @FXML private Label compareMensaje;

    @FXML private GridPane grid;

    @FXML private ImageView productImage;
    @FXML private Label nombreProducto;
    @FXML private Label precioProducto;
    @FXML private Button addToCart;

    @FXML private ImageView productImage2;
    @FXML private Label nombreProducto2;
    @FXML private Label precioProducto2;
    @FXML private Button addToCart2;

    @FXML private ImageView productImage3;
    @FXML private Label nombreProducto3;
    @FXML private Label precioProducto3;
    @FXML private Button addToCart3;

    @FXML private ImageView productImage4;
    @FXML private Label nombreProducto4;
    @FXML private Label precioProducto4;
    @FXML private Button addToCart4;

    @FXML private ImageView productImage5;
    @FXML private Label nombreProducto5;
    @FXML private Label precioProducto5;
    @FXML private Button addToCart5;

    @FXML private ImageView productImage6;
    @FXML private Label nombreProducto6;
    @FXML private Label precioProducto6;
    @FXML private Button addToCart6;

    @FXML private ComboBox<String> marca;
    @FXML private ComboBox<String> categoria;
    @FXML private ComboBox<String> estacion;

    @FXML private Button nextPage;
    @FXML private Button previousPage;

    private int amountPerPage = 6;
    private int page = 0;
    private List<ProductDTO> search;

    @FXML
    public void goToMyPerfil (ActionEvent event) throws IOException {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(MiPerfil.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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

    @FXML
    public void goToMenu (ActionEvent event){
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioUsuario.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private String makeUrl (){
        String cathegory = this.categoria.getValue();
        String brand = this.marca.getValue();
        String esta = this.estacion.getValue();
        String url = "";
        if (cathegory != null) {
            url += "cathegrory=" + cathegory + "&";
        } if (brand != null) {
            url += "marca=" + brand + "&";
        } if (esta != null) {
            url += "estacion=" + esta;
        }
        return url;
    }

    @FXML
    public void search () throws IOException {
        if (volver == true){
            search = productService.getProductosFiltrados(busqueda);
            this.showProducts();
            volver = false;
            busqueda = null;
        } else {
            String url = this.makeUrl();
            search = productService.getProductosFiltrados(url);
            if (search.size() > 0) {
                this.showProducts();
                busqueda = url;
            }
        }
    }

    private void showProducts () throws IOException {
        this.clear();
        int i = page*6;
        int postProdut = 0;
        while (search.get(i) != null && i<(page*6+6) ){
            ProductDTO productToShow = search.get(i);
            String name = productToShow.getName();
            Long price = productToShow.getPrice();
            byte[] byteArray = productToShow.getImage();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            Image imagen = SwingFXUtils.toFXImage(bufferedImage, null);
            if(postProdut==0){
                nombreProducto.setText(name);
                precioProducto.setText("$ " +price.toString());
                productImage.setImage(imagen);
                addToCart.setVisible(true);
                addToCart.setDisable(false);
                addToCompare1.setVisible(true);
                addToCompare1.setDisable(false);
            } else if (postProdut==1){
                nombreProducto2.setText(name);
                precioProducto2.setText("$ " +price.toString());
                productImage2.setImage(imagen);
                addToCart2.setVisible(true);
                addToCart2.setDisable(false);
                addToCompare2.setVisible(true);
                addToCompare2.setDisable(false);
            } else if (postProdut==2){
                nombreProducto3.setText(name);
                precioProducto3.setText("$ " +price.toString());
                productImage3.setImage(imagen);
                addToCart3.setVisible(true);
                addToCart3.setDisable(false);
                addToCompare3.setVisible(true);
                addToCompare3.setDisable(false);
            } else if (postProdut==3){
                nombreProducto4.setText(name);
                precioProducto4.setText("$ " +price.toString());
                productImage4.setImage(imagen);
                addToCart4.setVisible(true);
                addToCart4.setDisable(false);
                addToCompare4.setVisible(true);
                addToCompare4.setDisable(false);
            } else if (postProdut==4){
                nombreProducto5.setText(name);
                precioProducto5.setText("$ " +price.toString());
                productImage5.setImage(imagen);
                addToCart5.setVisible(true);
                addToCart5.setDisable(false);
                addToCompare5.setVisible(true);
                addToCompare5.setDisable(false);
            } else if (postProdut==5){
                nombreProducto6.setText(name);
                precioProducto6.setText("$ " +price.toString());
                productImage6.setImage(imagen);
                addToCart6.setVisible(true);
                addToCart6.setDisable(false);
                addToCompare6.setVisible(true);
                addToCompare6.setDisable(false);
            }
            postProdut++;
            i++;
            if (i == search.size()){
                break;
            }
        }
        if (page*6 + 6 > search.size()){
            nextPage.setVisible(false);
            nextPage.setDisable(true);
        } else {
            nextPage.setVisible(true);
            nextPage.setDisable(false);
        }
        if (page == 0){
            previousPage.setVisible(false);
            previousPage.setDisable(true);
        } else {
            previousPage.setVisible(true);
            previousPage.setDisable(false);
        }

    }

    private void clear (){
        productImage.setImage(null);
        nombreProducto.setText("");
        precioProducto.setText("");
        addToCart.setVisible(false);
        addToCompare1.setVisible(false);

        productImage2.setImage(null);
        nombreProducto2.setText("");
        precioProducto2.setText("");
        addToCart2.setVisible(false);
        addToCompare2.setVisible(false);

        productImage3.setImage(null);
        nombreProducto3.setText("");
        precioProducto3.setText("");
        addToCart3.setVisible(false);
        addToCompare3.setVisible(false);

        productImage4.setImage(null);
        nombreProducto4.setText("");
        precioProducto4.setText("");
        addToCart4.setVisible(false);
        addToCompare4.setVisible(false);

        productImage5.setImage(null);
        nombreProducto5.setText("");
        precioProducto5.setText("");
        addToCart5.setVisible(false);
        addToCompare5.setVisible(false);

        productImage6.setImage(null);
        nombreProducto6.setText("");
        precioProducto6.setText("");
        addToCart6.setVisible(false);
        addToCompare6.setVisible(false);
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

    private ProductDTO selectProduct (String nameProduct){
        ProductDTO productDTO = null;
        for (int i = 0; i<search.size(); i++){
             ProductDTO temp = search.get(i);
            if (temp.getName().equals(nameProduct)){
                productDTO = temp;
                break;
            }
        }
        return productDTO;
    }

    private void goToMoreInformatio (ActionEvent event){
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(DesplegarProducto.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void showProduct1 (ActionEvent event){
        productDTO = this.selectProduct(this.nombreProducto.getText());
        this.goToMoreInformatio(event);
    }

    @FXML
    public void showProduct2 (ActionEvent event){
        productDTO = this.selectProduct(this.nombreProducto2.getText());
        this.goToMoreInformatio(event);
    }

    @FXML
    public void showProduct3 (ActionEvent event){
        productDTO = this.selectProduct(this.nombreProducto3.getText());
        this.goToMoreInformatio(event);
    }

    @FXML
    public void showProduct4 (ActionEvent event){
        productDTO = this.selectProduct(this.nombreProducto4.getText());
        this.goToMoreInformatio(event);
    }

    @FXML
    public void showProduct5 (ActionEvent event){
        productDTO = this.selectProduct(this.nombreProducto5.getText());
        this.goToMoreInformatio(event);
    }

    @FXML
    public void showProduct6 (ActionEvent event){
        productDTO = this.selectProduct(this.nombreProducto6.getText());
        this.goToMoreInformatio(event);
    }

    @FXML
    public void add (ActionEvent event){
        if (productDTOtoCompare1 == null) {
            productDTOtoCompare1 = this.selectProduct(this.nombreProducto.getText());
            compareMensaje.setText("Seleccione otro producto para comparar");
            compareMensaje.setVisible(true);
        } else if (productDTOtoCompare2 == null) {
            productDTOtoCompare2 = this.selectProduct(this.nombreProducto.getText());
            compareMensaje.setText("Pulse comparar");
            compareMensaje.setVisible(true);
        }
    }

    @FXML
    public void add2 (ActionEvent event){
        if (productDTOtoCompare1 == null) {
            productDTOtoCompare1 = this.selectProduct(this.nombreProducto2.getText());
            compareMensaje.setText("Seleccione otro producto para comparar");
            compareMensaje.setVisible(true);
        } else if (productDTOtoCompare2 == null) {
            productDTOtoCompare2 = this.selectProduct(this.nombreProducto2.getText());
            compareMensaje.setText("Pulse comparar");
            compareMensaje.setVisible(true);
        }
    }

    @FXML
    public void add3 (ActionEvent event){
        if (productDTOtoCompare1 == null) {
            productDTOtoCompare1 = this.selectProduct(this.nombreProducto3.getText());
            compareMensaje.setText("Seleccione otro producto para comparar");
            compareMensaje.setVisible(true);
        } else if (productDTOtoCompare2 == null) {
            productDTOtoCompare2 = this.selectProduct(this.nombreProducto3.getText());
            compareMensaje.setText("Pulse comparar");
            compareMensaje.setVisible(true);
        }
    }

    @FXML
    public void add4 (ActionEvent event){
        if (productDTOtoCompare1 == null) {
            productDTOtoCompare1 = this.selectProduct(this.nombreProducto4.getText());
            compareMensaje.setText("Seleccione otro producto para comparar");
            compareMensaje.setVisible(true);
        } else if (productDTOtoCompare2 == null) {
            productDTOtoCompare2 = this.selectProduct(this.nombreProducto4.getText());
            compareMensaje.setText("Pulse comparar");
            compareMensaje.setVisible(true);
        }
    }

    @FXML
    public void add5 (ActionEvent event){
        if (productDTOtoCompare1 == null) {
            productDTOtoCompare1 = this.selectProduct(this.nombreProducto5.getText());
            compareMensaje.setText("Seleccione otro producto para comparar");
            compareMensaje.setVisible(true);
        } else if (productDTOtoCompare2 == null) {
            productDTOtoCompare2 = this.selectProduct(this.nombreProducto5.getText());
            compareMensaje.setText("Pulse comparar");
            compareMensaje.setVisible(true);
        }
    }

    @FXML
    public void add6 (ActionEvent event){
        if (productDTOtoCompare1 == null) {
            productDTOtoCompare1 = this.selectProduct(this.nombreProducto6.getText());
            compareMensaje.setText("Seleccione otro producto para comparar");
            compareMensaje.setVisible(true);
        } else if (productDTOtoCompare2 == null) {
            productDTOtoCompare2 = this.selectProduct(this.nombreProducto6.getText());
            compareMensaje.setText("Pulse comparar");
            compareMensaje.setVisible(true);
        }
    }

    @FXML
    public void compareProducts(ActionEvent event){
        if (productDTOtoCompare1 != null && productDTOtoCompare2 != null) {
            FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
            Parent root = fxWeaver.loadView(ComparacionProductos.class);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            compareMensaje.setText("");
            compareMensaje.setText("No selecciono dos productos para comparar");
            compareMensaje.setVisible(true);
        }
    }

}
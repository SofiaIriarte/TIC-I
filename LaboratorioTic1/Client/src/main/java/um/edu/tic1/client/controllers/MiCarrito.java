package um.edu.tic1.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.dtos.CarritoDTO;
import um.edu.tic1.client.dtos.CompraDTO;
import um.edu.tic1.client.dtos.MetodoDePagoDTO;
import um.edu.tic1.client.dtos.StockDTO;
import um.edu.tic1.client.services.CompraService;
import um.edu.tic1.client.services.MetodoDePagoService;
import um.edu.tic1.client.services.ShoppingCartService;
import um.edu.tic1.client.services.StockService;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import static um.edu.tic1.client.UserApplication.cliente;
import static um.edu.tic1.client.UserApplication.springContext;

@Component
@FxmlView("/um.edu.tic1.client/miCarrito.fxml")
public class MiCarrito implements Initializable {

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    MetodoDePagoService metodoDePagoService;

    @Autowired
    CompraService compraService;

    @Autowired
    StockService stockService;

    @FXML private Button aboutUs;
    @FXML private Button shop;
    @FXML private Button miPerfil;
    @FXML private Button home;
    @FXML private Button comprar;

    @FXML private Button goNextPage;
    @FXML private Button goPreviousPage;

    @FXML private Button deleteProduct;
    @FXML private Button deleteProduct2;
    @FXML private Button deleteProduct3;
    @FXML private Button deleteProduct4;
    @FXML private Button deleteProduct5;
    @FXML private Button deleteProduct6;
    @FXML private Button deleteProduct7;

    @FXML private Label nombre;
    @FXML private Label nombre2; @FXML private Label nombre3;
    @FXML private Label nombre4; @FXML private Label nombre5;
    @FXML private Label nombre6; @FXML private Label nombre7;

    @FXML private Label precio;
    @FXML private Label precio2; @FXML private Label precio3;
    @FXML private Label precio4; @FXML private Label precio5;
    @FXML private Label precio6; @FXML private Label precio7;

    @FXML private Label cantidad;
    @FXML private Label cantidad2; @FXML private Label cantidad3;
    @FXML private Label cantidad4; @FXML private Label cantidad5;
    @FXML private Label cantidad6; @FXML private Label cantidad7;

    @FXML private Label tiendaTalle;
    @FXML private Label tiendaTalle2; @FXML private Label tiendaTalle3;
    @FXML private Label tiendaTalle4; @FXML private Label tiendaTalle5;
    @FXML private Label tiendaTalle6; @FXML private Label tiendaTalle7;

    @FXML private ComboBox<String> metodosDePago;

    @FXML private Label precioTotal;
    @FXML private Label error;

    @FXML private ImageView emptyCart;
    @FXML private Label messageEmptyCart;
    @FXML private Label column1, column2, column3, column4;

    private List<CarritoDTO> search;
    private List<MetodoDePagoDTO> metodoDePagoDTOS;
    private int page = 0;
    private int amountPerPage = 7;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        search = shoppingCartService.getCartItems(cliente.getUserName());
        if (search.size() > 0) {
            this.showProducts();
        } else {
            this.clear();
        }
        this.showEmptyThings();
        metodoDePagoDTOS = metodoDePagoService.getMetodosPorUsuario(cliente.getUserName());
        if (metodoDePagoDTOS.size() > 0){
            for (int i = 0; i < metodoDePagoDTOS.size(); i++){
                MetodoDePagoDTO temp = metodoDePagoDTOS.get(i);
                Integer num = temp.getnTarjeta();
                metodosDePago.getItems().add(num.toString());
            }
        }
        Integer precioTotal = this.calcularTotal();
        this.precioTotal.setText("$ " + precioTotal.toString());
    }

    private void showEmptyThings (){
        if (search.size() == 0){
            this.emptyCart.setVisible(true);
            this.messageEmptyCart.setVisible(true);
            column1.setVisible(false);
            column2.setVisible(false);
            column3.setVisible(false);
            column4.setVisible(false);
        } else {
            this.emptyCart.setVisible(false);
            this.messageEmptyCart.setVisible(false);
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

    private void clear (){
        this.goNextPage.setVisible(false);
        this.goPreviousPage.setVisible(false);
        this.goNextPage.setDisable(true);
        this.goPreviousPage.setDisable(true);
        this.deleteProduct.setVisible(false);
        this.deleteProduct.setDisable(true);
        this.deleteProduct2.setVisible(false);
        this.deleteProduct2.setDisable(true);
        this.deleteProduct3.setVisible(false);
        this.deleteProduct3.setDisable(true);
        this.deleteProduct4.setVisible(false);
        this.deleteProduct4.setDisable(true);
        this.deleteProduct5.setVisible(false);
        this.deleteProduct5.setDisable(true);
        this.deleteProduct6.setVisible(false);
        this.deleteProduct6.setDisable(true);
        this.deleteProduct7.setVisible(false);
        this.deleteProduct7.setDisable(true);
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
    }

    private void showProducts () {
        this.clear();
        int i = page*7;
        int productInCart = 0;
        while (search.get(i) != null && i<(page*7+7) ){
            CarritoDTO item = search.get(i);
            String name = item.getName();
            String price = item.getPrice();
            Integer cant = item.getQuantity();
            String storeAndTalle = item.getStoreAndTalle();
            if(productInCart==0){
                nombre.setText(name);
                precio.setText(price);
                cantidad.setText(cant.toString());
                tiendaTalle.setText(storeAndTalle);
                deleteProduct.setVisible(true);
                deleteProduct.setDisable(false);
            } else if (productInCart==1){
                nombre2.setText(name);
                precio2.setText(price);
                cantidad2.setText(cant.toString());
                tiendaTalle2.setText(storeAndTalle);
                deleteProduct2.setVisible(true);
                deleteProduct2.setDisable(false);
            } else if (productInCart==2){
                nombre3.setText(name);
                precio3.setText(price);
                cantidad3.setText(cant.toString());
                tiendaTalle3.setText(storeAndTalle);
                deleteProduct3.setVisible(true);
                deleteProduct3.setDisable(false);
            } else if (productInCart==3){
                nombre4.setText(name);
                precio4.setText(price);
                cantidad4.setText(cant.toString());
                tiendaTalle4.setText(storeAndTalle);
                deleteProduct4.setVisible(true);
                deleteProduct4.setDisable(false);
            } else if (productInCart==4){
                nombre5.setText(name);
                precio5.setText(price);
                cantidad5.setText(cant.toString());
                tiendaTalle5.setText(storeAndTalle);
                deleteProduct5.setVisible(true);
                deleteProduct5.setDisable(false);
            } else if (productInCart==5){
                nombre6.setText(name);
                precio6.setText(price);
                cantidad6.setText(cant.toString());
                tiendaTalle6.setText(storeAndTalle);
                deleteProduct6.setVisible(true);
                deleteProduct6.setDisable(false);
            } else if (productInCart==6){
                nombre7.setText(name);
                precio7.setText(price);
                cantidad7.setText(cant.toString());
                tiendaTalle7.setText(storeAndTalle);
                deleteProduct7.setVisible(true);
                deleteProduct7.setDisable(false);
            }
            productInCart++;
            i++;
            if (i == search.size()){
                break;
            }
        }
        if (page*7 + 7 > search.size()){
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

    private int calcularTotal (){
        int total = 0;
        for (int i = 0; i < search.size(); i++){
            CarritoDTO temp = search.get(i);
            int price = Integer.parseInt(temp.getPrice().substring(2,temp.getPrice().length()));
            total += price;
        }
        return total;
    }

    private CarritoDTO findProductToDelete (String name){
        CarritoDTO toDelete = null;
        for (int i = 0; i < search.size(); i++){
            CarritoDTO temp = search.get(i);
            if (temp.getName().equals(name)){
                search.remove(i);
                toDelete = temp;
                break;
            }
        }
        return toDelete;
    }

    @FXML
    public void deleteProductFromCart (){
        CarritoDTO temp = findProductToDelete(this.nombre.getText());
        shoppingCartService.deleteItem(temp.getId());
        if (search.size() > 0) {
            this.showProducts();
        } else {
            this.clear();
            this.showEmptyThings();
        }
    }

    @FXML
    public void deleteProductFromCart2 (){
        CarritoDTO temp = findProductToDelete(this.nombre2.getText());
        shoppingCartService.deleteItem(temp.getId());
        if (search.size() > 0) {
            this.showProducts();
        } else {
            this.clear();
            this.showEmptyThings();
        }
    }

    @FXML
    public void deleteProductFromCart3 (){
        CarritoDTO temp = findProductToDelete(this.nombre3.getText());
        shoppingCartService.deleteItem(temp.getId());
        if (search.size() > 0) {
            this.showProducts();
        } else {
            this.clear();
            this.showEmptyThings();
        }
    }

    @FXML
    public void deleteProductFromCart4 (){
        CarritoDTO temp = findProductToDelete(this.nombre4.getText());
        shoppingCartService.deleteItem(temp.getId());
        if (search.size() > 0) {
            this.showProducts();
        } else {
            this.clear();
            this.showEmptyThings();
        }
    }

    @FXML
    public void deleteProductFromCart5 (){
        CarritoDTO temp = findProductToDelete(this.nombre5.getText());
        shoppingCartService.deleteItem(temp.getId());
        if (search.size() > 0) {
            this.showProducts();
        } else {
            this.clear();
            this.showEmptyThings();
        }
    }

    @FXML
    public void deleteProductFromCart6 (){
        CarritoDTO temp = findProductToDelete(this.nombre6.getText());
        shoppingCartService.deleteItem(temp.getId());
        if (search.size() > 0) {
            this.showProducts();
        } else {
            this.clear();
            this.showEmptyThings();
        }
    }

    @FXML
    public void deleteProductFromCart7 (){
        CarritoDTO temp = findProductToDelete(this.nombre7.getText());
        shoppingCartService.deleteItem(temp.getId());
        if (search.size() > 0) {
            this.showProducts();
        } else {
            this.clear();
            this.showEmptyThings();
        }
    }

    @FXML
    public void comprar (ActionEvent event){
        error.setText("");
        if (search.size() > 0){
            String metodo = metodosDePago.getValue();
            if (metodo != null){
                for (int i = 0; i < search.size(); i++){
                    CarritoDTO temp = search.get(i);
                    StockDTO toCompare = stockService.getStock(temp.getIdStock());
                    if (toCompare.getQuantity() - temp.getQuantity() < 0){
                        error.setText("No hay suficiente stock");
                        return;
                    }
                }
                for (int i = 0; i < search.size(); i++){
                    CarritoDTO temp = search.get(i);
                    String tienda = temp.getStoreAndTalle();
                    String[] store = tienda.split("-");
                    tienda = store[0];
                    StockDTO toCompare = stockService.getStock(temp.getIdStock());
                    int nuevaCantidad = toCompare.getQuantity() - temp.getQuantity();
                    toCompare.setQuantity(nuevaCantidad);
                    stockService.save(toCompare);
                    CompraDTO newCompra = new CompraDTO(temp.getId(),temp.getName(),temp.getUserId(),
                            temp.getStoreAndTalle(),temp.getQuantity(),temp.getPrice(),
                            LocalDate.now(),metodo,temp.getType(),"Comprado",tienda);
                    compraService.save(newCompra);
                    shoppingCartService.deleteItem(temp.getId());
                    search.remove(i);
                }
                this.clear();
                this.precioTotal.setText("");
            } else {
                error.setText("Falta metodo de pago");
            }
        } else {
            error.setText("No hay items en el carrito");
        }
    }

}

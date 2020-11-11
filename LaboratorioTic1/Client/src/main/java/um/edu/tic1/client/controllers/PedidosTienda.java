package um.edu.tic1.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.dtos.CompraDTO;
import um.edu.tic1.client.dtos.ProductDTO;
import um.edu.tic1.client.dtos.StockDTO;
import um.edu.tic1.client.services.CompraService;
import um.edu.tic1.client.services.ProductService;
import um.edu.tic1.client.services.StockService;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import static um.edu.tic1.client.UserApplication.springContext;
import static um.edu.tic1.client.UserApplication.store;

@Component
@FxmlView("/um.edu.tic1.client/pedidosTienda.fxml")
public class PedidosTienda implements Initializable {

    @Autowired
    CompraService compraService;
    @Autowired
    ProductService productService;
    @Autowired
    StockService stockService;

    @FXML private Button home;
    @FXML private Button goNextPage;
    @FXML private Button goPreviousPage;

    @FXML private Label nombre,nombre2,nombre3,nombre4,nombre5,nombre6,nombre7;
    @FXML private Label tiendaTalle,tiendaTalle2,tiendaTalle3,tiendaTalle4,tiendaTalle5,tiendaTalle6,tiendaTalle7;
    @FXML private Label user,user2,user3,user4,user5,user6,user7;
    @FXML private Label date,date2,date3,date4,date5,date6,date7;
    @FXML private Label cantidad,cantidad2,cantidad3,cantidad4,cantidad5,cantidad6,cantidad7;
    @FXML private Label precio,precio2,precio3,precio4,precio5,precio6,precio7;
    @FXML private Label column1,column2,column3,column4,column5,column6,column7;
    @FXML private Label estado, estado2, estado3, estado4, estado5, estado6, estado7;
    @FXML private Label titulo;

    @FXML private Button confirmar, confirmar2, confirmar3, confirmar4, confirmar5, confirmar6, confirmar7;
    @FXML private Button rechazar, rechazar2, rechazar3, rechazar4, rechazar5, rechazar6, rechazar7;
    @FXML private Button contact;

    private List<CompraDTO> compras;
    private List<CompraDTO> devolucion;
    private int page = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (TiendaInicio.analizarDev == false) {
            compras = compraService.getPedidos(store.getUser());
            titulo.setText("Mis Pedidos");
            if (compras.size() > 0) {
                this.showProducts();
                this.sacarBotones();
            } else {
                this.emptyScreen();
                this.sacarBotones();
            }
        } else {
            compras = compraService.getPedidos(store.getUser());
            titulo.setText("Devoluciones");
            this.sacarBotones();
            if (compras.size() > 0) {
                for (int i = 0; i<compras.size(); i++){
                    CompraDTO temp = compras.get(i);
                    if (temp.getEstado().equals("Devolucion solicitada")){
                        devolucion.add(temp);
                    }
                }
                compras = devolucion;
                if (compras != null) {
                    if (compras.size() > 0) {
                        this.showProducts();
                    } else {
                        this.emptyScreen();
                    }
                }
                else {
                    this.emptyScreen();
                }
            } else {
                this.emptyScreen();
            }
        }
    }

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
    public void goToMenu (ActionEvent event){
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(TiendaInicio.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void emptyScreen (){
        if (compras!= null) {
            if (compras.size() == 0) {
                column1.setVisible(false);
                column2.setVisible(false);
                column3.setVisible(false);
                column4.setVisible(false);
                column5.setVisible(false);
                column6.setVisible(false);
                column7.setVisible(false);
            }
        }
    }

    private void sacarBotones (){
        confirmar.setVisible(false);
        confirmar.setDisable(true);
        rechazar.setDisable(true);
        rechazar.setVisible(false);
        confirmar2.setVisible(false);
        confirmar2.setDisable(true);
        rechazar2.setDisable(true);
        rechazar2.setVisible(false);
        confirmar3.setVisible(false);
        confirmar3.setDisable(true);
        rechazar3.setDisable(true);
        rechazar3.setVisible(false);
        confirmar4.setVisible(false);
        confirmar4.setDisable(true);
        rechazar4.setDisable(true);
        rechazar4.setVisible(false);
        confirmar5.setVisible(false);
        confirmar5.setDisable(true);
        rechazar5.setDisable(true);
        rechazar5.setVisible(false);
        confirmar6.setVisible(false);
        confirmar6.setDisable(true);
        rechazar6.setDisable(true);
        rechazar6.setVisible(false);
        confirmar7.setVisible(false);
        confirmar7.setDisable(true);
        rechazar7.setDisable(true);
        rechazar7.setVisible(false);
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
        this.user.setText("");
        this.user2.setText("");
        this.user3.setText("");
        this.user4.setText("");
        this.user5.setText("");
        this.user6.setText("");
        this.user7.setText("");
        this.date.setText("");
        this.date2.setText("");
        this.date3.setText("");
        this.date4.setText("");
        this.date5.setText("");
        this.date6.setText("");
        this.date7.setText("");
        this.estado.setText("");
        this.estado2.setText("");
        this.estado3.setText("");
        this.estado4.setText("");
        this.estado5.setText("");
        this.estado6.setText("");
        this.estado7.setText("");
    }

    private void showProducts () {
        this.clear();
        int i = page*7;
        int productInCart = 0;
        while (compras.get(i) != null && i<(page*7+7) ){
            CompraDTO item = compras.get(i);
            String name = item.getProductId();
            String userName = item.getUserId();
            LocalDate localDate = item.getDate();
            String price = item.getPrice();
            Integer cant = item.getQuantity();
            String storeAndTalle = item.getTiendaTalle();
            if(productInCart==0){
                nombre.setText(name);
                precio.setText(price);
                user.setText(userName);
                cantidad.setText(cant.toString());
                tiendaTalle.setText(storeAndTalle);
                date.setText(localDate.toString());
                estado.setText(item.getType());
                if (TiendaInicio.analizarDev) {
                    confirmar.setVisible(true);
                    confirmar.setDisable(false);
                    rechazar.setDisable(false);
                    rechazar.setVisible(true);
                }
            } else if (productInCart==1){
                nombre2.setText(name);
                precio2.setText(price);
                user2.setText(userName);
                cantidad2.setText(cant.toString());
                tiendaTalle2.setText(storeAndTalle);
                date2.setText(localDate.toString());
                estado2.setText(item.getType());
                if (TiendaInicio.analizarDev) {
                    confirmar2.setVisible(true);
                    confirmar2.setDisable(false);
                    rechazar2.setDisable(false);
                    rechazar2.setVisible(true);
                }
            } else if (productInCart==2){
                nombre3.setText(name);
                precio3.setText(price);
                user3.setText(userName);
                cantidad3.setText(cant.toString());
                tiendaTalle3.setText(storeAndTalle);
                date3.setText(localDate.toString());
                estado3.setText(item.getType());
                if (TiendaInicio.analizarDev) {
                    confirmar3.setVisible(true);
                    confirmar3.setDisable(false);
                    rechazar3.setDisable(false);
                    rechazar3.setVisible(true);
                }
            } else if (productInCart==3){
                nombre4.setText(name);
                precio4.setText(price);
                user4.setText(userName);
                cantidad4.setText(cant.toString());
                tiendaTalle4.setText(storeAndTalle);
                date4.setText(localDate.toString());
                estado4.setText(item.getType());
                if (TiendaInicio.analizarDev) {
                    confirmar4.setVisible(true);
                    confirmar4.setDisable(false);
                    rechazar4.setDisable(false);
                    rechazar4.setVisible(true);
                }
            } else if (productInCart==4){
                nombre5.setText(name);
                precio5.setText(price);
                user5.setText(userName);
                cantidad5.setText(cant.toString());
                tiendaTalle5.setText(storeAndTalle);
                date5.setText(localDate.toString());
                estado5.setText(item.getType());
                if (TiendaInicio.analizarDev) {
                    confirmar5.setVisible(true);
                    confirmar5.setDisable(false);
                    rechazar5.setDisable(false);
                    rechazar5.setVisible(true);
                }
            } else if (productInCart==5){
                nombre6.setText(name);
                precio6.setText(price);
                user6.setText(userName);
                cantidad6.setText(cant.toString());
                tiendaTalle6.setText(storeAndTalle);
                date6.setText(localDate.toString());
                estado6.setText(item.getType());
                if (TiendaInicio.analizarDev) {
                    confirmar6.setVisible(true);
                    confirmar6.setDisable(false);
                    rechazar6.setDisable(false);
                    rechazar6.setVisible(true);
                }
            } else if (productInCart==6){
                nombre7.setText(name);
                precio7.setText(price);
                user7.setText(userName);
                cantidad7.setText(cant.toString());
                tiendaTalle7.setText(storeAndTalle);
                date7.setText(localDate.toString());
                estado7.setText(item.getType());
                if (TiendaInicio.analizarDev) {
                    confirmar7.setVisible(true);
                    confirmar7.setDisable(false);
                    rechazar7.setDisable(false);
                    rechazar7.setVisible(true);
                }
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

    public CompraDTO productoSeleccionado (String name){
        CompraDTO toReturn = null;
        for (int i = 0; i<compras.size(); i++){
            CompraDTO temp = compras.get(i);
            if (temp.getProductId().equals(name)){
                toReturn = temp;
                break;
            }
        }
        return toReturn;
    }

    @FXML
    public void aceptar () {
        CompraDTO modificada = productoSeleccionado(nombre.getText());
        modificada.setEstado("Dev. Aceptada");
        int cantidad = modificada.getQuantity();
        String tiendaTalleColor = modificada.getTiendaTalle();
        String name = modificada.getProductId();
        this.sumarStock(name,tiendaTalleColor,cantidad);
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void denegar () {
        CompraDTO modificada = productoSeleccionado(nombre.getText());
        modificada.setEstado("Dev. Rechazada");
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void aceptar2 () {
        CompraDTO modificada = productoSeleccionado(nombre2.getText());
        modificada.setEstado("Dev. Aceptada");
        int cantidad = modificada.getQuantity();
        String tiendaTalleColor = modificada.getTiendaTalle();
        String name = modificada.getProductId();
        this.sumarStock(name,tiendaTalleColor,cantidad);
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void denegar2 () {
        CompraDTO modificada = productoSeleccionado(nombre2.getText());
        modificada.setEstado("Dev. Rechazada");
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void aceptar3 () {
        CompraDTO modificada = productoSeleccionado(nombre3.getText());
        modificada.setEstado("Dev. Aceptada");
        int cantidad = modificada.getQuantity();
        String tiendaTalleColor = modificada.getTiendaTalle();
        String name = modificada.getProductId();
        this.sumarStock(name,tiendaTalleColor,cantidad);
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void denegar3 () {
        CompraDTO modificada = productoSeleccionado(nombre3.getText());
        modificada.setEstado("Dev. Rechazada");
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void aceptar4 () {
        CompraDTO modificada = productoSeleccionado(nombre4.getText());
        modificada.setEstado("Dev. Aceptada");
        int cantidad = modificada.getQuantity();
        String tiendaTalleColor = modificada.getTiendaTalle();
        String name = modificada.getProductId();
        this.sumarStock(name,tiendaTalleColor,cantidad);
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void denegar4 () {
        CompraDTO modificada = productoSeleccionado(nombre4.getText());
        modificada.setEstado("Dev. Rechazada");
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void aceptar5 () {
        CompraDTO modificada = productoSeleccionado(nombre5.getText());
        modificada.setEstado("Dev. Aceptada");
        int cantidad = modificada.getQuantity();
        String tiendaTalleColor = modificada.getTiendaTalle();
        String name = modificada.getProductId();
        this.sumarStock(name,tiendaTalleColor,cantidad);
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void denegar5 () {
        CompraDTO modificada = productoSeleccionado(nombre5.getText());
        modificada.setEstado("Dev. Rechazada");
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void aceptar6 () {
        CompraDTO modificada = productoSeleccionado(nombre6.getText());
        modificada.setEstado("Dev. Aceptada");
        int cantidad = modificada.getQuantity();
        String tiendaTalleColor = modificada.getTiendaTalle();
        String name = modificada.getProductId();
        this.sumarStock(name,tiendaTalleColor,cantidad);
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void denegar6 () {
        CompraDTO modificada = productoSeleccionado(nombre6.getText());
        modificada.setEstado("Dev. Rechazada");
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void aceptar7 () {
        CompraDTO modificada = productoSeleccionado(nombre7.getText());
        modificada.setEstado("Dev. Aceptada");
        int cantidad = modificada.getQuantity();
        String tiendaTalleColor = modificada.getTiendaTalle();
        String name = modificada.getProductId();
        this.sumarStock(name,tiendaTalleColor,cantidad);
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    @FXML
    public void denegar7 () {
        CompraDTO modificada = productoSeleccionado(nombre7.getText());
        modificada.setEstado("Dev. Rechazada");
        compraService.save(modificada);
        compras.remove(modificada);
        this.clear();
        if (compras.size() > 0) {
            this.sacarBotones();
            this.showProducts();
        } else {
            this.sacarBotones();
        }
    }

    private void sumarStock (String name, String tiendaTalleColor, int cantidad){
        String url = "productName=" + name;
        ProductDTO temp = productService.findByName(url);
        Integer idProduct = temp.getiD();
        String[] storeSizeColor = tiendaTalleColor.split("-");
        String idStock = idProduct.toString()+storeSizeColor[0]+storeSizeColor[1]+storeSizeColor[2];
        StockDTO toAdd = stockService.getStock(idStock);
        toAdd.setQuantity(toAdd.getQuantity()+cantidad);
        stockService.save(toAdd);
    }

}

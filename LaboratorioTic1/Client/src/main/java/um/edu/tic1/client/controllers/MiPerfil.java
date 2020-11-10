package um.edu.tic1.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.dtos.MetodoDePagoDTO;
import um.edu.tic1.client.services.MetodoDePagoService;
import java.net.URL;
import java.util.ResourceBundle;
import static um.edu.tic1.client.UserApplication.cliente;
import static um.edu.tic1.client.UserApplication.springContext;

@Component
@FxmlView("/um.edu.tic1.client/miPerfil.fxml")
public class MiPerfil implements Initializable {

    @Autowired
    MetodoDePagoService metodoDePagoService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.nombreUsuario.setText(cliente.getFirstName());
        this.confirmar.setDisable(true);
        this.confirmar.setVisible(false);
        this.titular.setVisible(false);
        this.nTarjeta.setVisible(false);
        this.cancelar.setVisible(false);
        this.cancelar.setDisable(true);
    }

    @FXML private Text nombreUsuario;

    @FXML private Button agregarMetodo;
    @FXML private Button verHistorial;

    @FXML private Button home;
    @FXML private Button aboutUs;
    @FXML private Button shop;
    @FXML private Button cart;

    @FXML private TextField nTarjeta;
    @FXML private TextField titular;
    @FXML private Button confirmar;

    @FXML private Button cancelar;

    @FXML private Button logOut;

    @FXML
    private void cerrarCesion (ActionEvent event){
        cliente = null;
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(Inicio.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToAboutUs (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(AboutUsWithLogIn.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void cancelarAgregarMetodo (){
        this.confirmar.setDisable(true);
        this.confirmar.setVisible(false);
        this.titular.setVisible(false);
        this.nTarjeta.setVisible(false);
        this.cancelar.setVisible(false);
        this.cancelar.setDisable(true);
    }

    @FXML
    public void agregarMetodoPago (){
        this.confirmar.setDisable(false);
        this.confirmar.setVisible(true);
        this.titular.setVisible(true);
        this.nTarjeta.setVisible(true);
        this.cancelar.setVisible(true);
        this.cancelar.setDisable(false);
    }

    @FXML
    public void confirmarMetodo (){
        int numTarjeta = Integer.parseInt(nTarjeta.getText());
        String titular = this.titular.getText();
        String userName = cliente.getUserName();
        MetodoDePagoDTO metodoDePagoDTO = new MetodoDePagoDTO(numTarjeta,titular,userName);
        metodoDePagoService.save(metodoDePagoDTO);
        this.confirmar.setDisable(true);
        this.confirmar.setVisible(false);
        this.cancelar.setDisable(true);
        this.cancelar.setVisible(false);
        this.titular.setVisible(false);
        this.nTarjeta.setVisible(false);
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
    public void goToHome (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(InicioUsuario.class);
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
    public void goToHistorial (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(HistorialCompras.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}

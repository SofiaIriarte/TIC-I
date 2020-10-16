package um.edu.tic1.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;
import um.edu.tic1.client.dtos.ProductDTO;
import um.edu.tic1.client.services.ProductService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ResourceBundle;
import static um.edu.tic1.client.UserApplication.brand;
import static um.edu.tic1.client.UserApplication.springContext;

@Component
@FxmlView("/um.edu.tic1.client/productRegister.fxml")
public class ProductRegister implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {    }

    @FXML private TextField id;
    @FXML private TextField price;
    @FXML private TextField name;
    @FXML private TextField color;
    @FXML private TextField cathegory;
    @FXML private TextField description;
    @FXML private TextField estacion;

    @FXML private Button submit;
    @FXML private Button elegirFoto;

    @FXML private AnchorPane anchorPaneProduct;

    private File file = null;
    private byte[] fileContet;
    private Byte[] image;

    @FXML
    public void submitButton(ActionEvent event) {
        ProductService productService = new ProductService();
        if (file != null) {
            try {
                if (id.getText().isEmpty() || price.getText().isEmpty() || name.getText().isEmpty()
                        || color.getText().isEmpty() || cathegory.getText().isEmpty() || description.getText().isEmpty()
                        || estacion.getText().isEmpty()) {
                    return;
                } else {
                    int idProduct = Integer.parseInt(id.getText());
                    long precio = Long.parseLong(price.getText());
                    ProductDTO productDTO = new ProductDTO(idProduct,precio,description.getText(),name.getText(),
                            cathegory.getText(),brand.getName(),color.getText(),estacion.getText());
                    productDTO.setImage(image);
                    productService.save(productDTO);
                    this.goToBrandHome(event);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }
    }

    @FXML
    public void goToBrandHome (ActionEvent event) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(BrandHome.class);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void choosePicture (ActionEvent event) throws IOException, SQLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Imagen del producto");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        Stage stage = (Stage)anchorPaneProduct.getScene().getWindow();
        this.file = fileChooser.showOpenDialog(stage);
        Path path = Paths.get(file.getAbsolutePath());
        fileContet = Files.readAllBytes(path);
        image = new Byte[fileContet.length];
        for (int i=0; i<fileContet.length; i++){
            image[i] = Byte.valueOf(fileContet[i]);
        }
    }

}


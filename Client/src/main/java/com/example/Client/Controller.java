package com.example.JavaFXexample;

//import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;


import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/com.example.JavaFXexample/sample.fxml")
public class Controller implements Initializable {
//        @FXML private JFXTextField firstNameId;
//        @FXML private JFXTextField lastNameId;
    @FXML private ComboBox<String> boxGender;

    ObservableList<String> boxGenderContent = FXCollections.observableArrayList("Male","Female","Other");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boxGender.setItems(boxGenderContent);
    }

    public void exitButton(javafx.scene.input.MouseEvent mouseEvent) {
        Platform.exit();
        System.exit(0);
    }


}

package com.example.ticproject.app;
import com.example.ticproject.app.controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ApplicationExample extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        applicationContext = new SpringApplicationBuilder().sources(ApplicationExample.class).run(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("/Users/usuario/Desktop/app/src/main/resources/com.example.ticproject.app/sample.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
//        try {
//            DriverManager.getConnection("jdbc:derby:BDAgendaContactos;shutdown=true");
//        } catch (SQLException ex) {
//        }
    }
}

package um.edu.tic1.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import um.edu.tic1.client.controllers.Inicio;
import um.edu.tic1.client.dtos.*;

public class
UserApplication extends Application {

    public static ConfigurableApplicationContext springContext;
    private Parent root;
    public static ClientDTO cliente = null;
    public static AdministradorDTO admin = null;
    public static StoreDTO store = null;
    public static BrandDTO brand = null;
    public static String busqueda = null;
    public static Boolean volver = false;

    public static ProductDTO productDTO = null;
    public static ProductDTO productDTOtoCompare1 = null;
    public static ProductDTO productDTOtoCompare2 = null;

    @Override
    public void init() throws Exception {

        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.springContext = new SpringApplicationBuilder()
                .sources(ClientApplication.class)
                .run(args);

    }

    @Override
    public void start(Stage stage) {
        FxWeaver fxWeaver = springContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(Inicio.class);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        springContext.close();
        Platform.exit();
    }

}
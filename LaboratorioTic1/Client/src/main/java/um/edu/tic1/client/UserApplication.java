package um.edu.tic1.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import um.edu.tic1.client.controllers.MainMenu;
import um.edu.tic1.client.dtos.AdministradorDTO;
import um.edu.tic1.client.dtos.BrandDTO;
import um.edu.tic1.client.dtos.ClientDTO;
import um.edu.tic1.client.dtos.StoreDTO;

public class UserApplication extends Application {

    public static ConfigurableApplicationContext springContext;
    private Parent root;
    public static ClientDTO cliente = null;
    public static AdministradorDTO admin = null;
    public static StoreDTO store = null;
    public static BrandDTO brand = null;

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
        Parent root = fxWeaver.loadView(MainMenu.class);
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

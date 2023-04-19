package lk.ijse.orm.gdse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent load= FXMLLoader.load(getClass().getResource("/lk/ijse/orm/gdse/view/MainPage.fxml"));
        primaryStage.setScene(new Scene(load));
        primaryStage.show();
    }
}

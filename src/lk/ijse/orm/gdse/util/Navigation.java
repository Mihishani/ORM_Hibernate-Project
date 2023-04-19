package lk.ijse.orm.gdse.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    private static AnchorPane pane;
    public static void navigate(Route route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {

            case MAINPAGE:
                window.setTitle("MAINPAGE");
                initUI("MainPage.fxml");
                break;

            case USERLOGIN:
                window.setTitle("USERLOGIN");
                initUI("UserLogin.fxml");
                break;

            case DASHBOARD:
                window.setTitle("DASGBOARD");
                initUI("DashBoard.fxml");
                break;

            case USERFORM:
                window.setTitle("USERFORM");
                initUI("UserForm.fxml");
                break;

            case STUDENTFORM:
                window.setTitle("STUDENTFORM");
                initUI("StudentForm.fxml");
                break;

            case ROOMFORM:
                window.setTitle("ROOMFORM");
                initUI("RoomForm.fxml");
                break;


            case RESERVATION:
                window.setTitle("RESERVATION");
                initUI("ReservationForm.fxml");
                break;

            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/orm/gdse/view/" + location)));
    }
}

package lk.ijse.orm.gdse.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.gdse.util.Navigation;
import lk.ijse.orm.gdse.util.Route;

import java.io.IOException;

public class DashBoardController {
    public AnchorPane pane1;
    public AnchorPane pane2;
    public Button btnUser;
    public Button btnStudent;
    public Button btnroom;
    public Button btnReservation;
    public Button btnBack;
    public AnchorPane pane3;

    public void BtnUserOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.USERFORM,pane3);
    }

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.STUDENTFORM,pane3);
    }

    public void btnRoomOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.ROOMFORM,pane3);
    }

    public void btnReservationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.RESERVATION,pane3);
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.MAINPAGE,pane1);
    }
}

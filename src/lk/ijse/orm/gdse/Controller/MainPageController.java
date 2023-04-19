package lk.ijse.orm.gdse.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.gdse.util.Navigation;
import lk.ijse.orm.gdse.util.Route;

import java.io.IOException;

public class MainPageController {
    public AnchorPane anchorpane1;
    public Button btnLogin;

    public void btnloginOnaction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.USERLOGIN,anchorpane1);
    }
}

package lk.ijse.orm.gdse.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.gdse.util.Navigation;
import lk.ijse.orm.gdse.util.Route;

import java.io.IOException;

public class UserLoginController {
    public TextField txtUserName;
    public PasswordField txtPassword;
    public Button btnLogin;
    public AnchorPane Anchorpane1;
    public ImageView pane2;

    public void txtUserNameOnaction(ActionEvent actionEvent) {
    }

    public void txtpasswordonAction(ActionEvent actionEvent) {
    }

    public void btnLoginonAction(ActionEvent actionEvent) throws IOException {
       /* Navigation.navigate(Route.DASHBOARD,Anchorpane1);*/
        System.out.println(txtUserName.getText());
        String tempUsername =txtUserName.getText();
        String tempPassword =txtPassword.getText();
        System.out.println(txtPassword.getText());
        if (tempUsername.equals("Mihishani") && tempPassword.equals("2001")) {
            /*Navigation.navigate(Route.DASHBOARD,Anchorpane1);*/
            Navigation.navigate(Route.DASHBOARD,Anchorpane1);
            System.out.println(txtPassword.getText());
        }else {
            new Alert(Alert.AlertType.CONFIRMATION, "Try again!").show();
        }
    }
}

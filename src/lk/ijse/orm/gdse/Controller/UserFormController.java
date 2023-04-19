package lk.ijse.orm.gdse.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class UserFormController {
    public ImageView pane1;
    public TextField txtUserId;
    public TextField txtUserName;
    public TextField txtUsertelphone;
    public TextField txtuserEmail;
    public TextField txtPassword;
    public Button btnAdd;
    public Button btnDelete;
    public Button btnUpdate;
    public Button btnView;
    public TableColumn clmUserId;
    public TableColumn clmUserName;
    public TableColumn clmtelNumber;
    public TableColumn clmUserEmail;
    public TableColumn clmPassword;

    public void btnAddOnAction(ActionEvent actionEvent) {
     /* try {
          String userId=txtUserId.getText();
          String userName=txtUserName.getText();
          int userTelNumber=Integer.parseInt(txtUsertelphone.getText());
          String userEmail=txtuserEmail.getText();
          String userPassword=txtPassword.getText();

          UserDto user = new UserDto(userId,userName,userTelNumber,userEmail,userPassword);

          */

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnViewOnAction(ActionEvent actionEvent) {
    }
}

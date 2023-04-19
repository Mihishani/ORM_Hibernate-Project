package lk.ijse.orm.gdse.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.gdse.dao.DaoFactory;
import lk.ijse.orm.gdse.dto.StudentDto;
import lk.ijse.orm.gdse.tm.StudentTM;
import service.custom.StudentService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;


public class StudentFormController {

    public AnchorPane pane1;
    public TextField txtStudentId;
    public TextField txtStudentName;
    public TextField txtAddress;
    public TextField txtTelphoneNO;
    public TextField txtGender;
    public Button btnAdd;
    public Button btnUpdate;
    public Button btnView;
    public Button btnDelete;
    public TableColumn clmStudentId;
    public TableColumn clmStudentName;
    public TableColumn clmAddress;
    public TableColumn clmTelNumber;
    public TableColumn clmGender;
    public TextField txtDateOfBirth;
    public TableView<StudentTM>tblStudent;
    public TableColumn clmDateOfBirth;
    private final StudentService studentService=(StudentService) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.STUDENTFORM);
    public Button btnSave;
    LinkedHashMap<TextField, Pattern>map=new LinkedHashMap<>();


    public void btnAddOnAction(ActionEvent actionEvent) throws Exception {
        String StuId=txtStudentId.getText();
        String StuName=txtStudentName.getText();
        String StuAddress=txtAddress.getText();
        int telNumber=Integer.parseInt(txtTelphoneNO.getText());
        LocalDate DateOfBirth=LocalDate.parse(txtDateOfBirth.getText());
        String Gender=txtGender.getText();

        try{
            if (btnAdd.getText().equalsIgnoreCase("save")){

                boolean save =studentService.SaveStudent(new StudentDto(StuId,StuName,StuAddress,telNumber,DateOfBirth,Gender));
                tblStudent.getItems().add(new StudentTM(StuId,StuName,StuAddress,telNumber,DateOfBirth,Gender));
                if (!save){
                    new Alert(Alert.AlertType.ERROR,"Failed Added").show();
                }
            }else {
                boolean updated=studentService.updateStudent(new StudentDto(StuId,StuName,StuAddress,telNumber,DateOfBirth,Gender));

                if (updated){
                    new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
                }

                StudentTM studentTM = (StudentTM) tblStudent.getSelectionModel().getSelectedItem();
                studentTM.setStuName(StuName);
                studentTM.setStuAddress(StuAddress);
                studentTM.setTelNumber(telNumber);
                studentTM.setDateOfBirth(DateOfBirth);
                studentTM.setGender(Gender);
                tblStudent.refresh();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnViewOnAction(ActionEvent actionEvent) {
        try {
            List<StudentDto> allStudents = studentService.getAllStudents();
            for (StudentDto studentDto:allStudents
            ) {
                tblStudent.getItems().add(
                        new StudentTM(studentDto.getStuId(),studentDto.getStuName(),studentDto.getStuAddress(),studentDto.getTelNumber(),studentDto.getDateOfBirth(),studentDto.getGender()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you Want Delete", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType =alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)){
            try {
                String studentId=tblStudent.getSelectionModel().getSelectedItem().getStuId();
                boolean b = studentService.deleteStudent(studentId);
                if (b){
                    new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
                }
                tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
                tblStudent.getSelectionModel().clearSelection();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        txtStudentId.setDisable(false);
        txtStudentName.setDisable(false);
        txtAddress.setDisable(false);
        txtTelphoneNO.setDisable(false);
        txtDateOfBirth.setDisable(false);
        txtGender.setDisable(false);

        txtStudentId.clear();
        generateNewId();
        txtStudentName.clear();
        txtAddress.clear();
        txtTelphoneNO.clear();
        txtDateOfBirth.clear();
        txtGender.clear();

        txtStudentName.requestFocus();
        btnSave.setDisable(false);
        btnSave.setText("save");
        tblStudent.getSelectionModel().clearSelection();
    }

    private void generateNewId(){
        try{
            String lastStudentId = studentService.generateStudentId();
            int newId= Integer.parseInt(lastStudentId.substring(1,4))+1;
            if (newId <10){
                txtStudentId.setText("S00"+newId);
            }else if(newId <100){
                txtStudentId.setText("S0"+newId);
            }else {
                txtStudentId.setText("S"+newId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package service.custom;

import javafx.collections.ObservableList;
import lk.ijse.orm.gdse.dto.RoomDto;
import lk.ijse.orm.gdse.dto.StudentDto;
import lk.ijse.orm.gdse.tm.CartTM;
import service.SuperService;

import java.io.IOException;
import java.util.List;

public interface ReservationService extends SuperService {
    void Register(ObservableList<CartTM> list,String StudentId,String lblId)throws Exception;
    List<StudentDto> getAllStudents()throws IOException;
    List<RoomDto>getAllRooms()throws IOException;
    List<RoomDto>getRoomDetail(String id)throws Exception;
    List<StudentDto>getStudentDetail(String id)throws Exception;
    String generateReservationId()throws Exception;
}

package service.custom;

import lk.ijse.orm.gdse.dto.StudentDto;
import service.SuperService;

import java.io.IOException;
import java.util.List;

public interface StudentService extends SuperService {
    boolean SaveStudent(StudentDto studentDto)throws Exception;

    boolean updateStudent(StudentDto studentDto)throws Exception;

    boolean deleteStudent(String id)throws Exception;

    String generateStudentId()throws Exception;

    List<StudentDto>getAllStudents()throws IOException;
}

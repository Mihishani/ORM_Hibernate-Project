package service.custom.impl;

import lk.ijse.orm.gdse.dao.DaoFactory;
import lk.ijse.orm.gdse.dao.custom.StudentDao;
import lk.ijse.orm.gdse.dto.StudentDto;
import lk.ijse.orm.gdse.entity.Student;
import service.custom.StudentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao=(StudentDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.STUDENTFORM);
    @Override
    public boolean SaveStudent(StudentDto studentDto) throws Exception {
        return studentDao.save(new Student(studentDto.getStuId(),studentDto.getStuName(),studentDto.getStuAddress(),studentDto.getTelNumber(),studentDto.getDateOfBirth(),studentDto.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDto studentDto) throws Exception {
        return studentDao.update(new Student(studentDto.getStuId(),studentDto.getStuName(),studentDto.getStuAddress(),studentDto.getTelNumber(),studentDto.getDateOfBirth(),studentDto.getGender()));

    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDao.delete(id);

    }

    @Override
    public String generateStudentId() throws Exception {
        String id=studentDao.generateId();
        return id;
    }

    @Override
    public List<StudentDto> getAllStudents() throws IOException {
         List<Student> all= studentDao.getAll();
         List<StudentDto>studentDtos=new ArrayList<>();
         for (Student student:all){
             studentDtos.add(
                  new StudentDto(student.getStuId(),student.getStuName(),student.getStuAddress(),student.getTelNumber(),student.getDateOfBirth(),student.getGender())
             );
         }
         return studentDtos;
    }
}

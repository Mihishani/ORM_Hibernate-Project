package lk.ijse.orm.gdse.dao.custom;

import lk.ijse.orm.gdse.dao.CrudDao;
import lk.ijse.orm.gdse.entity.Student;


import java.util.List;

public interface StudentDao extends CrudDao<Student,String> {
  List<Student> getStudentDetail(String id)throws Exception;
}

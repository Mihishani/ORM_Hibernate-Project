package lk.ijse.orm.gdse.dao.custom;

import lk.ijse.orm.gdse.dao.CrudDao;
import lk.ijse.orm.gdse.entity.User;

import java.util.List;

public interface UserDao extends CrudDao<User,String> {
    List<User> getUserDetail(String UserName, String password)throws Exception;
}

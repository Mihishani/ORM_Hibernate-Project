package service.custom;

import lk.ijse.orm.gdse.dto.UserDto;
import service.SuperService;

import java.io.IOException;
import java.util.List;

public interface UserService extends SuperService {
    boolean saveUser(UserDto userDto)throws Exception;

    boolean updateUser(UserDto userDto)throws Exception;

    boolean deleteUser(String id)throws Exception;

    String generateUserId()throws Exception;

    List<UserDto>getAllUser() throws IOException;
}

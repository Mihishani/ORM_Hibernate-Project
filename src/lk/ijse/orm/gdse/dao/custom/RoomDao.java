package lk.ijse.orm.gdse.dao.custom;

import lk.ijse.orm.gdse.dao.CrudDao;
import lk.ijse.orm.gdse.entity.Room;

import java.util.List;

public interface RoomDao extends CrudDao<Room,String> {
    List<Room> getRoomDetail(String id)throws Exception;
}

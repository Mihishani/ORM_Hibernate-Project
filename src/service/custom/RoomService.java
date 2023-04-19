package service.custom;

import lk.ijse.orm.gdse.dto.RoomDto;
import service.SuperService;

import java.io.IOException;
import java.util.List;

public interface RoomService extends SuperService {
    boolean saveRoom (RoomDto roomDto)throws Exception;

    boolean updateRoom(RoomDto roomDto)throws Exception;

    boolean deleteRoom(String id)throws Exception;

    List<RoomDto> getAllRooms()throws IOException;

}

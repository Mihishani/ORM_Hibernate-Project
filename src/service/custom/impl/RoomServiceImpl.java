package service.custom.impl;

import lk.ijse.orm.gdse.dao.DaoFactory;
import lk.ijse.orm.gdse.dao.custom.RoomDao;
import lk.ijse.orm.gdse.dto.RoomDto;
import lk.ijse.orm.gdse.entity.Room;
import service.custom.RoomService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao=(RoomDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ROOMFORM);
    @Override
    public boolean saveRoom(RoomDto roomDto) throws Exception {
        return roomDao.save(new Room(roomDto.getRoomId(),roomDto.getRoomType(),roomDto.getKeyMoney(),roomDto.getQty()));
    }

    @Override
    public boolean updateRoom(RoomDto roomDto) throws Exception {
        return roomDao.update(new Room(roomDto.getRoomId(),roomDto.getRoomType(),roomDto.getKeyMoney(),roomDto.getQty()));

    }

    @Override
    public boolean deleteRoom(String id) throws Exception {
        return roomDao.delete(id);
    }

    @Override
    public List<RoomDto> getAllRooms() throws IOException {
        List<Room>all = roomDao.getAll();
        List<RoomDto> roomDtos=new ArrayList<>();

        for (Room room:all){
            roomDtos.add(
              new RoomDto(room.getRoomId(),room.getRoomType(),room.getKeyMoney(),room.getQty())
            );
        }
        return roomDtos;
    }
}

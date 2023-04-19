package service.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.orm.gdse.dao.DaoFactory;
import lk.ijse.orm.gdse.dao.custom.ReservationDao;
import lk.ijse.orm.gdse.dao.custom.RoomDao;
import lk.ijse.orm.gdse.dao.custom.StudentDao;
import lk.ijse.orm.gdse.dto.RoomDto;
import lk.ijse.orm.gdse.dto.StudentDto;
import lk.ijse.orm.gdse.entity.Reservation;
import lk.ijse.orm.gdse.entity.Room;
import lk.ijse.orm.gdse.entity.Student;
import lk.ijse.orm.gdse.tm.CartTM;
import lk.ijse.orm.gdse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.custom.ReservationService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    private final RoomDao roomDao=(RoomDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ROOMFORM);
    private final StudentDao studentDao=(StudentDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.STUDENTFORM);
    private final ReservationDao reservationDao=(ReservationDao)DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.RESERVATION);
    @Override
    public void Register(ObservableList<CartTM> list, String StudentId, String lblId) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        try{
            ObservableList<CartTM> items=list;
            for (CartTM tm : items){
                List<Room>roomDetails=roomDao.getRoomDetail(tm.getRoomId());
                Room room=new Room();

                for (Room r:roomDetails){
                    room.setRoomId(r.getRoomId());
                    room.setRoomType(r.getRoomType());
                    room.setKeyMoney(r.getKeyMoney());
                    room.setQty(r.getQty()-1);

                }

                List<Student> studentDetail=studentDao.getStudentDetail(StudentId);

                Student student=new Student();
                for (Student s: studentDetail){
                    student.setStuId(s.getStuId());
                    student.setStuName(s.getStuName());
                    student.setStuAddress(s.getStuAddress());
                    student.setTelNumber(s.getTelNumber());
                    student.setDateOfBirth(s.getDateOfBirth());
                    student.setGender(s.getGender());
                }

                Reservation reservation=new Reservation();
                reservation.setResId(lblId);
                reservation.setDate(LocalDate.now());
                reservation.setStatus(tm.getStatus());
                reservation.setRoom(room);
                reservation.setStudent(student);

                session.save(reservation);
                session.update(room);
                transaction.commit();
            }
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

        session.close();
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

    @Override
    public List<RoomDto> getRoomDetail(String id) throws Exception {
        List<Room>list = roomDao.getRoomDetail(id);
        List<RoomDto> roomDtoArrayList=new ArrayList<>();

        for (Room room:list){
            roomDtoArrayList.add(
                    new RoomDto(room.getRoomId(),room.getRoomType(),room.getKeyMoney(),room.getQty())
            );
        }
        return roomDtoArrayList;
    }

    @Override
    public List<StudentDto> getStudentDetail(String id) throws Exception {
        List<Student> list= studentDao.getStudentDetail(id);
        List<StudentDto>studentDtoArrayList=new ArrayList<>();
        for (Student student:list){
            studentDtoArrayList.add(
                    new StudentDto(student.getStuId(),student.getStuName(),student.getStuAddress(),student.getTelNumber(),student.getDateOfBirth(),student.getGender())
            );
        }
        return studentDtoArrayList;
    }

    @Override
    public String generateReservationId() throws Exception {
        String id = reservationDao.generateId();
        return id;
    }
}

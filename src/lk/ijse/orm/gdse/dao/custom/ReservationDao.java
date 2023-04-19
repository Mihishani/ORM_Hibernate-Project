package lk.ijse.orm.gdse.dao.custom;

import lk.ijse.orm.gdse.dao.CrudDao;
import lk.ijse.orm.gdse.entity.Reservation;

public interface ReservationDao extends CrudDao<Reservation,String> {
    boolean updateUsingId(String id, String status)throws Exception;
}

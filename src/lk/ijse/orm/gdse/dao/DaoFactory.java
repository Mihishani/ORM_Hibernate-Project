package lk.ijse.orm.gdse.dao;

import lk.ijse.orm.gdse.dao.custom.impl.ReservationDaoImpl;
import lk.ijse.orm.gdse.dao.custom.impl.RoomDaoImpl;
import lk.ijse.orm.gdse.dao.custom.impl.StudentDaoImpl;
import lk.ijse.orm.gdse.dao.custom.impl.UserDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){

    }

    public static DaoFactory getDaoFactory(){
        if (daoFactory==null){
            return new DaoFactory();
        }
        return daoFactory;
    }

    public enum DaoTypes{
        MAINPAGE,USERLOGIN,USERFORM,STUDENTFORM,ROOMFORM,RESERVATION,DASHBOARD
    }

    public Object getDao(DaoTypes types){
        switch (types){
            case STUDENTFORM:
                return new StudentDaoImpl();

            case ROOMFORM:
                return new RoomDaoImpl();

            case USERFORM:
                return new UserDaoImpl();

            case RESERVATION:
                return new ReservationDaoImpl();
            default:
                return null;
        }
    }
}

package service;

import service.custom.impl.ReservationServiceImpl;
import service.custom.impl.RoomServiceImpl;
import service.custom.impl.StudentServiceImpl;
import service.custom.impl.UserServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){

    }

    public static ServiceFactory getServiceFactory(){
        if (serviceFactory==null){
            return new ServiceFactory();
        }
        return serviceFactory;
    }

    public enum ServiceTypes{
        MAINPAGE,USERLOGIN,USERFORM,STUDENTFORM,ROOMFORM,RESERVATION,DASHBOARD
    }

    public SuperService getService(ServiceFactory.ServiceTypes types){
        switch (types){
            case USERFORM:
                return new UserServiceImpl();
            case STUDENTFORM:
                return new StudentServiceImpl();
            case ROOMFORM:
                return new RoomServiceImpl();
            case RESERVATION:
                return new ReservationServiceImpl();
            default:
                return null;
        }
    }
}

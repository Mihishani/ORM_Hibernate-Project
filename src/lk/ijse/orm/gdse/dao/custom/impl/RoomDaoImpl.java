package lk.ijse.orm.gdse.dao.custom.impl;

import lk.ijse.orm.gdse.dao.custom.RoomDao;
import lk.ijse.orm.gdse.entity.Room;
import lk.ijse.orm.gdse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    @Override
    public boolean save(Room room) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        session.save(room);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room room) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        session.update(room);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        Room room=session.load(Room.class,id);
        session.delete(room);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public List<Room> getAll() throws IOException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        Query query = session.createQuery("from Room ");
        List<Room> list= query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String generateId() throws Exception {
      return null;
    }

    @Override
    public List<Room> getRoomDetail(String id) throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        Query query= session.createQuery("FROM Room WHERE RoomId=:id");
        query.setParameter("id",id);

        List<Room> list= query.list();

        transaction.commit();
        session.close();

        return list;
    }
}

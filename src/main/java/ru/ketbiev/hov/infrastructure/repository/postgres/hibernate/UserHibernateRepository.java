package ru.ketbiev.hov.infrastructure.repository.postgres.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ketbiev.hov.core.model.User;
import ru.ketbiev.hov.core.port.repository.UserRepository;
import ru.ketbiev.hov.infrastructure.repository.postgres.hibernate.dto.UserDto;

public class UserHibernateRepository implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User add(User user) {
        UserDto userDto = DtoParser.toUserDto(user);

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        UserDto userDone;
        try {
            tx = session.beginTransaction();
            long id = (long) session.save(userDto);
            userDone = session.get(UserDto.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            userDone = null;
        } finally {
            session.close();
        }

        return DtoParser.toUser(userDone);
    }

    @Override
    public User get(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        User user = null;
        try {
            tx = session.beginTransaction();
            user = session.get(User.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        boolean done;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(user);
            tx.commit();
            done = true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            done = false;
        } finally {
            session.close();
        }
        return done;
    }

    @Override
    public boolean delete(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        boolean done;
        try {
            tx = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            tx.commit();
            done = true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
            done = false;
        } finally {
            session.close();
        }
        return done;
    }

}
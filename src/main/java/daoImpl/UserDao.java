package daoImpl;

import daoTasks.Dao;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateSessionAnnotationFactoryUtil;

import java.util.List;

public class UserDao implements Dao<User> {
    SessionFactory sessionFactory = HibernateSessionAnnotationFactoryUtil.getSessionFactory();

    @Override
    public void create(User model) {
        if(model.getAge() >= 18 && model.getEmail().contains("@")) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(model);
                session.getTransaction().commit();
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void update(User model, int id_model) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("UPDATE User " +
                    "SET " +
                    "full_name =: full_name, " +
                    "login =: login, " +
                    "email =: email, " +
                    "age =: age, " +
                    "is_author =: is_author, " +
                    "is_moderator =: is_moderator "  +
                    "WHERE id_user =: id_user");
            query.setParameter("full_name", model.getFull_name());;
            query.setParameter("login", model.getLogin());;
            query.setParameter("email", model.getEmail());;
            query.setParameter("age", model.getAge());;
            query.setParameter("is_author", model.isIs_author());;
            query.setParameter("is_moderator", model.isIs_moderator());;
            query.setParameter("id_user", session.get(User.class, id_model).getId_user());
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public User findById(int id_model) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE id_user =: id_user");
            query.setParameter("id_user", session.get(User.class, id_model).getId_user());
            List list = query.list();
            return (User) list.get(0);
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM User");
            List list = query.list();
            return list;
        }
    }

    @Override
    public boolean deleteById(int id_model) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User " +
                    "WHERE id_user =: id_user");
            query.setParameter("id_user", session.get(User.class, id_model).getId_user());
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        }
    }

    public User getUserWithId(User module) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE login =: login");
            query.setParameter("login", module.getLogin());
            List list = query.list();
            return (User) list.get(0);
        }
    }
}

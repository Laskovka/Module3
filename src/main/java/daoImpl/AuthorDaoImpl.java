package daoImpl;

import daoTasks.AuthorDao;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateSessionAnnotationFactoryUtil;

import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    SessionFactory sessionFactory = HibernateSessionAnnotationFactoryUtil.getSessionFactory();

    @Override
    public List<String> findAllAuthors() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("SELECT full_name FROM User " +
                    "WHERE is_author = TRUE"); //maybe it isn't necessary
            List list = query.list();
            return list;
        }
    }

    @Override
    public List<String> findTopAuthors(int limit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("SELECT DISTINCT u.full_name FROM User AS u INNER JOIN Post AS p ON u.id_user = p.author_id " +
                    "WHERE u.id_user = p.author_id AND p.rating >=: rating");
            query.setParameter("rating", limit);
            List list = query.list();
            return list;
        }
    }
}

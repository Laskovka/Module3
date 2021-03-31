package daoImpl;

import daoTasks.FollowersDao;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateSessionAnnotationFactoryUtil;

import java.util.List;

public class FollowersDaoImpl implements FollowersDao {
    SessionFactory sessionFactory = HibernateSessionAnnotationFactoryUtil.getSessionFactory();

    @Override
    public List<String> findAllFollowers(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("SELECT u.login FROM User u INNER JOIN Saf s ON u.id_user = s.id_subscriber " +
                    "WHERE s.id_user =: user AND s.id_subscriber = u.id_user");
            query.setParameter("user", user);
            List list = query.list();
            return list;
        }
    }
}

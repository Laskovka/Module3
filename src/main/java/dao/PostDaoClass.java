package dao;

import entities.Post;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateSessionFactoryUtil;

import java.util.List;

public class PostDaoClass implements Dao<Post>, PostDao {
    private SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    @Override
    public List<Post> findAllPostsByAuthor(User author) {
        return null;
    }

    @Override
    public List<Post> findTopPosts(int limit) {
        return null;
    }

    @Override
    public List<Post> findTopAuthorsPosts(User author, int limit) {
        return null;
    }

    @Override
    public void create(Post model) {
        try (Session session = sessionFactory.openSession()) {
            //Чтобы созранить объект в бд - нужно начать транзакцию
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Post model, int id_model) {

    }

    @Override
    public Post findById(int id_model) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id_model) {
        return false;
    }
}

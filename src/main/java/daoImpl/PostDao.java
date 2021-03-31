package daoImpl;

import daoTasks.Dao;
import entities.Post;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateSessionAnnotationFactoryUtil;

import java.util.List;

public class PostDao implements Dao<Post>, daoTasks.PostDao {
    SessionFactory sessionFactory = HibernateSessionAnnotationFactoryUtil.getSessionFactory();

    @Override
    public void create(Post model) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Post model, int id_model) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("UPDATE Post " +
                    "SET " +
                    "title =: title, " +
                    "content =: content, " +
                    "author_id =: author_id, " +
                    "moderator_id =: moderator_id, " +
                    "rating =: rating, " +
                    "status =: status " +
                    "WHERE id_post =: id_post");
            query.setParameter("title", model.getTitle());
            query.setParameter("content", model.getContent());
            query.setParameter("author_id", model.getAuthor_id());
            query.setParameter("moderator_id", model.getModerator_id());
            query.setParameter("rating", model.getRating());
            query.setParameter("status", model.getStatus());
            query.setParameter("id_post", session.get(Post.class, id_model).getId_post());
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public Post findById(int id_model) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM Post WHERE id_post =: id_post");
            query.setParameter("id_post", session.get(Post.class, id_model).getId_post());
            List list = query.list();
            return (Post) list.get(0);
        }
    }

    @Override
    public List<Post> findAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM Post");
            List list = query.list();
            return list;
        }
    }

    @Override
    public boolean deleteById(int id_model) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Post " +
                    "WHERE id_post =: id_post");
            query.setParameter("id_post", session.get(Post.class, id_model).getId_post());
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public List<Post> findAllPostsByAuthor(User author) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM Post " +
                    "WHERE author_id =: author_id");
            query.setParameter("author_id", author);
            List list = query.list();
            session.getTransaction().commit();
            return list;
        }
    }

    @Override
    public List<Post> findTopPosts(int limit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM Post " +
                    "WHERE rating >=: rating");
            query.setParameter("rating", limit);
            List list = query.list();
            session.getTransaction().commit();
            return list;
        }
    }

    @Override
    public List<Post> findTopAuthorsPosts(User author, int limit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM Post " +
                    "WHERE rating >=: rating AND author_id =: author_id");
            query.setParameter("rating", limit);
            query.setParameter("author_id", author);
            List list = query.list();
            session.getTransaction().commit();
            return list;
        }
    }
}

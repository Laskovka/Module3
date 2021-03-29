import dao.PostDaoClass;
import dao.UserDao;
import entities.Post;
import entities.PostStatus;
import entities.User;
import org.hibernate.SessionFactory;
import util.HibernateSessionFactoryUtil;

public class App {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

        User user1 = new User("laa", "hfya", "fahwf@ga", 25, true, true);
        User user2 = new User("laa", "hfyaa", "fahwfsa@ga", 20, true, true);
        UserDao userDao = new UserDao();
//        userDao.create(user1);
//        userDao.create(user2);
//        userDao.update(user, 1);
//        System.out.println(userDao.findById(1));
//        System.out.println(userDao.findAll());
//        userDao.deleteById(1);

        user1.setId_user(userDao.selectIdUser(user1));
        user2.setId_user(userDao.selectIdUser(user2));
        Post post1 = new Post("title", "content", user1, user1, 10, PostStatus.PUBLISHED);
        Post post2 = new Post("title", "content", user1, user1, 10, PostStatus.PUBLISHED);
        Post post3 = new Post("title", "content", user2, user2, 10, PostStatus.PUBLISHED);
        Post post4 = new Post("title", "content", user2, user2, 10, PostStatus.PUBLISHED);
        PostDaoClass postDaoClass = new PostDaoClass();
        postDaoClass.create(post1);
        postDaoClass.create(post2);
        postDaoClass.create(post3);
        postDaoClass.create(post4);
    }
}

import daoImpl.*;
import daoImpl.additionalDao.SafDao;
import daoTasks.FollowersDao;
import daoTasks.SubscriptionsDao;
import entities.Post;
import entities.PostStatus;
import entities.User;
import entities.additionalEntity.Saf;

public class App {
    public static void main(String[] args) {
        User user1 = new User("laa", "2", "2@garew", 20, true, true);
        User user2 = new User("laa", "1", "1@garw", 25, true, true);
        User user3 = new User("lafsa", "hfyasasfa", "fasashwfsa@ga", 20, true, true);
        User user = new User("sflaa", "sfawhfyatr", "saffahwf@garew", 25, true, true);
        UserDao userDao = new UserDao();
        /*UserDao implements Dao*/
        /*userDao.create(user);
        User userForUpdate = new User("Updatesflaa", "Updatesfawhfyatr", "Updatesaffahwf@garew", 40, true, true);
        userDao.update(userForUpdate, 15);
        System.out.println(userDao.findById(15));
        System.out.println(userDao.findAll());
        userDao.deleteById(14);*/

        Post post = new Post("title", "content", userDao.getUserWithId(user), userDao.getUserWithId(user3), 10, PostStatus.IN_PROGRESS);
        PostDao postDao = new PostDao();
        /*PostDao implements Dao*/
        /*postDao.create(post);
        Post postForUpdate = new Post("Updatetitle", "Updatecontent", userDao.getUserWithId(user), userDao.getUserWithId(user3), 10, PostStatus.IN_PROGRESS);
        postDao.update(postForUpdate, 4);
        System.out.println(postDao.findById(5));
        System.out.println(postDao.findAll());
        postDao.deleteById(4);*/

        /*PostDaoImpl implements PostDao*/
        /*System.out.println(postDao.findAllPostsByAuthor(userDao.getUserWithId(user)));
        System.out.println(postDao.findTopPosts(9));
        System.out.println(postDao.findTopAuthorsPosts(userDao.getUserWithId(user3), 9));*/

        /*AuthorDaoImpl implements AuthorDao*/
        /*AuthorDaoImpl authorDao = new AuthorDaoImpl();
        System.out.println(authorDao.findAllAuthors());
        System.out.println(authorDao.findTopAuthors(9));*/

        Saf saf1 = new Saf(userDao.getUserWithId(user3), userDao.getUserWithId(user));
        Saf saf2 = new Saf(userDao.getUserWithId(user), userDao.getUserWithId(user3));
        Saf saf3 = new Saf(userDao.getUserWithId(user1), userDao.getUserWithId(user2));
        Saf saf4 = new Saf(userDao.getUserWithId(user1), userDao.getUserWithId(user3));
        /*SafDao safDao = new SafDao();
        safDao.insert(saf1);
        safDao.insert(saf2);
        safDao.insert(saf3);
        safDao.insert(saf4);*/

        /*FollowersDaoImpl implements FollowersDao*/
        /*FollowersDaoImpl followersDao = new FollowersDaoImpl();
        System.out.println(followersDao.findAllFollowers(userDao.getUserWithId(user1)));*/

        /*SubscriptionsDaoImpl implements SubscriptionsDao*/
        /*SubscriptionsDaoImpl subscriptionsDao = new SubscriptionsDaoImpl();
        System.out.println(subscriptionsDao.findAllSubscriptions(userDao.getUserWithId(user3)));*/
    }
}

package entities;

public class Post {
    private int id_post;
    private String title;
    private String content;
    private User author_id;
    private User moderator_id;
    private int rating;
    private PostStatus status;

    public Post(String title, String content, User author_id, User moderator_id, int rating, PostStatus status) {
        this.title = title;
        this.content = content;
        this.author_id = author_id;
        this.moderator_id = moderator_id;
        this.rating = rating;
        this.status = status;
    }

    public Post() {
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(User author_id) {
        this.author_id = author_id;
    }

    public User getModerator_id() {
        return moderator_id;
    }

    public void setModerator_id(User moderator_id) {
        this.moderator_id = moderator_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }
}

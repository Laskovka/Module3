package entities;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_post;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne()
    @JoinColumns(@JoinColumn(name = "author_id", referencedColumnName = "id_user"))
    private User author_id;

    @ManyToOne()
    @JoinColumns(@JoinColumn(name = "moderator_id", referencedColumnName = "id_user"))
    private User moderator_id;

    @Column(name = "rating")
    private int rating;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
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

    @Override
    public String toString() {
        return "Post{" +
                "id_post=" + id_post +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author_id=" + author_id +
                ", moderator_id=" + moderator_id +
                ", rating=" + rating +
                ", status=" + status +
                '}';
    }
}

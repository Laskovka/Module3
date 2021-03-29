package entities;

public class User {
    private int id_user;
    private String full_name;
    private String login;
    private String email;
    private int age;
    private boolean is_author;
    private boolean is_moderator;

    public User(String full_name, String login, String email, int age, boolean is_author, boolean is_moderator) {
        this.full_name = full_name;
        this.login = login;
        this.email = email;
        this.age = age;
        this.is_author = is_author;
        this.is_moderator = is_moderator;
    }

    public User() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIs_author() {
        return is_author;
    }

    public void setIs_author(boolean is_author) {
        this.is_author = is_author;
    }

    public boolean isIs_moderator() {
        return is_moderator;
    }

    public void setIs_moderator(boolean is_moderator) {
        this.is_moderator = is_moderator;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", full_name='" + full_name + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", is_author=" + is_author +
                ", is_moderator=" + is_moderator +
                '}';
    }
}

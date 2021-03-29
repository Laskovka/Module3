CREATE TABLE post
(
    id_post INT NULL PRIMARY KEY AUTO_INCREMENT,
    title   VARCHAR(100) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    author_id INT NOT NULL,
    moderator_id INT NOT NULL,
    rating INT NOT NULL,
    status VARCHAR(50) NOT NULL,
    FOREIGN KEY (author_id) REFERENCES user (id_user),
    FOREIGN KEY (moderator_id) REFERENCES user (id_user)

);
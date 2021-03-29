CREATE TABLE user
(
    id_user      INT NULL PRIMARY KEY AUTO_INCREMENT,
    full_name    VARCHAR(100) NOT NULL,
    login        VARCHAR(50) NOT NULL UNIQUE,
    email        VARCHAR(150) NOT NULL UNIQUE,
    age          INT NOT NULL,
    is_author    VARCHAR(5) NOT NULL,
    is_moderator TINYINT NOT NULL
);

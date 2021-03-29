CREATE TABLE saf
(
    id_saf        INT NULL PRIMARY KEY AUTO_INCREMENT,
    id_user       INT NOT NULL,
    id_subscriber INT NOT NULL,
    FOREIGN KEY (id_user) REFERENCES user (id_user),
    FOREIGN KEY (id_subscriber) REFERENCES user (id_user)
);
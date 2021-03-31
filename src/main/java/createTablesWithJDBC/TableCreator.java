package createTablesWithJDBC;

public class TableCreator {
    private static final String CREATE_POST = "" +
            "CREATE TABLE post\n" +
            "(\n" +
            "    id_post INT PRIMARY KEY AUTO_INCREMENT,\n" +
            "    title   VARCHAR(100) NOT NULL,\n" +
            "    content VARCHAR(1000) NOT NULL,\n" +
            "    author_id INT NOT NULL,\n" +
            "    moderator_id INT NOT NULL,\n" +
            "    rating INT NOT NULL,\n" +
            "    status VARCHAR(50) NOT NULL,\n" +
            "    FOREIGN KEY (author_id) REFERENCES user (id_user),\n" +
            "    FOREIGN KEY (moderator_id) REFERENCES user (id_user)\n" +
            "\n" +
            ");";
    private static final String CREATE_SAF = "" +
            "CREATE TABLE saf\n" +
            "(\n" +
            "    id_saf        INT PRIMARY KEY AUTO_INCREMENT,\n" +
            "    id_user       INT NOT NULL,\n" +
            "    id_subscriber INT NOT NULL,\n" +
            "    FOREIGN KEY (id_user) REFERENCES user (id_user),\n" +
            "    FOREIGN KEY (id_subscriber) REFERENCES user (id_user)\n" +
            ");";
    private static final String CREATE_USER = "" +
            "CREATE TABLE user\n" +
            "(\n" +
            "    id_user      INT PRIMARY KEY AUTO_INCREMENT,\n" +
            "    full_name    VARCHAR(100) NOT NULL,\n" +
            "    login        VARCHAR(50) NOT NULL UNIQUE,\n" +
            "    email        VARCHAR(150) NOT NULL UNIQUE,\n" +
            "    age          INT NOT NULL,\n" +
            "    is_author    BOOLEAN NOT NULL,\n" +
            "    is_moderator BOOLEAN NOT NULL\n" +
            ");";

    public void createTables(createTablesWithJDBC.DatabaseConnector databaseConnector) {
        databaseConnector.executeUpdate(CREATE_USER);
        databaseConnector.executeUpdate(CREATE_POST);
        databaseConnector.executeUpdate(CREATE_SAF);
    }
}

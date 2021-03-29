package JDBC;

public class App {
    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        TableCreator tableCreator = new TableCreator();
        tableCreator.createTableStudents(databaseConnector);
    }
}

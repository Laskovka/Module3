package createTablesWithJDBC;

public class Implementation {
    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        TableCreator tableCreator = new TableCreator();
        tableCreator.createTables(databaseConnector);
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection connection;

    public DBConnection(){
        System.out.println("--------------------------Connection checking---------------------------");

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsdb",
                    "root", "root");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            System.out.println("Соединение установлено");
        } else {
            System.out.println("Соединение не установлено");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

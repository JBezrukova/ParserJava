import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsDAO {

    public void addNew(News news, Connection connection) {
        try {
            Statement statement = connection.createStatement();
            String y = "\'";
            String query = "insert into news (dateOfNews, newsText) values (" + y + news.getDate() + y + ", " + y + news.getNewsText() + y + ");";
            System.out.println(query);
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


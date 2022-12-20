package se.lexcon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        person();
    }
    public static void person() {
        String query = "select * from person";

        try (
                Connection myconn = MySqlConnection.getConnection();
                Statement mystat = myconn.createStatement();
                ResultSet resultSet = mystat.executeQuery(query);

        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("first_name"));
                System.out.println(resultSet.getString("last_name"));
                System.out.println(resultSet.getString("email"));
            }

        } catch (JDBCConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}

package se.lexcon;

import se.lexcon.model.Person;
import se.lexcon.model.TodoItem;

import java.sql.*;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ex2();
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
    public static void ex2() {

        String query = "select * from person where id = ? and first_name like ? and last_name like ?";

        int personId = 7;
        try (
                Connection connection = MySqlConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);

        ) {

            preparedStatement.setInt(1, personId);
            preparedStatement.setString(2, "A" + "%");
            preparedStatement.setString(3,"H" + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("first_name"));
                    System.out.println(resultSet.getString("last_name"));
                    System.out.println("-------------");
                }

            }

        } catch (JDBCConnectionException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    }



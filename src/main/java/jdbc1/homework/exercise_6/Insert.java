package jdbc1.homework.exercise_6;

import java.sql.*;
import java.util.Calendar;

/**
 * Задание 6
 * Создать базу данных в Workbench и подключить к IntelijIdea и создать тестовую таблицу.
 * Заполнить ее данными с помощью запросов MySQL в IntelijIdea. Используя JDBC написать пример выполнения всех запросов.
 */
public class Insert {


    private static final String URL = "jdbc:mysql://localhost:3306/MyNewDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String INSERT_NEW = "INSERT INTO testingtable " +
            "(title, author, total_pages, rating, publish_date) " +
            "VALUES " +
            "(?, ?, ?, ?, ?)";


    public static void main(String[] args) {
        registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(INSERT_NEW);

            statement.setString(1, "The Little Prince");
            statement.setString(2, "Antoine de Saint-Exupéry");
            statement.setInt(3, 128);
            statement.setDouble(4, 5.0);
            statement.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));

            statement.setString(1, "Alice's Adventures in Wonderland");
            statement.setString(2, "Lewis Carroll");
            statement.setInt(3, 200);
            statement.setDouble(4, 5.0);
            statement.setDate(5, new Date(Calendar.getInstance().getTimeInMillis()));

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

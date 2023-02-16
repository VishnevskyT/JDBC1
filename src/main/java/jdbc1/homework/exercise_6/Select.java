package jdbc1.homework.exercise_6;

import java.sql.*;

public class Select {


    private static final String URL = "jdbc:mysql://localhost:3306/MyNewDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String SELECT = "SELECT * FROM testingtable";


    public static void main(String[] args) {
        registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(SELECT);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String author = resultSet.getString("author");
                int total_pages = resultSet.getInt(4);
                double rating = resultSet.getDouble("rating");
                Date publish_date = resultSet.getDate(6);

                System.out.println(id + "\t" + title + "\t" + author + "\t" + total_pages
                        + "\t" + rating + "\t" + publish_date);
            }

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

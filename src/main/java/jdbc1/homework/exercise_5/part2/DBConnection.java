package jdbc1.homework.exercise_5.part2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<freeEmployee> getFreeEmployees() {
        Connection connection = null;
        Statement statement = null;
        List<freeEmployee> freeEmployees = new ArrayList<>();


        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT id, name, birthday, phone, status FROM general" +
                    " JOIN personal_data" +
                    " ON general.id = personal_data.person_id" +
                    " WHERE personal_data.status = 'free'" +
                    " ORDER BY birthday DESC");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Date birthday = resultSet.getDate("birthday");
                String phone = resultSet.getString("phone");
                String status = resultSet.getString("status");

                freeEmployee freeEmployee = new freeEmployee(id, name, birthday, phone, status);

                freeEmployees.add(freeEmployee);

            }
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
        return freeEmployees;
    }

}
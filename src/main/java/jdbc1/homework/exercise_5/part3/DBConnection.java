package jdbc1.homework.exercise_5.part3;

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

    public List<Manager> getAllManagers() {
        Connection connection = null;
        Statement statement = null;
        List<Manager> managers = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT id, name, birthday, phone, position FROM general" +
                    " JOIN staff" +
                    " ON general.id = staff.person_id" +
                    " JOIN personal_data" +
                    " ON general.id = personal_data.person_id" +
                    " WHERE staff.position = 'manager'" +
                    "ORDER BY phone DESC");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Date birthday = resultSet.getDate("birthday");
                String phone = resultSet.getString("phone");
                String position = resultSet.getString("position");

                Manager manager = new Manager(id, name, birthday, phone, position);

                managers.add(manager);

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
        return managers;
    }

}

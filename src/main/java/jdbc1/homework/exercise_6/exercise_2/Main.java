package jdbc1.homework.exercise_6.exercise_2;

import java.io.*;
import java.sql.*;

/**
 * Задание 2
 * Используя дополнительное задания все вопросы записать в текстовом файле с новой строки каждый и
 * используя потоки ввода-вывода считать с файла все запросы и выполнить.
 */
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/MyNewDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";


    public static void main(String[] args) {
        registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\LapTopUSA\\IdeaProjects\\JDBC1\\src\\main\\resources\\queries.sql"));
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);

            while (reader.readLine() != null) {
                if (reader.readLine() == null) {
                    continue;
                }
                statement = connection.prepareStatement(reader.readLine());
                statement.execute();
            }

            reader.close();

        } catch (SQLException | IOException e) {
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

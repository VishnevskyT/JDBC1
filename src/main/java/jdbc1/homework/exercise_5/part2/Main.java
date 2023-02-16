package jdbc1.homework.exercise_5.part2;

import java.util.List;

public class Main {

    /**
     Задание 5
     * Используя IntelijIdea и JDBC cделайте выборку при помощи JOIN’s для таких заданий:
     * 2) Получите информацию о дате рождения всех холостых сотрудников и их номера.
     */

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();

        List<freeEmployee> employees = dbConnection.getFreeEmployees();

        for (freeEmployee employee : employees) {
            System.out.println(employee.getId() + "\t" + employee.getName() + "\t" +
                    employee.getBirthday() + "\t" + employee.getPhone() + "\t" +
                    employee.getStatus());

        }
    }
}

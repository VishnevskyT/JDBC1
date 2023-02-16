package jdbc1.homework.exercise_5.part1;

import java.util.List;

public class Main {

    /**
     * Задание 5
     * Используя IntelijIdea и JDBC cделайте выборку при помощи JOIN’s для таких заданий:
     * 1) Получите контактные данные сотрудников (номера телефонов, место жительства).
     */

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();

        List<Employee> employees = dbConnection.getEmployees();

        for (Employee employee : employees) {
            System.out.println(employee.getId() + "\t" + employee.getName() + "\t" +
                    employee.getPhone() + "\t" + employee.getAddress());

        }

    }

}

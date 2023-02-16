package jdbc1.homework.exercise_5.part3;

import java.util.List;

public class Main {

    /**
     * Задание 5
     * Используя IntelijIdea и JDBC cделайте выборку при помощи JOIN’s для таких заданий:
     * 3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.
     */
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();

        List<Manager> managers = dbConnection.getAllManagers();

        for (Manager manager : managers) {
            System.out.println(manager.getId() + "\t" + manager.getName() + "\t" +
                    manager.getBirthday() + "\t" + manager.getPhone() + "\t" +
                    manager.getPosition());

        }
    }
}

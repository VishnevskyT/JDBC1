package jdbc1.homework.exercise_5.part3;

import java.util.Date;

public class Manager {
    private int id;
    private String name;
    private Date birthday;
    private String phone;
    private String position;

    public Manager(int id, String name, Date birthday, String phone, String position) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

}

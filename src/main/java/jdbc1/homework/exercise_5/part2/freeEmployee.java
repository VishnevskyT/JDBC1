package jdbc1.homework.exercise_5.part2;

import java.util.Date;

public class freeEmployee {
    private int id;
    private String name;
    private Date birthday;
    private String phone;
    private String status;


    public freeEmployee(int id, String name, Date birthday, String phone, String status) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

}

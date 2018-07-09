package beans;

import java.io.Serializable;

public class User {
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private int age;
    private transient String password;
    private String test2;
    public User(){

    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String surname, int age, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

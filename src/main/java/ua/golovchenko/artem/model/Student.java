package ua.golovchenko.artem.model;

/**
 * Created by Artem on 10.12.2017.
 *
 * @author Artem Golovchenko
 */
public class Student {
    private String name;
    private int age;
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}

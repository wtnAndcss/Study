package testRecusion;

import java.io.Serializable;

//用于测试对象流的对象
public class Person implements Serializable {



    private String name;

    private int age;

    public void eat() {
        System.out.println(name + "Person的eat方法");
    }

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

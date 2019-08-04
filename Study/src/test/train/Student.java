package test.train;

import java.util.Objects;

public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 重写Student对象的equals方法（不要忘记加@Override）
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {

        if (this == o)  return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        // return name != null ? name.equals(student.name) : student.name == null;
        return Objects.equals(name, student.name);
    }

    /**
     * 重写Student对象的hashCode方法（不要忘记加@Override）
     * @return
     */
    @Override
    public int hashCode() {

        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public String toString() {

        return "name：" + name + " age：" + age;
    }

}

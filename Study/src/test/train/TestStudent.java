package test.train;

import java.util.HashSet;
import java.util.Set;

/**
 * 使用HashSet集合存储Student对象并遍历，
 * 遍历集合的时候再控制台输Student对象的成员变量值。
 * Student的name和age相同视为1人，即存储的集合中不能有重复的Student对象
 */
public class TestStudent {

    public static void main(String[] args) {

        Student student1 = new Student("siri", 23);
        Student student2 = new Student("tony", 22);
        Student student3 = new Student("cindy", 30);
        Student student4 = new Student("lili", 32);
        Student student5 = new Student("lili", 32);

        Set<Student> set = new HashSet();
        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student4);
        set.add(student5);

        for (Student s : set) {
            System.out.println(s.toString());
        }

        // student4 == student5                             false：两个值相同的对象，他们内存中的地址不相同
        // student4.equals(student5) --未重写equals方法      false：与==功能相同
        // student4.equals(student5) --已重写equals方法      true：只比较2个对象的值

        System.out.println(student4.equals(student5));
    }

    /**
     * 总结：
     *  ==          比较两个对象的地址，即比较两个对象是否在同一内存空间上
     *  equals      比较两个对象的地址，与==相同（未重写）
     *              比较两个对象的值（重写后）
     *  注意：重写equals方法时总是要重写hashCode方法！
     *
     * HashSet底层是使用的HashMap，而add()对应put()方法
     * 在put方法中equals方法比较的是
     *
     *
     *  扩展：
     *      值相等的基本数据类型：
     *          int a = 1;
     *          byte b = 1;
     *          ==：比较结果---true
     */
}

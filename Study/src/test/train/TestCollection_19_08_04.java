package test.train;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 使用Collection集合存储自定义对象并遍历，
 * 遍历集合的时候，在控制台输出学生对象的成员变量值。
 */
public class TestCollection_19_08_04 {

    public static void main(String[] args) {

        TestCollection_19_08_04 test = new TestCollection_19_08_04();
        test.testCollection();
    }

    public void testCollection() {

        Collection<Student> studentList = new ArrayList<>();
        Student s1 = new Student("tony", 23);
        Student s2 = new Student("css", 22);
        studentList.add(s1);
        studentList.add(s2);

        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        /*for (Student s : studentList) {
            System.out.println(s.toString());
        }*/
    }
}

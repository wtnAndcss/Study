package test.train;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 要求保证键的唯一性：
 *  如果学生对象的成员变量Name值相同，就认为是同一个对象。
 */
public class TestStudent_map {

    public static void main(String[] args) {

        Student student1 = new Student("siri", 23);
        Student student2 = new Student("tony", 22);
        Student student3 = new Student("cindy", 30);
        Student student4 = new Student("lili", 32);
        Student student5 = new Student("lili", 32);

        Map<String, Student> map = new HashMap<>();
        map.put(student1.getName(), student1);
        map.put(student2.getName(), student2);
        map.put(student3.getName(), student3);
        map.put(student4.getName(), student4);
        map.put(student5.getName(), student5);

        Set<Map.Entry<String, Student>> entries = map.entrySet();
      /*  for (Map.Entry<String, Student> m : entries) {
            System.out.println(m.getKey() + "，" + m.getValue());
        }*/
        TestStudent_map t = new TestStudent_map();
        t.test2();
    }

    public void test2() {

        Student student1 = new Student("siri", 23);
        Student student2 = new Student("tony", 22);
        Student student3 = new Student("cindy", 30);
        Student student4 = new Student("lili", 32);
        Student student5 = new Student("lili", 32);

        Map<Student, String> map = new HashMap<>();
        map.put(student1, "广西");
        map.put(student2, "广东");
        map.put(student3, "宁夏");
        map.put(student4, "云南");
        map.put(student5, "新疆");

        Set<Student> students = map.keySet();
        for (Student s : students) {
            String address = map.get(s);
            System.out.println(s.toString() +"--"+ address);
        }

    }
}

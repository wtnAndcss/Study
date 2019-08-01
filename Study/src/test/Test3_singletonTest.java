package test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式测试类
 */
public class Test3_singletonTest {

    public static void main(String[] args) {

        Test3_singletonTest test = new Test3_singletonTest();
        test.testDeserialize();
        test.testReflect();
    }

    /**
     * 1.测试反射安全问题
     */
    public void testReflect() {

        Test3_singleton instance1 = Test3_singleton.getInstance();
        Test3_singleton instance2 = null;

        try {
            Class<Test3_singleton> clazz = Test3_singleton.class;
            Constructor<Test3_singleton> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance2 = constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }

    /**
     * 2.测试反序列化安全问题
     */
    public void testDeserialize() {

        Test3_singleton instance1 = Test3_singleton.getInstance();
        Test3_singleton instance2 = null;

        try {
            ObjectOutput output = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
            output.writeObject(instance1);
            output.close();

            ObjectInput input = new ObjectInputStream(new FileInputStream("singleton.ser"));
            instance2 = (Test3_singleton)input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}

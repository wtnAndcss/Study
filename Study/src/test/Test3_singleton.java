package test;

import java.io.Serializable;

/**
 * 单例模式的实现方式
 * 该方式可解决反射安全、反序列化安全、指令重排优、延迟加载、线程安全问题
 */
public class Test3_singleton implements Serializable {

    private static volatile Test3_singleton instance ;

    private Test3_singleton(){
        if (instance != null)
            throw new RuntimeException("休想反射我！");
    }

    public static Test3_singleton getInstance() {
        if (instance == null) {
            synchronized (Test3_singleton.class) {
                if (instance == null)
                    instance = new Test3_singleton();
            }
        }
        return instance;
    }

    /**
     * 若没有重写此方法，单例对象在反序列化时会生成新的对象
     * 此处重写该方法，使其返回统一实例即可
     * @return
     */
    protected Object readResolve() {
        return getInstance();
    }
}

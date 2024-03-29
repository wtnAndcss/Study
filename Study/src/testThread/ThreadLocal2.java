package testThread;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.*;

//实现自己的ThreadLocal
public class ThreadLocal2<T> {

    private Map<Thread, T> threadTMap = new HashMap<>();

    public synchronized void set(T t) {
        threadTMap.put(Thread.currentThread(), t);
    }

    public synchronized T get() {
        return threadTMap.get(Thread.currentThread());
    }

}

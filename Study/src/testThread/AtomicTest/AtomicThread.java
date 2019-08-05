package testThread.AtomicTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现线程的原子性操作
 */
public class AtomicThread {

    //int i = 0;
    AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) {

        AtomicThread test = new AtomicThread();
        // 创建2个线程
        for (int a = 0; a < 2; a++) {
            new Thread(()->{
                for (int b = 0; b < 100000; b++) {
                    test.add();
                }
                System.out.println(test.i);
            }).start();
        }
    }

    public void add() {
        //i++;  设置成原子类Integer之后无法进行i++操作，这时使用Atomic类提供的自增方法
        i.getAndIncrement();
    }

    /**
     * 总结
     *  多线程环境下，变量没有原子性的原因：
     *      在本例子中，当一个线程对i变量进行操作时主要分以下3个步骤
     *          1.获取i的值
     *          2.i值+1
     *          3.给i赋值
     *      在多个线程环境下，在第3步中可能会相互覆盖，造成达不到预期结果
     *      这是因为对i变量的操作没有原子性造成的，要使得i变量变得有原子性有一下方法：
     *          synchronized        基于悲观锁的思想，也实现了可见性
     *          Atomic类             基于CAS乐观锁的思想，没有使用锁
     *          ReentrantLock       可重入锁（未深入研究）
     *
     */
}

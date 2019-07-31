package testThread;

//测试本类中多线程之间共享同一个变量
public class ThreadLocal {

    static int i = 1;

    public static void main(String[] args) {

        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        a.run();
        b.b();

    }

    static class ThreadA implements Runnable {

        @Override
        public void run() {

            System.out.println("线程A--"+(i+1));
        }
    }

    static class ThreadB extends Thread {


        public void b() {
            System.out.println("线程B--"+(i+1));
        }
    }


}

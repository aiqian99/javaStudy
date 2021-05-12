package basis.thread.thread;

/**
 * 测试类
 */
public class ThreadMain {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}

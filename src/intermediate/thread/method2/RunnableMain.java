package intermediate.thread.method2;

/**
 * @Description
 * @Author snail
 */
public class RunnableMain {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable, "线程一");
        Thread t2 = new Thread(runnable, "线程二");
        t1.start();
        t2.start();
    }
}

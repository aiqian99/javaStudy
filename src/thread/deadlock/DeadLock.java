package thread.deadlock;

/**
 * @Description
 * @Author huangjw
 * @Date 2020/2/7 15:05
 */
public class DeadLock {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        new Thread(() -> {
            while (true) {
                synchronized (obj1) {
                    synchronized (obj2) {
                        System.out.println("线程一执行");
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (obj2) {
                    synchronized (obj1) {
                        System.out.println("线程二执行");
                    }
                }
            }
        }).start();
    }
}

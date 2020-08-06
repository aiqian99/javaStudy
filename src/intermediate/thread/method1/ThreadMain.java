package intermediate.thread.method1;

/**
 * @Description
 * @Author snail
 */
public class ThreadMain {
    public static void main(String[] args) {
        // 创建线程对象
        MyThread t1 = new MyThread("线程一");
        MyThread t2 = new MyThread("线程二");
        // 开启线程
        t1.start();
        t2.start();
    }
}

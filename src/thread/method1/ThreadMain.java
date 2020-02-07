package thread.method1;

/**
 * @Description
 * @Author huangjw
 * @Date 2020/2/7 10:41
 */
public class ThreadMain {
    public static void main(String[] args) {
        // 创建线程对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        // 开启线程
        t1.start();
        t2.start();
    }
}

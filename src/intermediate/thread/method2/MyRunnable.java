package intermediate.thread.method2;

/**
 * @Description 实现Runnable接口的方式 创建多线程
 * @Author snail
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ "线程开启了：" + i);
        }
    }
}

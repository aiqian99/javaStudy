package thread.method2;

/**
 * @Description 实现Runnable接口多线程
 * @Author huangjw
 * @Date 2020/2/7 11:07
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+ "线程开启了：" + i);
        }
    }
}

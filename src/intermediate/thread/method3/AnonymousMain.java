package intermediate.thread.method3;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description 匿名类的方式 创建多线程
 * @Author snail
 */
public class AnonymousMain {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程thread1: " + i);
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程thread2: " + i);
            }

        });
        thread2.start();

        // java 线程池
        // 第一个参数10 表示这个线程池初始化了10个线程在里面工作
        // 第二个参数15 表示如果10个线程不够用了，就会自动增加到最多15个线程
        // 第三个参数60 结合第四个参数TimeUnit.SECONDS，表示经过60秒，多出来的线程还没有接到活儿，就会回收，最后保持池子里就10个
        // 第四个参数TimeUnit.SECONDS 如上
        // 第五个参数 new LinkedBlockingQueue() 用来放任务的集合
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        // execute方法用于添加新的任务
        threadPool.execute(() -> System.out.println("任务1"));
    }
}

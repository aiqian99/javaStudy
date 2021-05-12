package basis.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 通过 Callable 和 Future 创建线程
 */
// 创建 Callable 接口的实现类
public class MyCallable implements Callable<Integer> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 使用 FutureTask 类来包装 Callable 对象
        // 该 FutureTask 对象封装了该 Callable 对象 call() 方法的返回值
        FutureTask<Integer> ft = new FutureTask<>(new MyCallable());
        new Thread(ft).start();
        // 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值
        System.out.println("子线程结束后返回的值：" + ft.get());
    }

    // 实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}

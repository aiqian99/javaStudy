package thread.method3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description
 * @Author huangjw
 * @Date 2020/2/7 11:15
 */
public class CallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable callable = new MyCallable();
        FutureTask<String> task = new FutureTask<>(callable);
        Thread t1 = new Thread(task);
        t1.start();
        // 获取线程运行之后的结果；若线程没有运行结束，get方法会在此死等。
        System.out.println(task.get());
        System.out.println("主线程结束!!!");
    }
}

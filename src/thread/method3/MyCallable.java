package thread.method3;

import java.util.concurrent.Callable;

/**
 * @Description
 * @Author huangjw
 * @Date 2020/2/7 11:14
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 50; i++) {
            System.out.println("线程启动了：" + i);
        }
        return "线程执行结束!!!";
    }
}

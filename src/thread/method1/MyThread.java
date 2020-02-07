package thread.method1;

/**
 * @Description 使用继承Thread的方式实现多线程
 * @Author huangjw
 * @Date 2020/2/7 10:37
 */
public class MyThread extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 50; i++) {
            System.out.println("线程开启了：" + i);
        }
    }
}

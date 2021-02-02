package intermediate.thread.method1;


/**
 * @Description 继承Thread的方式 创建多线程
 * @Author snail
 */
public class MyThread extends Thread {

    /**
     * 线程名称
     */
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + " 开启了：" + i);
        }
    }
}

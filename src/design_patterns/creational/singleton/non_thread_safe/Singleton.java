package design_patterns.creational.singleton.non_thread_safe;

/**
 * 基础单例（单线程）
 * @date 2021/2/7
 */
public class Singleton {

    private static Singleton instance;

    public String value;

    private Singleton(String value) {
        // 模拟慢初始化
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}

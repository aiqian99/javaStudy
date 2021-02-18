package design_patterns.creational.singleton.thread_safe;

/**
 * 采用延迟加载的线程安全单例    双重检查锁定(DCL)
 *
 * @date 2021/2/7
 */
public class Singleton {

    private static volatile Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        Singleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}

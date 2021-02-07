package design_patterns.creational.singleton.non_thread_safe;

/**
 * @author snail
 * @date 2021/2/7
 */
public class SingleThreadDemo {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}

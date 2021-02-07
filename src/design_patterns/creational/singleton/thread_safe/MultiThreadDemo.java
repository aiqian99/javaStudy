package design_patterns.creational.singleton.thread_safe;

/**
 * @author snail
 * @date 2021/2/7
 */
public class MultiThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadFoo());
        Thread t2 = new Thread(new ThreadBar());
        t1.start();
        t2.start();
    }

    private static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    private static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}

package basis.thread.producer_consumer;

/**
 * 测试类
 */
public class Demo {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Producer producer = new Producer(warehouse);
        Consumer consumer = new Consumer(warehouse);

        Thread p1 = new Thread(producer);

        Thread c1 = new Thread(consumer);

        p1.start();

        c1.start();

    }
}

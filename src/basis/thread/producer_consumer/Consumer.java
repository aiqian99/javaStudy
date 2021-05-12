package basis.thread.producer_consumer;

/**
 * 消费者
 */
public class Consumer implements Runnable {

    private Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (; ; ) {
            this.warehouse.get();
        }
    }
}

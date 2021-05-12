package basis.thread.producer_consumer;

/**
 * 生产者
 */
public class Producer implements Runnable {

    private Warehouse warehouse;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            this.warehouse.put(i);
        }
    }
}

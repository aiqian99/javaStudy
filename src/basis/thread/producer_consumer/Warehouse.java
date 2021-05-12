package basis.thread.producer_consumer;

/**
 * 仓库类
 */
public class Warehouse {

    /** 商品 */
    private int goods;

    /** 仓库中是否有商品标识 */
    private boolean flag = false;

    /** 没加 synchronized 将抛出 java.lang.IllegalMonitorStateException 异常 */
    public synchronized void put(int goods) {
        // 有商品时 生产者等待生产
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goods = goods;
        System.out.println("生产者将商品 " + goods + " 号放入仓库");
        // 标记仓库中有商品
        flag = true;
        // 唤醒其它等待线程
        notifyAll();
    }

    /** 没加 synchronized 将抛出 java.lang.IllegalMonitorStateException 异常 */
    public synchronized void get() {
        // 无商品时 消费者等待消费
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者将商品 " + goods + " 号取出仓库");
        // 标记仓库中无商品
        flag = false;
        // 唤醒其它等待线程
        notifyAll();
    }

}

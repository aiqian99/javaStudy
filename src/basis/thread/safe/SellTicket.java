package basis.thread.safe;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 卖票线程
 *
 * @date 2021/5/12
 */
public class SellTicket implements Runnable {

    private int tickets = 100;

    private int flag = 0;

    private Object obj = new Object();

    private Lock lock = new ReentrantLock();

    /** 使用 Lock 锁 */
    @Override
    public void run() {
        for (; ; ) {
            lock.lock();
            try {
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出 " + tickets + " 号票");
                    tickets--;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /** 使用 synchronized 关键字 */
    /*@Override
    public void run() {
        for (; ; ) {
            if (flag%2 == 0) {
                //同步代码块
                // 此处如果这样写 代表每一个线程都有独立的线程锁，而我们需要三个线程共用一个线程锁
                // synchronized (new Object()) {

                // 同步代码块写法 synchronized (obj) {
                // 同步普通方法写法 synchronized (this) {
                // 同步静态方法写法 synchronized (SellTicket.class) {
                synchronized (this) {
                    if (tickets > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "卖出 " + tickets + " 号票");
                        tickets--;
                    }
                }
            } else {
                // 同步普通方法
                sell();
                // 同静态方法
                //sellStatic();
            }
            flag++;
        }
    }*/

    /** 同步普通方法 */
    private synchronized void sell() {
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出 " + tickets + " 号票");
            tickets--;
        }
    }

    /** 同步静态方法 */
    /*private static synchronized void sellStatic() {
        if (tickets > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出 " + tickets + " 号票");
            tickets--;
        }
    }*/

}

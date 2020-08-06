package intermediate.thread.ticket;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 多线程卖票实例  卖票延迟100ms
 * @Author snail
 */
public class Ticket implements Runnable {
    private int ticketCount = 50;

    private Object object = new Object();

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        /*同步代码块
        synchronized 默认为打开，当有线程进入时，锁关闭；当该线程执行结束后锁再次开启
        优点：保证了多线程的安全
        缺点：使用锁后线程每次进入都需要判断锁，消耗资源
        */
        /*while (true) {
            synchronized (object) {
                if (ticketCount <= 0) {
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ticketCount--;
                System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余" + ticketCount + "张票!");

            }
        }*/


        while (true) {
            lock.lock();
            try {
                if (ticketCount <= 0) {
                    break;
                }

                Thread.sleep(100);

                ticketCount--;
                System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余" + ticketCount + "张票!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


    }
}

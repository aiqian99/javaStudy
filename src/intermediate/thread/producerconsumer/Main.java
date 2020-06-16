package intermediate.thread.producerconsumer;

/**
 * @Description 生产者 - 消费者
 * @Author huangjw
 * @Date 2020/2/7 15:45
 */
public class Main {
    public static void main(String[] args) {
        Article article = new Article();

        Producer producer = new Producer(article);
        Consumer consumer = new Consumer(article);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();

    }
}

package intermediate.thread.producerconsumer;

/**
 * @Description 生产者
 * @Author snail
 */
public class Producer implements Runnable {

    private Article article;

    public Producer(Article article) {
        this.article = article;
    }

    // 1. 判断是否有物品 有则等待 没有则生产
    // 2. 生产物品后 记录物品已有  唤醒消费者开始消费物品
    @Override
    public void run() {
        while (true) {
            synchronized (article.getLock()) {
                if (article.getCount() <= 0) {
                    break;
                } else {
                    if (article.getFlag()) {
                        try {
                            article.getLock().wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("生产者开始生产...");
                        article.setFlag(true);
                        article.getLock().notifyAll();
                    }
                }
            }
        }
    }
}

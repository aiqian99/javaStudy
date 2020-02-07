package thread.producerconsumer;

/**
 * @Description 消费者
 * @Author huangjw
 * @Date 2020/2/7 15:44
 */
public class Consumer implements Runnable{

    private Article article;

    public Consumer(Article article) {
        this.article = article;
    }

    //1. 消费品判断是否有物品
    //2. 没有则等待
    //3. 有则开始消费  记录物品已无 通知生产者生产 同时物品总数减一
    @Override
    public void run() {
        while (true) {
            synchronized (article.getLock()) {
                if (article.getCount() <= 0) {
                    break;
                } else {
                    if (article.getFlag()) {
                        System.out.println("消费者开始消费...");
                        article.setFlag(false);
                        article.getLock().notifyAll();
                        article.setCount(article.getCount() - 1);
                    } else {
                        try {
                            article.getLock().wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

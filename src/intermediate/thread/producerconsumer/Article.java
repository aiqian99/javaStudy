package intermediate.thread.producerconsumer;

/**
 * @Description 物品
 * @Author huangjw
 * @Date 2020/2/7 15:45
 */
public class Article {

    // 标记  true 表示物品存在  false 表示物品不存在
    private Boolean flag;

    // 物品总数量 默认 5 个
    private Integer count;

    // 对象锁
    private final Object lock = new Object();

    public Article() {
        this(false,5);
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getLock() {
        return lock;
    }

    public Article(Boolean flag, Integer count) {
        this.flag = flag;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Article{" +
                "flag=" + flag +
                ", count=" + count +
                ", lock=" + lock +
                '}';
    }
}

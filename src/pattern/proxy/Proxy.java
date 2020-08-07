package pattern.proxy;

/**
 * @Description 代理模式（Proxy Pattern） /委托模式
 * definition: Provide a surrogate or placeholder for another object to control access to it.
 * 定义： 为其他对象提供 一种代理以控制对这个对象的访问。
 * @Author snail
 */
public class Proxy implements Subject {
    private Subject subject;

    public Proxy() {
        this.subject = new Proxy();
    }

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    private void before() {
        System.out.println("预处理...");
    }

    private void after() {
        System.out.println("善后...");
    }
}

package pattern.proxy;

/**
 * @Description
 * @Author huangjw27915
 * @Date 2020/8/7 15:52
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject...request...");
    }
}

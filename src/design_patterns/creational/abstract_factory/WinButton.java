package design_patterns.creational.abstract_factory;

/**
 * 具体产品
 * @date 2021/2/3
 */
public class WinButton implements Button {

    @Override
    public void paint() {
        System.out.println("WinButton paint");
    }
}

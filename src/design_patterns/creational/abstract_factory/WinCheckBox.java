package design_patterns.creational.abstract_factory;

/**
 * 具体产品
 * @date 2021/2/3
 */
public class WinCheckBox implements CheckBox {

    @Override
    public void paint() {
        System.out.println("WinCheckBox paint");
    }
}

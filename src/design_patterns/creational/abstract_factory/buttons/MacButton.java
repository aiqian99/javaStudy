package design_patterns.creational.abstract_factory.buttons;

import design_patterns.creational.abstract_factory.buttons.Button;

/**
 * 具体产品
 * @date 2021/2/3
 */
public class MacButton implements Button {

    @Override
    public void paint() {
        System.out.println("MacButton paint");
    }
}

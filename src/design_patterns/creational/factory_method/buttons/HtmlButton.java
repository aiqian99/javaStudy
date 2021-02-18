package design_patterns.creational.factory_method.buttons;

import design_patterns.creational.factory_method.buttons.Button;

/**
 * 具体产品
 * @date 2021/2/2
 */
public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("HtmlButton render");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("HtmlButton onClick");
    }
}

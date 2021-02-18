package design_patterns.creational.factory_method.factory;

import design_patterns.creational.factory_method.buttons.Button;

/**
 * 具体创建者
 * @date 2021/2/2
 */
public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

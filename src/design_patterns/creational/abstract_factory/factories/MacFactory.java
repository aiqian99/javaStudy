package design_patterns.creational.abstract_factory.factories;

import design_patterns.creational.abstract_factory.buttons.Button;
import design_patterns.creational.abstract_factory.buttons.MacButton;
import design_patterns.creational.abstract_factory.checkboxes.CheckBox;
import design_patterns.creational.abstract_factory.checkboxes.MacCheckBox;

/**
 * 具体工厂
 * @date 2021/2/3
 */
public class MacFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

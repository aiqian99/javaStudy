package design_patterns.creational.abstract_factory.factories;

import design_patterns.creational.abstract_factory.buttons.Button;
import design_patterns.creational.abstract_factory.buttons.WinButton;
import design_patterns.creational.abstract_factory.checkboxes.CheckBox;
import design_patterns.creational.abstract_factory.checkboxes.WinCheckBox;

/**
 * 具体工厂
 * @date 2021/2/3
 */
public class WinFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WinCheckBox();
    }
}

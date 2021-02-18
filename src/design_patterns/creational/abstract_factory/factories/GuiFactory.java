package design_patterns.creational.abstract_factory.factories;

import design_patterns.creational.abstract_factory.buttons.Button;
import design_patterns.creational.abstract_factory.checkboxes.CheckBox;

/**
 * 抽象工厂
 * @date 2021/2/3
 */
public interface GuiFactory {

    Button createButton();

    CheckBox createCheckBox();

}

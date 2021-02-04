package design_patterns.creational.abstract_factory;

/**
 * 抽象工厂
 * @date 2021/2/3
 */
public interface GuiFactory {

    Button createButton();

    CheckBox createCheckBox();

}

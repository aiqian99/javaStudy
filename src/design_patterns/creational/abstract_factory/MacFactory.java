package design_patterns.creational.abstract_factory;

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

package design_patterns.creational.abstract_factory;

/**
 * 客户端
 * @date 2021/2/4
 */
public class Application {

    private Button button;

    private CheckBox checkBox;

    public Application(GuiFactory guiFactory) {
        button = guiFactory.createButton();
        checkBox = guiFactory.createCheckBox();
    }

    public void paint() {
        button.paint();
        checkBox.paint();
    }

}

package design_patterns.creational.factory_method;

/**
 * 具体创建者
 * @date 2021/2/2
 */
public class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}

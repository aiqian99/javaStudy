package design_patterns.creational.factory_method;

/**
 * @author snail
 * @date 2021/2/2
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {
        Dialog dialog;
        if ("Windows 10".equals(System.getProperty("os.name"))) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
        dialog.renderWindow();
    }
}

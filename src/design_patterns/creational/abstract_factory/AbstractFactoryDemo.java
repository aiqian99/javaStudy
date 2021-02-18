package design_patterns.creational.abstract_factory;

import design_patterns.creational.abstract_factory.app.Application;
import design_patterns.creational.abstract_factory.factories.GuiFactory;
import design_patterns.creational.abstract_factory.factories.MacFactory;
import design_patterns.creational.abstract_factory.factories.WinFactory;

/**
 * @author snail
 * @date 2021/2/4
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        GuiFactory factory;
        Application app;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacFactory();
            app = new Application(factory);
        } else {
            factory = new WinFactory();
            app = new Application(factory);
        }
        app.paint();
    }
}

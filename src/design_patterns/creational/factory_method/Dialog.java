package design_patterns.creational.factory_method;

/**
 * 基础创建者
 * @date 2021/2/2
 */
public abstract class Dialog {

    public void renderWindow(){
        System.out.println("Dialog renderWindow");
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();

}

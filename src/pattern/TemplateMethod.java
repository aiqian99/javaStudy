package pattern;

/**
 * @Description 模板方法模式 （Template Method Pattern）
 * definition: Define the skeleton of an algorithm in an operation,deferring some steps to subclasses.Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
 * 定义：定义一个操作中的算法的框架，而将一些步骤延迟到子类中。使得子类可以不改 变一个算法的结构即可重定义该算法的某些特定步骤。
 * @Author snail
 */
public class TemplateMethod {
    public static void main(String[] args) {
        AbstractClass class1 = new ConcreteClass1();
        class1.templateMethod();
        AbstractClass class2 = new ConcreteClass2();
        class2.templateMethod();
    }
}

/**
 * 抽象模板类
 */
abstract class AbstractClass {
    /**
     * 基本方法
     */
    protected abstract void doSomething();

    protected abstract void doAnything();

    /**
     * 模板方法
     */
    public void templateMethod() {
        doSomething();
        doAnything();
    }
}

/**
 * 具体模板类1
 */
class ConcreteClass1 extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("ConcreteClass1...doSomething...");
    }

    @Override
    protected void doAnything() {
        System.out.println("ConcreteClass1...doAnything...");
    }
}

/**
 * 具体模板类2
 */
class ConcreteClass2 extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("ConcreteClass2...doSomething...");
    }

    @Override
    protected void doAnything() {
        System.out.println("ConcreteClass2...doAnything...");
    }
}
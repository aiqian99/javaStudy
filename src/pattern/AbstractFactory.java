package pattern;

/**
 * @Description 抽象工厂模式（Abstract Factory Pattern）
 * definition: Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
 * 定义：为创建一组相关或相互依赖的对象提供一个接口，而且无须指定它们的具体类。
 * @Author snail
 */
public class AbstractFactory {
    public static void main(String[] args) {
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();
        AbstractProductA productA1 = creator1.createProduceA();
        productA1.doSomething();
        AbstractProductA productA2 = creator2.createProduceA();
        productA2.doSomething();
        AbstractProductB productB1 = creator1.createProduceB();
        productB1.doSomething();
        AbstractProductB productB2 = creator2.createProduceB();
        productB2.doSomething();
    }
}

/**
 * 抽象产品A类
 */
abstract class AbstractProductA {
    public void shareMethod() {
    }

    public abstract void doSomething();
}

/**
 * 产品A1
 */
class ProductA1 extends AbstractProductA {

    @Override
    public void doSomething() {
        System.out.println("ProductA1...");
    }
}

/**
 * 产品A2
 */
class ProductA2 extends AbstractProductA {

    @Override
    public void doSomething() {
        System.out.println("ProductA2...");
    }
}

/**
 * 抽象产品B类
 */
abstract class AbstractProductB {
    public void shareMethod() {
    }

    public abstract void doSomething();
}

/**
 * 产品B1
 */
class ProductB1 extends AbstractProductB {

    @Override
    public void doSomething() {
        System.out.println("ProductB1...");
    }
}

/**
 * 产品B2
 */
class ProductB2 extends AbstractProductB {

    @Override
    public void doSomething() {
        System.out.println("ProductB2...");
    }
}

/**
 * 抽象工厂类
 */
abstract class AbstractCreator {

    public abstract AbstractProductA createProduceA();

    public abstract AbstractProductB createProduceB();

}

/**
 * 产品1抽象工厂 实现类
 */
class Creator1 extends AbstractCreator {

    @Override
    public AbstractProductA createProduceA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProduceB() {
        return new ProductB1();
    }
}

/**
 * 产品2抽象工厂 实现类
 */
class Creator2 extends AbstractCreator {

    @Override
    public AbstractProductA createProduceA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProduceB() {
        return new ProductB2();
    }
}
package pattern;

/**
 * @Description 工厂方法模式
 * definition: Define an interface for creating an object,but let subclasses decide which class to instantiate.
 * Factory Method lets a class defer instantiation to subclasses.
 * 定义：定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。
 * @Author snail
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product1 = creator.createProduct(ConcreteProduct1.class);
        product1.method2();
        Product product2 = creator.createProduct(ConcreteProduct2.class);
        product2.method2();
    }
}

/**
 * 抽象产品类
 */
abstract class Product {
    public void method1() {}

    public abstract void method2();
}

/**
 * 具体产品类1
 */
class ConcreteProduct1 extends Product {

    @Override
    public void method2() {
        System.out.println("ConcreteProduct1...");
    }
}

/**
 * 具体产品类2
 */
class ConcreteProduct2 extends Product {

    @Override
    public void method2() {
        System.out.println("ConcreteProduct2...");
    }
}

/**
 * 抽象工厂类
 */
abstract class Creator {

    public abstract <T extends Product> T createProduct(Class<T> c);

}

/**
 * 具体工厂类
 */
class ConcreteCreator extends Creator {

    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
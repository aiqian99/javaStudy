package pattern;

/**
 * @Description 建造者模式（Builder Pattern）
 * definition: Separate the construction of a complex object from its representation so that the same construction process can create different representations.
 * 定义：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * @Author snail
 */
public class Builder {
}

/**
 * 产品类
 */
class BuilderProduct{
    public void doSomething() {

    }
}

/**
 * 抽象建造者
 */
abstract class AbstractBuilder{
    public abstract void setPart();
    public abstract BuilderProduct buildProduct();
}

/**
 * 具体建造者
 */
class ConcreteProduct extends AbstractBuilder{
    private BuilderProduct product= new BuilderProduct();
    @Override
    public void setPart() {
        System.out.println("ConcreteProduct...setPart...");
    }
    @Override
    public BuilderProduct buildProduct() {
        return product;
    }
}

class Director{
    private AbstractBuilder builder = new ConcreteProduct();
    public BuilderProduct getAProduct() {
        builder.setPart();
        return builder.buildProduct();
    }
}
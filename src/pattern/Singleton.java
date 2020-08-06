package pattern;

/**
 * @Description 单例模式（Singleton Pattern）
 * definition: Ensure a class has only one instance, and provide a global point of access to it.
 * 定义：确保某一个类 只有一个实例，而且自行实例化并向整个系统提供这个实例。
 * @Author snail
 */
public class Singleton {

    private static final Singleton singlenton = new Singleton();

    private Singleton() {

    }

    public static Singleton getSinglenton() {
        return singlenton;
    }

    public static void doSomething() {
        System.out.println("singlenton...");
    }

    public static void main(String[] args) {
        Singleton singleton = getSinglenton();
    }
}

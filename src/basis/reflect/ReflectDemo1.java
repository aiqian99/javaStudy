package basis.reflect;

/**
 * 获取 Class 类型对象的三种方式
 * 1、使用类的 class 属性来获取该类对应的 Class 对象
 *      用途：多用于参数的传递
 * 2、调用对象的 getClass() 方法，返回该对象所属类对应的 Class 对象
 *      因为该方法是 Object 类中的方法，所以所有的 Java 对象都可以调用该方法
 *      用途：多用于对象的获取字节码的方式
 * 3、使用 Class 类中的静态方法 forName(String className)，该方法需要传入字符串参数，该字符串参数的值是某个类的全路径，也就是完整包名的路径
 *      用途：多用于配置文件，将类名定义在配置文件中。读取文件，加载类
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 使用类的 class 属性
        Class<Person> c = Person.class;
        System.out.println(c);
        // 调用对象的 getClass() 方法
        Person person = new Person();
        Class<? extends Person> c2 = person.getClass();
        System.out.println(c2 == c);
        // 使用 Class 类中的静态方法 forName(String className)
        Class<?> c3 = Class.forName("basis.reflect.Person");
        System.out.println(c3 == c);
        // 输出两个true 可得结论： 同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取的class对象都是同一个。

    }
}

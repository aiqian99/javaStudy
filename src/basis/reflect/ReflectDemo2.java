package basis.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射获取构造方法 及 使用构造方法创建对象
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 使用 Class 类中的静态方法 forName(String className) 获取 Class 对象
        Class<?> c = Class.forName("basis.reflect.Person");

        System.out.println("--返回一个包含所有公共构造方法的数组--");
        Constructor<?>[] con = c.getConstructors();
        for (Constructor<?> constructor : con) {
            System.out.println(constructor);
        }

        System.out.println("--返回一个包含所有构造方法的数组--");
        Constructor<?>[] con2 = c.getDeclaredConstructors();
        for (Constructor<?> constructor : con2) {
            System.out.println(constructor);
        }

        System.out.println("--返回单个公共构造方法对象--");
        Constructor<?> con3 = c.getConstructor();
        System.out.println(con3);

        System.out.println("--返回单个构造方法对象--");
        Constructor<?> con4 = c.getDeclaredConstructor(String.class, int.class, String.class);
        System.out.println(con4);

        System.out.println("--根据指定的构造方法创建对象--");
        Object obj = con3.newInstance();
        System.out.println(obj);

        // setAccessible(true) 即取消访问检查；
        // 若没有设置该值为 true，则会抛出异常java.lang.IllegalAccessException，因为编译器默认不能通过私有构造方法创建对象
        con4.setAccessible(true);
        System.out.println("--根据指定的构造方法创建对象--");
        Object obj2 = con4.newInstance("张三", 23, "杭州");
        System.out.println(obj2);
    }
}

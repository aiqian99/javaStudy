package basis.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射获取成员方法 及 调用成员方法
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 使用 Class 类中的静态方法 forName(String className) 获取 Class 对象
        Class<?> c = Class.forName("basis.reflect.Person");

        System.out.println("--返回一个包含所有公共成员方法的数组，包括继承的--");
        Method[] m = c.getMethods();
        for (Method method : m) {
            System.out.println(method);
        }

        System.out.println("--返回一个包含所有成员方法的数组，不包括继承的--");
        Method[] m2 = c.getDeclaredMethods();
        for (Method method : m2) {
            System.out.println(method);
        }

        System.out.println("--返回单个公共成员方法对象--");
        Method m3 = c.getMethod("getName");
        System.out.println(m3);

        System.out.println("--返回单个成员方法对象--");
        Method m4 = c.getDeclaredMethod("setSex", String.class);
        System.out.println(m4);

        System.out.println("--调用对象的指定成员方法--");
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        // setAccessible(true) 即取消访问检查；
        // 若没有设置该值为 true，则会抛出异常java.lang.IllegalAccessException，因为编译器默认不能访问对象的私有成员方法
        m4.setAccessible(true);
        m4.invoke(obj, "女");
        System.out.println(obj);
    }
}

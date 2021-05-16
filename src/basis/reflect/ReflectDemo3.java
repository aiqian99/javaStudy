package basis.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射获取成员变量 及 设置成员变量值
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 使用 Class 类中的静态方法 forName(String className) 获取 Class 对象
        Class<?> c = Class.forName("basis.reflect.Person");

        System.out.println("--返回一个包含所有公共成员变量的数组--");
        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("--返回一个包含所有成员变量的数组--");
        Field[] fields2 = c.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field);
        }

        System.out.println("--返回单个公共成员变量对象--");
        Field field3 = c.getField("name");
        System.out.println(field3);

        System.out.println("--返回单个成员变量对象--");
        Field field4 = c.getDeclaredField("sex");
        System.out.println(field4);

        System.out.println("--给对象指定成员变量赋值--");
        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();
        // setAccessible(true) 即取消访问检查；
        // 若没有设置该值为 true，则会抛出异常java.lang.IllegalAccessException，因为编译器默认不能访问对象的私有成员变量
        //field4.setAccessible(true);
        field4.set(obj, "男");
        System.out.println(obj);
    }
}

package basis.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射的场景使用
 */
public class ReflectTest {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
        // 加载配置文件数据
        Properties prop = new Properties();
        FileReader fr = new FileReader("src\\basis\\reflect\\reflect.txt");
        prop.load(fr);

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        // 通过反射获取配置文件指定的类对象
        Class<?> c = Class.forName(className);
        Constructor<?> cons = c.getConstructor();
        Object obj = cons.newInstance();

        // 通过反射获取配置文件指定的类对象的类方法
        Method method = c.getDeclaredMethod(methodName);
        method.invoke(obj);

    }
}

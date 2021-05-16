package basis.reflect;

/**
 * 类加载器 ClassLoader 的使用
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        // 应用程序类加载器
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println(cl);
        // 平台类加载器
        ClassLoader cl2 = cl.getParent();
        System.out.println(cl2);
        // 虚拟机的内置类加载器
        ClassLoader cl3 = cl2.getParent();
        System.out.println(cl3);
    }
}

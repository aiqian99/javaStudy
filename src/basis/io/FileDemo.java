package basis.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * File 类的简单使用
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        /* File 构造方法  创建新的 File 实例 */
        // 通过将给定的路径名字符串转换为抽象路径名来创建新的 File 实例
        File f1 = new File("D//test123//123.txt");
        System.out.println(f1);
        // 从父路径名字符串和子路径名字符串创建新的 File 实例
        File f2 = new File("D//test123", "123.txt");
        System.out.println(f2);
        // 从父抽象路径名和子路径名字符串创建新的 File 实例
        File f3 = new File(new File("D//test123"), "123.txt");
        System.out.println(f3);
        System.out.println("--------");

        /* File 创建文件或目录的方法 */
        // 相对路径 创建多级目录 创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录
        File fi1 = new File("a666");
        System.out.println(fi1.mkdirs());
        // 绝对路径 创建多级目录
        File fi2 = new File("D://a666");
        System.out.println(fi2.mkdirs());
        // 创建单级目录 创建由此抽象路径名命名的目录
        File fi3 = new File("D://a666//b666");
        System.out.println(fi3.mkdir());
        // 创建文件
        File fi4 = new File("D://a666//b666//java.txt");
        System.out.println(fi4.mkdir());
        System.out.println("--------");

        /* File 创建文件或目录的方法 */
        File fil1 = new File("D://a666//b666");
        // 测试此抽象路径名表示的文件是否为目录
        System.out.println(fil1.isDirectory());
        // 测试此抽象路径名表示的文件是否为普通文件
        System.out.println(fil1.isFile());
        // 测试此抽象路径名表示的文件或目录是否存在
        System.out.println(fil1.exists());
        // 返回此抽象路径名的绝对路径名字符串
        System.out.println(fil1.getAbsolutePath());
        // 将此抽象路径名转换为路径名字符串
        System.out.println(fil1.getPath());
        // 返回由此抽象路径名表示的文件或目录的名称
        System.out.println(fil1.getName());
        // 返回一个字符串数组，命名由此抽象路径名表示的目录中的文件和目录
        System.out.println(Arrays.toString(fil1.list()));
        // 返回一个抽象路径名数组，表示由该抽象路径名表示的目录中的文件
        System.out.println(Arrays.toString(fil1.listFiles()));
        System.out.println("--------");
        // 获取相对路径目录的路径名
        File fil4 = new File("a666//b666");
        System.out.println(fil4.getAbsolutePath());
        System.out.println(fil4.getPath());

        /* File 删除方法 */
        // 如果一个目录中有内容(目录，文件)，则不能直接删除。应该先删除目录中的内容，最后才能删除目录
        // 删除由此抽象路径名表示的文件或目录
        File file1 = new File("D://a666//b666");
        System.out.println(file1.delete());
        File file2 = new File("D://a666//b666//java.txt");
        System.out.println(file2.delete());
        System.out.println(file1.delete());

    }
}

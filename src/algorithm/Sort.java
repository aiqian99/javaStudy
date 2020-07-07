package algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Description 排序算法
 * @Author huangjw
 * @Date 2020/6/28 16:28
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[50];
        Random random = new Random(27);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        long start = System.currentTimeMillis();
        arr = insertionSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("time is :" + (end - start));
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    /**
     * @param arr 1
     * @description: 选择排序  N²/2次比较、N次交换
     * 在未排序数组段中找到最小的数字放在已排序数组段的最后面
     * 运行时间和输入无关、数据移动是最少的
     * @return: int[]
     */
    public static int[] selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            // 最小元素的索引
            int min = i;
            for (int j = i + 1; j < len; j++) {
                // 找到未排序数组段中最小元素的索引
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 交换位置
            int swap = arr[i];
            arr[i] = arr[min];
            arr[min] = swap;
        }
        return arr;
    }

    /**
     * @param arr 1
     * @description: 插入排序 平均N²/4次比较和N²/4次交换，最坏N²/2次比较和N²/2次交换，最好N-1次比较和0次交换
     * 依次取出未排序序列数据，在已排序序列中从后向前扫描，比较大小找到相应位置并插入
     * @return: int[]
     */
    public static int[] insertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            // 将arr[i] 插入到 arr[i-1], arr[i-2], arr[i-3]...之中
            for (int j = i; j >= 1 && arr[j] < arr[j - 1]; j--) {
                int swap = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = swap;
            }
        }
        return arr;
    }

    /**
     * @param arr 1
     * @description: 冒泡排序
     * 重复地遍历要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来
     * @return: int[]
     */
    public static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
        return arr;
    }

    /**
     * @param arr 1
     * @description: 希尔排序
     * 希尔排序是把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
     * @return: int[]
     */
    public static int[] shellSort(int[] arr) {
        int len = arr.length;
        int h = 1;
        // 计算递增序列初始值
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < len; i++) {
                // 将arr[i] 插入到 arr[j-h], arr[j-2*h], arr[j-3*h]...之中
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    int swap = arr[j];
                    arr[j] = arr[j - h];
                    arr[j - h] = swap;
                }
            }
            h = h / 3;
        }
        return arr;
    }

}

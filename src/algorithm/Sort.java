package algorithm;

import java.util.Random;

/**
 * @Description 排序算法
 * @Author snail
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random(27);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    /**
     * @Description: 选择排序   O(n²)   O(1)    不稳定
     * 将未排序数组段中的最小数字 与 已排序数组段的下一位数字交换位置
     * 运行时间和输入无关、数据移动是最少的
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
     * @Description: 插入排序   O(n²)   O(1)    稳定
     * 依次取出未排序序列数据，在已排序序列中从后向前扫描，比较大小找到相应位置并插入
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
     * @Description: 冒泡排序   O(n²)   O(1)    稳定
     * 重复地遍历要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来
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
     * @Description: 希尔排序   O(n log n)   O(1)    不稳定
     * 希尔排序是把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，
     * 当增量减至1时，整个文件恰被分成一组，算法便终止。
     */
    public static int[] shellSort(int[] arr) {
        int len = arr.length;
        int h = 1;
        int N = 3;
        // 计算递增序列初始值
        while (h < len / N) {
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

    /**
     * @Description: 快速排序   O(n log n)   O(n log n)    不稳定
     * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     */
    public static int[] quickSort(int[] arr, int start, int end) {
        if (start < 0 || end >= arr.length || start > end) {
            return null;
        }
        int smallIndex = partition(arr, start, end);
        if (smallIndex > start) {
            quickSort(arr, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            quickSort(arr, smallIndex + 1, end);
        }
        return arr;
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = (int) (Math.random() * (end - start + 1) + start);
        swap(arr, pivot, end);
        int smallIndex = start - 1;
        for (int i = start; i <= end; i++) {
            if (arr[i] <= arr[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(arr, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

}

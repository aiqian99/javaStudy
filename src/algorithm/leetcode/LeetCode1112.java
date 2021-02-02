package algorithm.leetcode;

import java.util.HashMap;

/**
 * @author snail
 * @description 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。。
 */
public class LeetCode1112 {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        for (int i : relativeSortArray(arr1, arr2)) {
            System.out.print(i + ",");
        }
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] book = new int[1001];
        // 对arr1中出现的数字计数
        for (int i : arr1) {
            book[i]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        // 根据arr2数字出现顺序和book中的计数 把arr1数字填入ans
        for (int i : arr2) {
            for (int j = book[i]; j > 0; j--) {
                ans[index++] = i;
                book[i]--;
            }
        }
        // 遍历book，当值大于0时，即为arr1中 未在arr2中出现过的元素
        for (int i = 0; i < book.length; i++) {
            for (int j = book[i]; j > 0; j--) {
                ans[index++] = i;
            }
        }
        return ans;
    }

}

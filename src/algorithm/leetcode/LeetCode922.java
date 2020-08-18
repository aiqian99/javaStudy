package algorithm.leetcode;

/**
 * @Description 按奇偶排序数组 II      时间：O(n) 空间：O(1)
 * 给定一个非负整数数组 A， A中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当A[i]为奇数时，i也是奇数；当A[i]为偶数时，i也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * @Author snail
 */
public class LeetCode922 {

    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 != 0) {
                    j += 2;
                }
                int swap = A[i];
                A[i] = A[j];
                A[j] = swap;
            }
        }
        return A;
    }

}

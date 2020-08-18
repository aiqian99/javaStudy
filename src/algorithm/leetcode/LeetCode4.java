package algorithm.leetcode;

/**
 * @Description 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * @Author snail
 */
public class LeetCode4 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int totalLen = len1 + len2;
        if (totalLen % 2 == 0) {
            int mid = totalLen / 2;
            return (getMidNum(nums1, nums2, mid) + getMidNum(nums1, nums2, mid + 1)) / 2.0;
        } else {
            int mid = totalLen / 2;
            return getMidNum(nums1, nums2, mid + 1);
        }
    }

    private static double getMidNum(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        // 记录偏移量
        int offset1 = 0, offset2 = 0;
        while (true) {
            // 当有数组为空时
            if (offset1 == len1) {
                return nums2[offset2 + k - 1];
            }
            if (offset2 == len2) {
                return nums1[offset1 + k - 1];
            }
            // 找到目标值
            if (k == 1) {
                return Math.min(nums1[offset1], nums2[offset2]);
            }
            int mid = k / 2;
            // 防止越界
            int n1 = Math.min(mid + offset1, len1) - 1;
            int n2 = Math.min(mid + offset2, len2) - 1;
            if (nums1[n1] <= nums2[n2]) {
                k -= n1 - offset1 + 1;
                offset1 = n1 + 1;
            } else {
                k -= n2 - offset2 + 1;
                offset2 = n2 + 1;
            }
        }
    }

}

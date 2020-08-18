package algorithm.leetcode;

import java.util.*;

/**
 * @Description 两个数组的交集 II   哈希表  时间：O(m+n) 空间：O(min(m,n))
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @Author snail
 */
public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) == null) {
                map.put(nums1[i], 1);
            } else {
                int n = map.get(nums1[i]);
                map.put(nums1[i], ++n);
            }
        }
        int[] ans = new int[nums1.length];
        int end = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map.get(nums2[i]) != null && map.get(nums2[i]) > 0) {
                ans[end] = nums2[i];
                end++;
                int n = map.get(nums2[i]);
                map.put(nums2[i], --n);
            }
        }
        return Arrays.copyOfRange(ans, 0, end);
    }

}

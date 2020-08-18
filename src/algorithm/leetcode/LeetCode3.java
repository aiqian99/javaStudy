package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author snail
 */
public class LeetCode3 {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 记录字符是否出现过
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int max = 0;
        // 右指针
        int rp = -1;
        for (int i = 0; i < chars.length; i++) {
            // 右指针移动 set中加入字符
            while (rp + 1 < chars.length && !set.contains(chars[rp + 1])) {
                set.add(chars[rp + 1]);
                rp++;
            }
            max = Math.max(max, rp - i + 1);
            // 左指针右移 set中去除字符
            set.remove(chars[i]);
        }
        return max;
    }
}

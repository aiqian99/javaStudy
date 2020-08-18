package algorithm.leetcode;

import java.util.Arrays;

/**
 * @Description 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @Author snail
 */
public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int n = t.charAt(i) - 'a';
            count[n]--;
            if (count[n] < 0) {
                return false;
            }
        }
        return true;
    }

}

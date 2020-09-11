package algorithm.leetcode;

/**
 * @author snail
 * @description 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class LeetCode459 {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i < len; i++) {
            if (len % i == 0) {
                int n = len / i;
                String str = s.substring(0, i);
                StringBuilder ans = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    ans.append(str);
                    if (s.equals(ans.toString())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

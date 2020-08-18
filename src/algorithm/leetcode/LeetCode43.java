package algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 字符串相乘   时间：O(mn) 空间：O(m+n)
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @Author snail
 */
public class LeetCode43 {

    public static void main(String[] args) {
        String str1 = "123456789";
        String str2 = "987654321";
        System.out.println(multiply1(str1, str2));
    }

    public static String multiply1(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        // num1和num2的乘积长度为len1 + len2或者len1 + len2 - 1
        int[] arr = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                arr[i + j + 1] += n1 * (num2.charAt(j) - '0');
            }
        }
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] >= 10) {
                arr[i - 1] += arr[i] / 10;
                arr[i] %= 10;
            }
        }
        StringBuilder ans = new StringBuilder();
        if (arr[0] != 0) {
            ans.append(arr[0]);
        }
        for (int i = 1; i < arr.length; i++) {
            ans.append(arr[i]);
        }
        return String.valueOf(ans);
    }

}

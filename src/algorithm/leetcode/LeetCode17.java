package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author snail
 * @description 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LeetCode17 {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int len = digits.length();
        if (len == 0) {
            return ans;
        }
        HashMap<Character, String> map = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        for (int i = 0; i < len; i++) {
            String str = map.get(digits.charAt(i));
            for (int j = 0; j < str.length(); j++) {
                
            }
        }
        return ans;
    }

}

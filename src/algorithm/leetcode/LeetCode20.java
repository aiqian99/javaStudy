package algorithm.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description 有效的括号   时间：O(n)  空间：O(n+∣Σ∣)，Σ 表示map字符集
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * @Author snail
 */
public class LeetCode20 {

    public static void main(String[] args) {
        System.out.println(isValid("[}"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        HashMap map = new HashMap(16) {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || !map.get(ch).equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

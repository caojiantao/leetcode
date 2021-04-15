package cn.caojiantao.study.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 有效的括号
 */
public class q20 {

    public static void main(String[] args) {
        q20 q20 = new q20();
        System.out.println(q20.isValid("()"));
        System.out.println(q20.isValid("()[]{}"));
        System.out.println(q20.isValid("(]"));
        System.out.println(q20.isValid("([)]"));
        System.out.println(q20.isValid("{[]}"));
        System.out.println(q20.isValid("["));
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || !map.get(c).equals(stack.pop())) return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }
}
